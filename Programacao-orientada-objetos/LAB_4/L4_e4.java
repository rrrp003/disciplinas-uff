package LAB_4;

import java.util.Arrays;
import java.util.Scanner;

public class L4_e4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[10];
        int[] idades = new int[10];

        System.out.printf("Iniciando programa\n");

        for (int i = 0; i < 10; i++) {
            System.out.printf("Infome o nome: ");
            nomes[i] = scanner.nextLine();
            System.out.printf("Infome a idade do %s: ", nomes[i]);
            idades[i] = scanner.nextInt();
            scanner.nextLine();
        }

        // Copia e ordena vetores
        String[] nomes_ordenados = Arrays.copyOf(nomes, nomes.length);
        int[] idades_ordenadas = Arrays.copyOf(idades, idades.length);
        Arrays.sort(nomes_ordenados);
        Arrays.sort(idades_ordenadas);

        // Ordem alfabética
        System.out.printf("\nLista em ordem alfabetica:\n");
        for (int i = 0; i < 10; i++) {
            int j = 0;
            boolean achou = false;
            do {
                if (nomes[j].equalsIgnoreCase(nomes_ordenados[i]))
                    achou = true;
                else
                    j++;
            } while (!achou);

            System.out.printf("nome: %-15s idade: %d\n", nomes_ordenados[i], idades[j]);
        }

        // Ordem crescente de idade
        System.out.printf("\nLista em ordem crescente de idade:\n");
        for (int i = 0; i < 10; i++) {
            int j = 0;
            boolean achou = false;
            do {
                if (idades[j] == idades_ordenadas[i])
                    achou = true;
                else
                    j++;
            } while (!achou);

            System.out.printf("nome: %-15s idade: %d\n", nomes[j], idades_ordenadas[i]);
        }

        scanner.close();
    }
}