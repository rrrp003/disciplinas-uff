package LAB_5.AgendaTelefonica;

public class Main {
    public static void main(String[] args) {
        Contato c1 = new Contato("fulano ", "condominio cheiro de mar 225", 99999999);
        Contato c2 = new Contato("ciclano ", "condominio cheiro de praia 35", 99900999);
        Contato c3 = new Contato("beltrano ", "avenida Marques do ze", 999978999);

        Agenda agendaJuliana = new Agenda();

        agendaJuliana.adicionarContato(c1);
        agendaJuliana.adicionarContato(c2);

        System.out.println("Teste listagem:");

        agendaJuliana.listagemContaos();

        System.out.println("Teste pos edicoes");

        agendaJuliana.removerContato(c2);
        agendaJuliana.adicionarContato(c3);

        agendaJuliana.listagemContaos();
    }

}
