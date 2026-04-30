package LAB_5.AgendaTelefonica;

public class Contato {
    // atributos
    String nome, endereco;
    int telefone;

    // metodos

    public Contato(String nome, String endereco, int telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void editarNome(String novoNome) {
        this.nome = novoNome;
    }

    public void editarEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }

    public void editarTelefone(int novoTelefone) {
        this.telefone = novoTelefone;
    }
}
