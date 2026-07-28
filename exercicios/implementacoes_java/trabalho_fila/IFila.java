package exercicios.trabalho_fila;

public interface IFila {
    public abstract void enqueue(Object o);
    public abstract Object dequeue() throws FilaVaziaExcecao;
    public abstract int size();
    public abstract Object first() throws FilaVaziaExcecao;
    public abstract boolean isEmpty();
    public abstract void reverse();
}