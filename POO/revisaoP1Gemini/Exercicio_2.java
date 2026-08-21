package revisaoP1Gemini;

import java.util.Scanner;

public class Exercicio_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, k;
        boolean x = false;

        System.out.printf("digite o tam n do vetor: ");
        n = scanner.nextInt();
        scanner.nextLine();

        int[] vetorA = new int[n];
        int[] vetorB = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Digite o valor a posicao[%d] do vetor: ", i);
            vetorA[i] = scanner.nextInt();
            scanner.nextLine();

            if (i % 2 == 0) {
                vetorB[i] = vetorA[i] * 2;
            } else {
                vetorB[i] = vetorA[i] / 2;
            }
        }

        System.out.printf("Digite um numero para testar se existe no vetorB: ");
        k = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            if (k == vetorB[i]) {
                System.out.printf("Encontramos o %d na posicao[%d]\n", k, i);
                x = true;
            }
        }
        if (x == false)
            System.out.printf("Numero nao encontrado no vetor resultante\n");
        scanner.close();
    }
}
