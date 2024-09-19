package service;

import dao.AnimesDAO;
import model.Animes;
import spark.Request;
import spark.Response;

import java.util.List;

public class AnimesService {

    private AnimesDAO animesDAO;

    public AnimesService() {
        animesDAO = new AnimesDAO();
    }

    public Object add(Request request, Response response) {
        String nome = request.queryParams("nome");
        String genero = request.queryParams("genero");
        String autor = request.queryParams("autor");
        int ano = Integer.parseInt(request.queryParams("ano"));

        Animes anime = new Animes(-1, nome, genero, autor, ano);
        animesDAO.insert(anime);

        response.status(201);
        return "<html><body><div class='message'>Anime cadastrado com sucesso!</div></body></html>";
    }

    public String get(Request request, Response response) {
        String idParam = request.queryParams("id");

        if (idParam == null || idParam.isEmpty()) {
            return "<html><body><div class='error'>Erro: ID não fornecido.</div></body></html>";
        }

        try {
            int id = Integer.parseInt(idParam);
            Animes anime = animesDAO.get(id);

            if (anime == null) {
                return "<html><body><div class='error'>Erro: Anime não encontrado.</div></body></html>";
            }

            StringBuilder retorno = new StringBuilder();
            retorno.append("<html><head><style>");
            retorno.append("body { font-family: Arial, sans-serif; margin: 20px; padding: 0; background-color: #f4f4f4; }");
            retorno.append("div { background: #fff; margin: 10px 0; padding: 15px; border-radius: 5px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }");
            retorno.append(".message { margin-top: 20px; padding: 10px; background-color: #e7f4e4; border: 1px solid #d4e6d0; border-radius: 4px; color: #2e8b57; }");
            retorno.append(".error { background-color: #f4e4e4; border: 1px solid #e6d0d0; color: #d9534f; }");
            retorno.append("</style></head><body>");
            
            retorno.append("<div>");
            retorno.append("Nome: ").append(anime.getNome()).append("<br><br>");
            retorno.append("Gênero: ").append(anime.getGenero()).append("<br><br>");
            retorno.append("Autor: ").append(anime.getAutor()).append("<br><br>");
            retorno.append("Ano: ").append(anime.getAno());
            retorno.append("</div>");
            
            retorno.append("</body></html>");

            return retorno.toString();
        } catch (NumberFormatException e) {
            return "<html><body><div class='error'>Erro: ID inválido.</div></body></html>";
        }
    }

    public Object update(Request request, Response response) {
        String idParam = request.queryParams("id");
        String nome = request.queryParams("nome");
        String genero = request.queryParams("genero");
        String autor = request.queryParams("autor");
        String anoParam = request.queryParams("ano");

        if (idParam == null || idParam.isEmpty()) {
            response.status(400);
            return "<html><body><div class='error'>Erro: ID não fornecido.</div></body></html>";
        }

        try {
            int id = Integer.parseInt(idParam);
            Animes anime = animesDAO.get(id);

            if (anime != null) {
                if (nome != null && !nome.isEmpty()) {
                    anime.setNome(nome);
                }
                if (genero != null && !genero.isEmpty()) {
                    anime.setGenero(genero);
                }
                if (autor != null && !autor.isEmpty()) {
                    anime.setAutor(autor);
                }
                if (anoParam != null && !anoParam.isEmpty()) {
                    anime.setAno(Integer.parseInt(anoParam));
                }

                animesDAO.update(anime);

                return "<html><body><div class='message'>Anime atualizado com sucesso!</div></body></html>";
            } else {
                response.status(404);
                return "<html><body><div class='error'>Anime não encontrado!</div></body></html>";
            }
        } catch (NumberFormatException e) {
            response.status(400);
            return "<html><body><div class='error'>Erro: ID ou ano inválidos.</div></body></html>";
        }
    }

    public Object remove(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Animes anime = animesDAO.get(id);

        if (anime != null) {
            animesDAO.delete(id);
            return "<html><body><div class='message'>Anime removido com sucesso!</div></body></html>";
        } else {
            response.status(404);
            return "<html><body><div class='error'>Anime não encontrado!</div></body></html>";
        }
    }

    public Object getAll(Request request, Response response) {
        List<Animes> animes = animesDAO.getAll();
        StringBuilder retorno = new StringBuilder();

        retorno.append("<html><head><style>");
        retorno.append("body { font-family: Arial, sans-serif; margin: 20px; padding: 0; background-color: #f4f4f4; }");
        retorno.append("ul { list-style-type: none; padding: 0; }");
        retorno.append("li { background: #fff; margin: 10px 0; padding: 15px; border-radius: 5px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }");
        retorno.append(".message { margin-top: 20px; padding: 10px; background-color: #e7f4e4; border: 1px solid #d4e6d0; border-radius: 4px; color: #2e8b57; }");
        retorno.append(".error { background-color: #f4e4e4; border: 1px solid #e6d0d0; color: #d9534f; }");
        retorno.append("</style></head><body>");
        
        retorno.append("<h2>Todos os Animes</h2>");
        
        if (animes.isEmpty()) {
            retorno.append("<p>Não há animes cadastrados.</p>");
        } else {
            retorno.append("<ul>");
            for (Animes anime : animes) {
                retorno.append("<li>");
                retorno.append("ID: ").append(anime.getId()).append("<br><br>");
                retorno.append("Nome: ").append(anime.getNome()).append("<br><br>");
                retorno.append("Gênero: ").append(anime.getGenero()).append("<br><br>");
                retorno.append("Autor: ").append(anime.getAutor()).append("<br><br>");
                retorno.append("Ano: ").append(anime.getAno());
                retorno.append("</li>");
            }
            retorno.append("</ul>");
        }
        
        retorno.append("</body></html>");

        return retorno.toString();
    }
}
