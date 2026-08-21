package LAB_9;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.List;
    import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();

        String[] palavrasArray = frase.split(" ");

        List<String> listaPalavras = new ArrayList<>(Arrays.asList(palavrasArray));

        Collections.reverse(listaPalavras);

        String fraseInvertida = String.join(" ", listaPalavras);

        System.out.println("Frase invertida: " + fraseInvertida);

        scanner.close();
    }
}
