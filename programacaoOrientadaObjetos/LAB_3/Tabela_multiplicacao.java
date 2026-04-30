package LAB_3;

import java.util.Scanner;

public class Tabela_multiplicacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 10; i++)
            for (int j = 1; j <= 10; j++)
                System.out.printf("%d x %d = %d\n", i, j, i * j);

        scanner.close();
    }

}
