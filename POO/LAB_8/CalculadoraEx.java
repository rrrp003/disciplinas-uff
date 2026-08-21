package LAB_8;

public class CalculadoraEx {
    private float memoria;   
    
    public CalculadoraEx (){
        this.memoria = 0;
    }

    public float getMemoria() {
        return memoria;
    }

    public void somar(float x){
        this.memoria = this.memoria + x;
    }

    public void subtrair(float x){
        this.memoria = this.memoria - x;
    }

    public void multiplicar(float x){
        this.memoria = this.memoria * x;
    }

    public void divisao(float x){
        if (x == 0) {
            throw new ArithmeticException("Divisao por zero nao permitida.");
        }
        this.memoria = this.memoria / x;
    }

    public void limparMemoria(){
        this.memoria = 0;
    }
}