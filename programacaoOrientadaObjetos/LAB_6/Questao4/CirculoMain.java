package LAB_6.Questao4;

import java.util.Scanner;

public class CirculoMain {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a coordenada X do centro: ");
        float x = teclado.nextFloat();
        
        System.out.print("Digite a coordenada Y do centro: ");
        float y = teclado.nextFloat();
        
        System.out.print("Digite o tamanho do Raio: ");
        float raio = teclado.nextFloat();
        
        System.out.println("\nCriando o objeto...");
        Circulo meuCirculo = new Circulo(x, y, raio);

        meuCirculo.desenhar();
        
        meuCirculo.mover(10.0f, 15.0f); 
    
        meuCirculo.redimensionar(4.0f); 
        
        meuCirculo.dividir(); 
        
        System.out.println("\nEstado final do Círculo após as operações:");
        meuCirculo.desenhar();

        teclado.close();
    }
}
