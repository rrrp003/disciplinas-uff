package LAB_7.Questao2;
/*Exercício: Faça uma classe Animal com um método abstrato “fala”.
- Faça as classes Homem, Cão e Gato, herdando de animal, redefinindo o método “fala”
para retornar “Oi”, “Au au” e “Miau”, respectivamente.
- Crie um vetor de 10 Animais e instancie aleatoriamente Homens, Cães e Gatos nesse
vetor.
- Faça um loop por todos os animais do vetor, pedindo para eles falarem. */
public abstract class Animal{
    public abstract String fala();
}

class Homem extends Animal{
    
    @Override
    public String fala(){
        return ("Oi");
    }
}

class Cao extends Animal{
    @Override
    public String fala(){
        return ("Au");
    }
}

class Gato extends Animal{
    @Override
    public String fala(){
        return ("Miau");
    }
}

