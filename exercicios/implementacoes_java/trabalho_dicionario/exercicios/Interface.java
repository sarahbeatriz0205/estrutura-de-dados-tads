package exercicios;
import java.util.Iterator;

public interface Interface {
    public abstract Object findElement(int k);
    public abstract void insertElement(Item k);
    public abstract Object removeElement(Item k);
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract Iterator<Object> keys();
    public abstract Iterator<Object> elements();
}