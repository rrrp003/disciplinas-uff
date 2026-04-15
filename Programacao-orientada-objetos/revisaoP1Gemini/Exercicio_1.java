package revisaoP1Gemini;

import java.util.Scanner;

public class Exercicio_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vetor_produtos = new String[50];
        float[] vetor_precos = new float[50];
        int i = 0;
        float media = 0;

        System.out.println("Cadastro iniciado! Caso deseja encerrar Digite FIM ao perguntar o nome do produto");
        while (true) {

            System.out.printf("Nome do produto: ");
            vetor_produtos[i] = scanner.nextLine();
            if (vetor_produtos[i].equalsIgnoreCase("FIM"))
                break;
            System.out.printf("Valor do produto: ");
            vetor_precos[i] = scanner.nextFloat();
            scanner.nextLine();
            media += vetor_precos[i];

            if (vetor_precos[i] > 100.0) {
                vetor_produtos[i] = vetor_produtos[i].toUpperCase();
                vetor_produtos[i] += " PRODUto Premium\n";
            }
            i++;
        }
        System.out.printf("O numero total de produtos: %d\n", i);
        System.out.printf("A media dos precos do produtos: %.2f\n", media / i);

        int n = i;

        for (i = 0; i < n; i++) {
            System.out.printf("Produto[%d] :%s", i, vetor_produtos[i]);
            System.out.printf(" R$%.2fn\n", vetor_precos[i]);
        }
        scanner.close();
    }
}