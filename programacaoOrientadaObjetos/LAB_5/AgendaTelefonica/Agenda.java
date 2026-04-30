package LAB_5.AgendaTelefonica;

import java.util.ArrayList;

// atributos

public class Agenda {
    ArrayList<Contato> contatos = new ArrayList<>();

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

    public void listagemContaos() {
        for (Contato i : contatos) {
            System.out.println(i.nome);
            System.out.println(i.endereco);
            System.out.println(i.telefone);
        }
    }
}