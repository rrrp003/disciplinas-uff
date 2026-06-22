package LAB_6.Questao3;

public class Tempo {

    private int totalSegundos;

    // Construtor
    public Tempo(int segundos) {
        this.totalSegundos = segundos;
    }

    private int obterHoras() {
        return this.totalSegundos / 3600;
    }

    private int obterMinutos() {
        return (this.totalSegundos % 3600) / 60;
    }

    private int obterSegundos() {
        
        return this.totalSegundos % 60;
    }

    public void imprimirTempo() {
        System.out.printf("Tempo convertido: %02d:%02d:%02d\n", 
                          obterHoras(), obterMinutos(), obterSegundos());
    }
}