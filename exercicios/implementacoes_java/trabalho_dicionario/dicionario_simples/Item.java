package dicionario_simples;

public class Item {
    private int key;
    private Object element;

    public Item(int key, Object element){
        this.key = key;
        this.element = element;
    }

    public int key(){
        return this.key;
    }

    public Object value(){
        return this.element;
    }
}
