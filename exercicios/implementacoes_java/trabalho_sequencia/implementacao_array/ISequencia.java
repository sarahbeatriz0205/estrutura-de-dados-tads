package exercicios.trabalho_sequencia.implementacao_array;

public interface ISequencia{
    public abstract Object elemAtRank(int r);
    public abstract Object removeAtRank(int r);
    public abstract Object replaceAtRank(int r, Object o);
    public abstract void insertAtRank(int r, Object o);
    public abstract Object first();
    public abstract Object last();
    public abstract Object before(No p);
    public abstract Object after(No p);
    public abstract Object replaceElement(No n, Object o);
    public abstract void swapElements(No n, No q);
    public abstract void insertBefore(No n, Object o);
    public abstract void insertAfter(No n, Object o);
    public abstract void insertFirst(Object o);
    public abstract void insertLast(Object o);
    public abstract Object remove(No n);
    public abstract int size();
    public abstract boolean isEmpty();
}