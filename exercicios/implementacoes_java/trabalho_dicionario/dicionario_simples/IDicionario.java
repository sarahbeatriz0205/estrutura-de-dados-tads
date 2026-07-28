package dicionario_simples;

public interface IDicionario{
    public abstract Object findElement(Item k);
    public abstract void insertElement(Item k);
    public abstract Object removeElement(Item k);
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract int[] keys();
    public abstract Object[] elements();
}