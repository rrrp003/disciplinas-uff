package LAB_2;

import java.util.Scanner;

public class exer6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int preco, x;
        String produto = " ";

        System.out.printf("Iniciando programa descontos\n");

        System.out.printf("Informe o nome do produto: ");
        produto = scanner.nextLine();
        System.out.printf("Informe o preco do produto: ");
        preco = scanner.nextInt();
        System.out.printf("Informe a quantidade de produtos: ");
        x = scanner.nextInt();

        if (x <= 10)
            System.out.printf("O %s custa: %.2f reais\n", produto, preco);
        else if (x <= 20)
            System.out.printf("O %s custa: %.2f reais\n", produto, preco * 0.9);
        else if (x <= 50)
            System.out.printf("O %s custa: %.2f reais\n", produto, preco * 0.8);
        else
            System.out.printf("O %s custa: %.2f reais\n", produto, preco * 0.75);

        scanner.close();
    }

}
