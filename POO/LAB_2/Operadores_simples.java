package LAB_2;

/*Exercício 1: Leia duas variáveis inteiras e imprima a soma,
subtração, multiplicação e divisão entre elas. */

import java.util.Scanner;

public class Operadores_simples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;

        System.out.printf("Informe um num inteiro a e b: ");

        a = scanner.nextInt();
        b = scanner.nextInt();

        System.out.printf("Os numeros informados foram a: %d e b: %d \n", a, b);
        System.out.printf("A soma de %d e %d: %d\n", a, b, a + b);
        System.out.printf("A subtracao de %d e %d: %d\n", a, b, a - b);
        System.out.printf("A multiplicacao de %d e %d: %d\n", a, b, a * b);
        System.out.printf("A divisao de %d e %d: %d\n", a, b, a / b);

        scanner.close();
    }

}
