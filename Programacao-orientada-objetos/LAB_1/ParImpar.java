
package LAB_1;

import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int num;
        System.out.printf("Digite um numero: ");
        num = ler.nextInt();

        if (num % 2 == 0) {
            System.out.printf("O numero %d eh par ", num);

        } else
            System.out.printf("O numero %d eh impar ", num);
    }
}
