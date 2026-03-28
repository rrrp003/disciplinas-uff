package LAB_2;

/*Exercício 4: Faça um programa que leia a distância percorrida por um carro, o tempo gasto
e a quantidade de gasolina consumida. Em seguida, imprima a velocidade média (KM/h) e
o consumo de combustível (Km/l). */

import java.util.Scanner;

public class exer4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float dist, tempo, gaso;

        System.out.printf(
                "Digite a distancia percorrida em kilometros, o tempo gasto em horas e a gasolina consumida em litros: ");

        dist = scanner.nextFloat();
        tempo = scanner.nextFloat();
        gaso = scanner.nextFloat();

        System.out.printf("A velocidade realiza foi: %.2fKM/h e o consumo de combustivel foi: %.2fKM/l\n", dist / tempo,
                dist / gaso);
        scanner.close();

    }

}
