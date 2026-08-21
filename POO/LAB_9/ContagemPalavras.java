package LAB_9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContagemPalavras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();

        String[] palavras = frase.split(" ");

        Map<String, Integer> mapaPalavras = new HashMap<>();

        for (String palavra : palavras) {
            String palavraMinuscula = palavra.toLowerCase();
            
            if (mapaPalavras.containsKey(palavraMinuscula)) {
                int quantidadeAtual = mapaPalavras.get(palavraMinuscula);
                mapaPalavras.put(palavraMinuscula, quantidadeAtual + 1);
            } else {
                mapaPalavras.put(palavraMinuscula, 1);
            }
        }

        System.out.println("\nOcorrencias de cada palavra:");
        for (Map.Entry<String, Integer> registro : mapaPalavras.entrySet()) {
            System.out.println(registro.getKey() + ": " + registro.getValue());
        }

        scanner.close();
    }
}
