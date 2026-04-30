package LAB_1;

import java.util.Scanner;

public class DigiteSeuNome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;

        System.out.print("Digite seu nome: ");
        nome = scanner.next();

        System.out.printf("Olá, %s! Bem-vindo ao Java!\n", nome);

        scanner.close();

    }
}