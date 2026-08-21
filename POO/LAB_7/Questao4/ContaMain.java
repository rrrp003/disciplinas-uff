package LAB_7.Questao4;

public class ContaMain {
  
    public static void main(String[] args) {
        ContaComum cc = new ContaComum(1001, 500.0);
        ContaPoupanca cp = new ContaPoupanca(2002, 1000.0);
        ContaEspecial ce = new ContaEspecial(3003, 200.0, 300.0);

        System.out.println("--- Testando Conta Comum ---");
        cc.depositar(100.0);
        System.out.printf("Saldo apos deposito: R$ %.2f\n", cc.getSaldo());
        boolean saqueCc1 = cc.sacar(700.0);
        System.out.println("Saque de R$ 700 realizado? " + saqueCc1);
        cc.sacar(200.0);
        System.out.printf("Saldo apos saque: R$ %.2f\n\n", cc.getSaldo());

        System.out.println("--- Testando Conta Poupanca ---");
        cp.render(1.5);
        System.out.printf("Saldo apos render 1.5%%: R$ %.2f\n\n", cp.getSaldo());

        System.out.println("--- Testando Conta Especial ---");
        boolean saqueCe1 = ce.sacar(450.0);
        System.out.println("Saque de R$ 450 (usando limite) realizado? " + saqueCe1);
        System.out.printf("Saldo apos saque especial: R$ %.2f\n", ce.getSaldo());
        boolean saqueCe2 = ce.sacar(100.0);
        System.out.println("Saque de R$ 100 (alem do limite) realizado? " + saqueCe2);
    }
}
