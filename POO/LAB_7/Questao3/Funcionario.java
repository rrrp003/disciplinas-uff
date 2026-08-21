package LAB_7.Questao3;
/*Todos os funcionários de uma empresa possuem nome e salário bruto.
2. O salário líquido é calculado como salário bruto – imposto de renda.
3. O IR é calculado sobre o salário bruto da seguinte forma:
– Até 900,00 => desconto de ZERO
– Até 1500,00 => desconto de 15%
– Acima de 1500,00 => desconto de 20%
4. Existem dois tipos especiais de funcionários: estagiários e vendedores.
5. Todos os funcionários pagam IR, com exceção dos estagiários que não tem desconto
do IR.
6. Além do salário bruto, os vendedores ganham um bônus, que é um percentual a ser
acrescido sobre o salário bruto. Nesse caso, o IR é descontado sobre o total
recebido pelo vendedor (salário bruto + bônus).
Crie a hierarquia de classes desse cenário e implemente o método public float salarioLiquido()
para cada um dos tipos de funcionário. */

public class Funcionario {
    private String nome;
    private float salarioBruto;
 
    public Funcionario(String nome, float salarioBruto){
        this.nome = nome;
        this.salarioBruto = salarioBruto;
    }

    public float salarioLiquido(){
        float salarioBruto = this.salarioBruto;
        if (salarioBruto <= 900) return salarioBruto;

        else if(salarioBruto <= 1500) return (salarioBruto * 0.85f);

        else return (salarioBruto * 0.80f);
    } 

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public String getNome() {
        return nome;
    }
}
class Estagiario extends Funcionario{
    public Estagiario(String nome, float salarioBruto) {
        super(nome, salarioBruto);
    }
    @Override
    public float salarioLiquido(){
        return getSalarioBruto();
    }
}

class Vendedor extends Funcionario{
    private float bonus;

    public Vendedor(String nome, float salarioBruto, float bonus){
        super(nome, salarioBruto);
        this.bonus = bonus;
    }

     @Override
    public float salarioLiquido(){
       float salarioBruto = getSalarioBruto();
        if (salarioBruto <= 900) return (salarioBruto + bonus);

        else if(salarioBruto <= 1500) return (salarioBruto * 0.85f + bonus);

        else return (salarioBruto * 0.80f + bonus) ;

    }
    
}