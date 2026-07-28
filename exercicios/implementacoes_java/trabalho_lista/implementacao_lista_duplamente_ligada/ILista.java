package exercicios.trabalho_lista.implementacao_lista_duplamente_ligada;

public interface ILista {
    public abstract boolean isFirst(No n);
    public abstract boolean isLast(No n);
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