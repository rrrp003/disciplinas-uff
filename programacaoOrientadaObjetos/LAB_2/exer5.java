package LAB_2;

import java.util.Scanner;

public class exer5 {
    public static void main(String[] args) {
        int x1, y1, x2, y2, x3, y3;

        double l1, l2, l3;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite as coordenadas dos vertices do triangulo (x1 y1 x2 y2 x3 y3): ");

        x1 = scanner.nextInt();
        y1 = scanner.nextInt();
        x2 = scanner.nextInt();
        y2 = scanner.nextInt();
        x3 = scanner.nextInt();
        y3 = scanner.nextInt();

        l1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        l2 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        l3 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));

        if ((l1 + l2 > l3) && (l1 + l3 > l2) && (l2 + l3 > l1)) {

            if ((l1 == l2) && (l2 == l3)) {
                System.out.println("Formam um triangulo: Equilatero");
            } else if ((l1 == l2) || (l2 == l3) || (l1 == l3)) {
                System.out.println("Formam um triangulo: Isosceles");
            } else {
                System.out.println("Formam um triangulo: Escaleno");
            }

        } else {
            System.out.println("Os pontos informados NAO formam um triangulo.");
        }

        scanner.close();
    }
}