package LAB_2;

import java.util.Scanner;

/*Leia uma variável t com um tempo qualquer em segundos e imprima esse
valor em hora, minuto e segundo. */
public class exer3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tempo;

        System.out.printf("Digite o valor do tempo em segundos: ");

        tempo = scanner.nextInt();

        System.out.printf("o tempo digitado em hora: %d, minutos: %d, segundos: %d\n", tempo / 3600,
                (tempo % 3600) / 60,
                ((tempo % 3600) % 60) / 60);
        System.out.printf("O tempo no formato %d:%d:%d\n", tempo / 3600, (tempo % 3600) / 60,
                ((tempo % 3600) % 60) / 60);

        scanner.close();

    }
}
