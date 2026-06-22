package LAB_7.Questao3;

public class FuncionarioMain{
    public static void main(String [] args){
    Estagiario e1 = new Estagiario("Lucas",1800);
    Estagiario e2 = new Estagiario("Ronaldo",1100); 

    Vendedor v1 = new Vendedor("Guilermo", 4000, 100 );
    Vendedor v2 = new Vendedor("Julaina", 10000, 500 );

    System.out.println("Iniciando programa...");    
    System.out.printf("o salario de %s eh de: %.2f .\n", e1.getNome(), e1.salarioLiquido());    
    System.out.printf("o salario de %s eh de: %.2f .\n", e2.getNome(), e2.salarioLiquido());
    System.out.printf("o salario de %s eh de: %.2f .\n", v1.getNome(), v1.salarioLiquido());
    System.out.printf("o salario de %s eh de: %.2f .\n", v2.getNome(), v2.salarioLiquido());    

    }
   

}