package LAB_5.AgendaTelefonica;

import java.util.ArrayList;

public class Agenda {
    // atributos
    private ArrayList<Contato> contatos;

    // metodos
    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato novoContato) {
        contatos.add(novoContato);
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato);
    }

    public void listagemContatos() {
        for (Contato i : contatos) {
            System.out.println("Nome: " + i.getNome());
            System.out.println("Endereço: " + i.getEndereco());
            System.out.println("Telefone: " + i.getTelefone());
            System.out.println("---------");  
        }
    }
}