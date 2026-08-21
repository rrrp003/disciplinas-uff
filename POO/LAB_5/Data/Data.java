package LAB_5.Data;
/*
Exercício 5: crie uma classe Data para representar uma data. Para criar uma data é
obrigatório informar dia, mês e ano. Crie, também, três métodos:
1. dataValida() que deverá retornar true se os valores de dia, mês e ano
formarem uma data válida ou false caso contrário.
2. anoBissexto() que deverá retornar true se os valores de dia, mês e ano
formarem uma data válida e o ano for bissexto ou false caso contrário.
3. imprime() que deverá imprimir a data com o separador default "/" ou com um
separador definido pelo usuário. Caso a data seja inválida, o método deverá
imprimir "INVÁLIDA". */

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public boolean dataValida() {
        
        if (this.ano < 1 || this.mes < 1 || this.mes > 12 || this.dia < 1) {
            return false; //basico
        }

        int diasNoMes = 31; 

        // Ajusta para meses com 30 dias
        if (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) {
            diasNoMes = 30;
        } 
    
        else if (this.mes == 2) {
            if ((this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 400 == 0)) { // logica bissexto
                diasNoMes = 29;
            } else {
                diasNoMes = 28;
            }
        }
        return this.dia <= diasNoMes;
    }

    public boolean anoBissexto() {
        return dataValida();
    }

    // 3. Imprime com separador definido pelo usuário
    public void imprime(String separador) {
        if (separador == null || separador.isEmpty()) separador = "/";

        if (!dataValida()) {
            System.out.println("INVÁLIDA");
        } else {
            // O %02d garante que dias e meses menores que 10 ganhem um zero na frente (ex: 05)
            System.out.printf("%02d%s%02d%s%d\n", this.dia, separador, this.mes, separador, this.ano);
        }
    }
}
