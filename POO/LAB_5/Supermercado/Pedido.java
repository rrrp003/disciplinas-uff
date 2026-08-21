package LAB_5.Supermercado;

import java.util.ArrayList;

public class Pedido {
    // atributos
    ArrayList<Item> itens = new ArrayList<>();
    String pagamento;

    // metodos
    public Pedido(String pagamento) {
        this.pagamento = pagamento;
        this.itens = new ArrayList<>();
    }

    public void novoItem(Item novoItem) {
        itens.add(novoItem);

        novoItem.produto.qt_estoque--;
    }

    public double calculoValorTotal() {
        double total = 0;
        for (Item i : itens) {
            total = total + i.calculoValorItem();
        }
        return total;
    }
}
