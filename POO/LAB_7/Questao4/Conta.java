package LAB_7.Questao4;

public class Conta {
    private int numero;
    private double saldo;

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

class ContaComum extends Conta {
    public ContaComum(int numero, double saldo) {
        super(numero, saldo);
    }
}

class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, double saldo) {
        super(numero, saldo);
    }

    public void render(double percentual) {
        if (percentual > 0) {
            double rendimento = getSaldo() * (percentual / 100);
            depositar(rendimento);
        }
    }
}

class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(int numero, double saldo, double limite) {
        super(numero, saldo);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= (getSaldo() + this.limite)) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }
}


