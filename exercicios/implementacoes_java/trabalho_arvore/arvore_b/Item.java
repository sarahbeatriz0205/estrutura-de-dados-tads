package arvore_b;

public class Item implements Comparable<Object>{
    private Comparable chave;
    private Object valor;

    public Item(Comparable chave, Object valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public Comparable getChave() {
        return this.chave;
    }

    public Object getValor() {
        return this.valor;
    }

    @Override
    public int compareTo(Object v) {
        return this.chave.compareTo(v);
    }
}