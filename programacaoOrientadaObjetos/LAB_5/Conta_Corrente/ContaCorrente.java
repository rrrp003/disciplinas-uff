package LAB_5.Conta_Corrente;

    public class ContaCorrente {

    private float saldo;

    //metodos
    
    public ContaCorrente(float saldo){
        this.saldo = saldo;
    }
    
    public float getSaldo(){
        return saldo;
    }

    public void setSaldo(float saldo){
        this.saldo = saldo;
    }

    public void realizarSaque(float saida){
        float saldoAtual = getSaldo();
        if (saldoAtual >= (saida + 1.50f)){
            saldoAtual -= (saida +1.50f);
            setSaldo(saldoAtual);
        }
        else {
            System.out.println("nao tem saldo suficiente ");
            System.out.println("--------");
        }  
    }
    
    public void depositar(float deposito){
        float saldoAtual = getSaldo();
        saldoAtual += deposito;
        setSaldo(saldoAtual);
    }

    public void obterSaldo(){
        System.out.println("O saldo atual eh " + getSaldo());
        System.out.println("--------");
    }


}
