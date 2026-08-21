package LAB_7.Questao2;

import java.util.Random;

public class AnimalMain {
    public static void main (String [] args){
        Animal[] vetorAnimais = new Animal[10];

        Random sorteio = new Random();

        for (int i = 0; i < vetorAnimais.length; i++) {
            
            // Sorteia um número de 0 até 2 (0, 1 ou 2)
            int numeroSorteado = sorteio.nextInt(3); 
            
            if (numeroSorteado == 0) {
                vetorAnimais[i] = new Homem();
            } else if (numeroSorteado == 1) {
                vetorAnimais[i] = new Cao();
            } else {
                vetorAnimais[i] = new Gato();
            }
        }
        System.out.println("--- RESULTADO DO VETOR ---");
        for (int i = 0; i < vetorAnimais.length; i++) {
            System.out.println("Posição " + i + " diz: " + vetorAnimais[i].fala());
        }
    }
    
}
