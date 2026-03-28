package LAB_2;

/*Exercício 2: Altere o tipo das duas variáveis do exercício 1 para ponto flutuante */

import java.util.Scanner;

public class OP_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a, b;

        System.out.printf("Informe um num inteiro a e b: ");

        a = scanner.nextFloat();
        b = scanner.nextFloat();

        System.out.printf("Os numeros informados foram a: %.2f e b: %.2f \n", a, b);
        System.out.printf("A soma de %.2f e %.2f: %.2f\n", a, b, a + b);
        System.out.printf("A subtracao de   %.2f e %.2f: %.2f\n", a, b, a - b);
        System.out.printf("A multiplicacao de %.2f e %.2f: %.2f\n", a, b, a * b);
        System.out.printf("A divisao de %.2f e %.2f: %.2f\n", a, b, a / b);

        scanner.close();
    }

}
