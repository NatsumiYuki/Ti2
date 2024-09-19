package model;

public class Animes {

    private int id;
    private String nome;
    private String genero;
    private String autor;
    private int ano;

    public Animes() {
        this.id = -1;
        this.nome = "";
        this.genero = "";
        this.autor = "";
        this.ano = -1;
    }

    public Animes(int id, String nome, String genero, String autor, int ano) {
        setId(id);
        setNome(nome);
        setGenero(genero);
        setAutor(autor);
        setAno(ano);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Animes [id=" + id + ", nome=" + nome + ", gênero=" + genero + ", autor=" + autor + ", ano=" + ano + "]";
    }
}
