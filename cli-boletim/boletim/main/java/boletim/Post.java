package boletim;

class Post {
    private int id;
    private String titulo;
    private int boletimId;
    private String conteudo;

    public Post(int id, String titulo, int boletimId, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.boletimId = boletimId;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getBoletimId() {
        return boletimId;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
