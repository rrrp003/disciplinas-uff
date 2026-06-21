package LAB_5.Emprestimo_livro;

public class Livro {
    //atributos
    private String titulo;
    private String autor;
    private String Genero;
    private int anoPublicacao;

    //metodos

    public Livro(String titulo, String autor, String genero, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.Genero = Genero;
        this.anoPublicacao = anoPublicacao;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    
}
