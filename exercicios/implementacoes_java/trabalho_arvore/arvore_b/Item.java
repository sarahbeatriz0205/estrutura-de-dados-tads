package arvore_b;

public class Item {
    private Object chave;
    private Object valor;

    public Item(Object chave, Object valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public Object getChave() {
        return this.chave;
    }

    public Object getValor() {
        return this.valor;
    }
}