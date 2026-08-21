package LAB_6.Questao3;

import java.util.Scanner;

public class TempoMain {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o tempo total em segundos: ");
        int segundos = teclado.nextInt();

        Tempo t1 = new Tempo(segundos);

        t1.imprimirTempo();

        teclado.close();
    }
}