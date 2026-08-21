package LAB_2;

import java.util.Scanner;

public class exer7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a, b, c;

        System.out.printf("Digite um num inteiro: ");
        a = scanner.nextInt();
        System.out.printf("Digite um num inteiro: ");
        b = scanner.nextInt();
        System.out.printf("Digite um num inteiro: ");
        c = scanner.nextInt();

        if (b > c) {
            if (a < c)
                System.out.printf("%d esta antes do intervalo\n", a);
            else if (a > b)
                System.out.printf("%d esta depois do intervalo\n", a);
            else
                System.out.printf("%d esta entre o intervalo %d e %d\n", a, c, b);
        } else {
            if (a < b)
                System.out.printf("%d esta antes do intervalo\n", a);
            else if (a > c)
                System.out.printf("%d esta depois do intervalo\n", a);
            else
                System.out.printf("%d esta entre o intervalo %d e %d\n", a, b, c);
        }
        scanner.close();
    }

}
