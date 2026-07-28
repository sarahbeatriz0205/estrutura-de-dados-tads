package exercicios.fila_simplesmente_encadeada;

public interface IFila {
    public abstract void enqueue(Object o);
    public abstract Object dequeue();
    public abstract int size();
    public abstract Object first();
    public abstract boolean isEmpty();
}