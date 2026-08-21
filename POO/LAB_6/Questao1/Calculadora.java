package LAB_6.Questao1;
/*1. Utilizando os conceitos de classes e métodos: Faça uma calculadora que
forneça as seguintes opções para o usuário, usando métodos sempre que
possível. A calculadora deve operar sempre sobre o valor corrente na memória

Estado da memória: 0
Opções:
(1) Somar
(2) Subtrair
(3) Multiplicar
(4) Dividir
(5) Limpar memória
(6) Sair do programa
Qual opção você deseja? */

public class Calculadora {
    private float memoria;   
    
    public Calculadora (){
        this.memoria = 0;
    }

    public float getMemoria() {
        return memoria;
    }

    public void somar(float x){
        this.memoria = getMemoria() + x;
         
    }

    public void subtrair(float x){
        this.memoria = getMemoria() - x;
         
    }

    public void multiplicar(float x){
        this.memoria = getMemoria() * x;
         
    }

    public void divisao(float x){
        this.memoria = getMemoria() / x;
         
    }

    public void limparMemoria(){
        this.memoria = 0;
         
    }

}
