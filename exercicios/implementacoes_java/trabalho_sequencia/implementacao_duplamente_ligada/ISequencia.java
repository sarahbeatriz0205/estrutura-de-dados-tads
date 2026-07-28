package exercicios.trabalho_sequencia.implementacao_duplamente_ligada;

public interface ISequencia{
    public abstract No atRank(int rank);
    public abstract int rankOf(No no);
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
    public abstract No insertBefore(No n, Object o);
    public abstract No insertAfter(No n, Object o);
    public abstract No insertFirst(Object o);
    public abstract No insertLast(Object o);
    public abstract Object remove(No n);
    public abstract int size();
    public abstract boolean isEmpty();
}