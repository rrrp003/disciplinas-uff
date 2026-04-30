package LAB_5.Supermercado;

public class Item {
    // atributos
    int qt_desejada;
    Produto produto;

    // metodos
    public Item(int qt_desejada, Produto produto) {
        this.qt_desejada = qt_desejada;
        this.produto = produto;
    }

    public double calculoValorItem() {
        return qt_desejada * produto.preco;
    }
}
