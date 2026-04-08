package LAB_4;

import java.util.Scanner;

public class L4_e3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k, p;
        System.out.printf("Infome o tamanho do vetor: ");
        n = scanner.nextInt();

        int[] vetor = new int[n];
        // escrita vetor
        for (int i = 0; i < n; i++) {
            System.out.printf("Infome um numero inteiro qualquer [%d]: ", i);
            vetor[i] = scanner.nextInt();
        }
        System.out.printf("Infome um numero para inserir no vetor: ");
        k = scanner.nextInt();
        System.out.printf("Infome a poscicao que vamos inserir no vetor: ");
        p = scanner.nextInt();
        if ((p < 0) || (p >= n)) {
            System.out.printf("Posicao invalida\n");
            return;
        }

        for (int i = (n - 1); i > p; i--)
            vetor[i] = vetor[i - 1];

        vetor[p] = k;

        System.out.printf("Vetor resultante: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", vetor[i]);
        }
        System.out.println();

        scanner.close();
    }
}