package app;

import static spark.Spark.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import service.AnimesService;

public class Main {

    private static AnimesService animeService = new AnimesService();

    public static void main(String[] args) {
        port(4567);

        get("/", (request, response) -> {
            response.type("text/html");
            return renderHTMLForm();
        });

        post("/animes", (request, response) -> animeService.add(request, response));
        post("/animes/get", (request, response) -> animeService.get(request, response));
        post("/animes/update", (request, response) -> animeService.update(request, response));
        post("/animes/delete", (request, response) -> animeService.remove(request, response));
        post("/animes/all", (request, response) -> animeService.getAll(request, response));
    }

    private static String renderHTMLForm() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/main/resources/formulario.html")));
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao carregar o formulário.";
        }
    }
}
