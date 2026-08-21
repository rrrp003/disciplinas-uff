package LAB_9;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PalavrasUnicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();

        String[] palavras = frase.split(" ");

        Set<String> conjuntoPalavras = new HashSet<>();

        for (String palavra : palavras) {
           
            conjuntoPalavras.add(palavra.toLowerCase());
        }

        System.out.println("Numero de palavras nao-repetidas: " + conjuntoPalavras.size());

        scanner.close();
    }
}
