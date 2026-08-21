package LAB_3;

import java.util.Scanner;

public class L3_exerc2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int codigo;

        System.out.println("Solucao correta(0) a seguir:\n");
        System.out.println("informe o codigo: ");
        codigo = teclado.nextInt();
        while (codigo != -1) {
            System.out.println("Codigo: " + codigo);
            System.out.println("informe o codigo: ");
            codigo = teclado.nextInt();
        }

        System.out.println("Solucao errada a seguir(1):\n");
        codigo = 0; // zerando o valor para testar
        do {
            System.out.println("informe o codigo: ");
            codigo = teclado.nextInt();
            System.out.println("Codigo: " + codigo);
        } while (codigo != -1);

        System.out.println("Solucao corrigida(2) a seguir:\n");
        codigo = 0; // zerando o valor novamente para testar
        do { // da para utilizar um switch case, comm default
            System.out.println("informe o codigo: ");
            codigo = teclado.nextInt();
            if (codigo != -1)
                System.out.println("Codigo: " + codigo);
        } while (codigo != -1);
        teclado.close();
    }

}
