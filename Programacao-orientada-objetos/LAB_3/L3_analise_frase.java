package LAB_3;

/*
Exiba o número total de caracteres
Exiba tudo em maiúsculo
Exiba tudo em minúsculo
Conte quantas vezes a letra A aparece */
import java.util.Scanner;

public class L3_analise_frase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frase = "";

        System.out.printf("Digite uma frase ou uma palavra: ");
        frase = scanner.nextLine();

        System.out.printf("o num total contando espaco: %d \n", frase.length());
        System.out.printf("o num total sem contar espaco: %d \n", frase.trim().length());

        System.out.printf("A frase completa em maiusculo %s: \n", frase.toUpperCase());
        System.out.printf("A frase completa em maiusculo %s: \n", frase.toLowerCase());

        // System.out.printf("A quantidade de vezes que a letra (a) aparece: %d\n", );

        scanner.close();
    }
}
