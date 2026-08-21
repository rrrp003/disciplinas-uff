package LAB_8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Somatorio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int somatorio = 0;
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.print("Digite un numero inteiro positivo (ou <= 0 para parar): ");
                int numero = scanner.nextInt();

                if (numero <= 0) {
                    continuar = false;
                } else {
                    somatorio += numero;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Voce nao digitou um numero inteiro valido.");
                scanner.next(); 
            }
        }

        System.out.println("Somatorio dos numeros positivos: " + somatorio);
        scanner.close();
    }
}
