package LAB_8;
    
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraEx calc = new CalculadoraEx();
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\nEstado da memoria: " + calc.getMemoria());
            System.out.println("Opcoes:");
            System.out.println("(1) Somar");
            System.out.println("(2) Subtrair");
            System.out.println("(3) Multiplicar");
            System.out.println("(4) Dividir");
            System.out.println("(5) Limpar memoria");
            System.out.println("(6) Sair do programa");
            System.out.print("Qual opcao voce deseja? ");

            try {
                opcao = scanner.nextInt();

                if (opcao >= 1 && opcao <= 4) {
                    System.out.print("Digite o valor: ");
                    float valor = scanner.nextFloat();

                    try {
                        if (opcao == 1) calc.somar(valor);
                        else if (opcao == 2) calc.subtrair(valor);
                        else if (opcao == 3) calc.multiplicar(valor);
                        else if (opcao == 4) calc.divisao(valor);
                    } catch (ArithmeticException e) {
                        System.out.println("Erro no calculo: " + e.getMessage());
                    }

                } else if (opcao == 5) {
                    calc.limparMemoria();
                } else if (opcao != 6) {
                    System.out.println("Opcao invalida! Tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada: Voce digitou um valor invalido.");
                scanner.next(); 
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}