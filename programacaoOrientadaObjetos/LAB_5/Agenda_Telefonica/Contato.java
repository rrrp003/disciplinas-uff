package LAB_5.Agenda_Telefonica;

public class Contato {
    // Atributos privados (Encapsulamento)
    private String nome;
    private String endereco;
    private String telefone; 

    // Construtor
    public Contato(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters para permitir a leitura na classe Agenda
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }

    // Setters (seus métodos de edição)
    public void editarNome(String novoNome) { this.nome = novoNome; }
    public void editarEndereco(String novoEndereco) { this.endereco = novoEndereco; }
    public void editarTelefone(String novoTelefone) { this.telefone = novoTelefone; }
}