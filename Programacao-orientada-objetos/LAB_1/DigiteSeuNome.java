package LAB_1;

import java.util.Scanner;

public class DigiteSeuNome {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String nome;

        System.out.print("Digite seu nome: ");
        nome = ler.next();

        System.out.printf("Olá, %s! Bem-vindo ao Java!\n", nome);
    }
}