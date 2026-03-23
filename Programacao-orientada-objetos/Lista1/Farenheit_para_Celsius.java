package Lista1;

import java.util.Scanner;

public class Farenheit_para_Celsius{
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        Double Celsius, Farenheit;

        System.out.printf("Digite a temperatura em Celsius: ");
        Celsius = ler.nextDouble();

        Farenheit = Celsius * 1.8 + 32;

        System.out.printf("%.0f Celsius equivalem a %.0f Farenheit", Celsius, Farenheit);
    }
}
