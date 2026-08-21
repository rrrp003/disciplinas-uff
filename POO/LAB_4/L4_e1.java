package LAB_4;

import java.util.Scanner;

public class L4_e1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tam_turma;
        int media = 0;
        System.out.printf("Infome o tamanho da tuma: ");
        tam_turma = scanner.nextInt();

        int[] vetor_turma = new int[tam_turma];
        // escrita notas
        for (int i = 0; i < tam_turma; i++) {
            System.out.printf("Digite a nota do aluno [%d]: ", i + 1);
            vetor_turma[i] = scanner.nextInt();
            media += vetor_turma[i];
        }
        media = media / tam_turma;
        for (int i = 0; i < tam_turma; i++) {
            if (vetor_turma[i] > media)
                System.out.printf("A nota do aluno [%d] eh %d, que eh maior que %d\n", i + 1, vetor_turma[i], media);
        }
        scanner.close();
    }
}
