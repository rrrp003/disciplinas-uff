package LAB_4;

import java.util.Scanner;

public class L4_e2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k;
        boolean x = false;
        System.out.printf("Infome o tamanho do vetor: ");
        n = scanner.nextInt();

        int[] vetor = new int[n];
        // escrita vetor
        for (int i = 0; i < n; i++) {
            System.out.printf("Infome um numero inteiro qualquer [%d]: ", i);
            vetor[i] = scanner.nextInt();
        }
        System.out.printf("Infome um numero para pesquisar no vetor: ");
        k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if (vetor[i] == k) {
                System.out.printf("O num %d apareceu na posicao [%d] do vetor \n", k, i);
                x = true;
            }
        }
        if (x == false)
            System.out.printf("O num %d nao foi encontrado\n", k);
        scanner.close();
    }
}