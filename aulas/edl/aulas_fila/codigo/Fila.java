package aulas_fila.codigo;

public interface Fila {
    public abstract void enqueue(Object o);
    public abstract Object dequeue();
    public abstract int size();
    public abstract Object first();
    public abstract boolean isEmpty();
}