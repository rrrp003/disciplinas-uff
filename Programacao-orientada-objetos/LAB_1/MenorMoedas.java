package LAB_1;

import java.util.Scanner;

public class MenorMoedas {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int centavos, Moeda1real, Moeda50centavos, Moeda25centavos, Moeda10centavos, Moeda5centavos, Moeda1centavo;

        System.out.printf("Informe o quanto de dinheiro em centavos: ");
        centavos = ler.nextInt();

        Moeda1real = centavos / 100;
        Moeda50centavos = (centavos % 100) / 50;
        Moeda25centavos = ((centavos % 100) % 50) / 25;
        Moeda10centavos = (((centavos % 100) % 50) % 25) / 10;
        Moeda5centavos = ((((centavos % 100) % 50) % 25) % 10) / 5;
        Moeda1centavo = ((((centavos % 100) % 50) % 25) % 10) % 5;

        System.out.println("Moedas de 1 real: " + Moeda1real);
        System.out.println("Moedas de 50 centavos: " + Moeda50centavos);
        System.out.println("Moedas de 25 centavos: " + Moeda25centavos);
        System.out.println("Moedas de 10 centavos: " + Moeda10centavos);
        System.out.println("Moedas de 5 centavos: " + Moeda5centavos);
        System.out.println("Moedas de 1 centavo: " + Moeda1centavo);

    }
    // se eh maior, igual a 100, divide por
}
