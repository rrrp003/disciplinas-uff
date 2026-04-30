package LAB_5.Supermercado;

public class Main {
    public static void main(String[] args) {
        Produto arroz = new Produto("Arroz Tio Joao 1kg", 5.0, 100);
        Produto feijao = new Produto("Feijao Tio Joao 1kg", 8.0, 40);
        Produto refrigerante = new Produto("Coca-cola 2L", 7.0, 38);

        Item item1 = new Item(2, arroz);
        Item item2 = new Item(4, feijao);
        Item item3 = new Item(1, refrigerante);

        Pedido meuPedido = new Pedido("Dinheiro");
        meuPedido.novoItem(item1);
        meuPedido.novoItem(item2);
        meuPedido.novoItem(item3);

        System.out.println("Total: R$ " + meuPedido.calculoValorTotal());
    }
}
