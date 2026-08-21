package LAB_6.Questao1;

import java.util.Scanner;

public class CalculadoraMain {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        int opcao = 0;

         System.out.println("Iniciando Programa :)");

        while (opcao != 6) {
            System.out.println("Estado da memória: " + calc.getMemoria());
            System.out.println("Opções:");
            System.out.println("(1) Somar");
            System.out.println("(2) Subtrair");
            System.out.println("(3) Multiplicar");
            System.out.println("(4) Dividir");
            System.out.println("(5) Limpar memória");
            System.out.println("(6) Sair do programa");
            System.out.print("Qual opção você deseja?: ");
            
            opcao = teclado.nextInt();

            // Se a opção for de 1 a 4, precisamos pedir um número
            if (opcao >= 1 && opcao <= 4) {
                System.out.print("Digite o valor para a operação: ");
                float valor = teclado.nextFloat();

                switch (opcao) {
                    case 1: calc.somar(valor); break;
                    case 2: calc.subtrair(valor); break;
                    case 3: calc.multiplicar(valor); break;
                    case 4: 
                        if (valor == 0) {
                            System.out.println("Erro: Não é possível dividir por zero.");
                        } else {
                            calc.divisao(valor); 
                        }
                        break;
                }
            } 
            // Opções que não precisam pedir número
            else if (opcao == 5) {
                calc.limparMemoria();
            } else if (opcao == 6) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida!");
            }
            
            System.out.println("---------------------------");
        }
        
        teclado.close();
    }
}
