package exercicios.trabalho_vetor.implementacao_lista_duplamente_ligada;

public interface IVetor {
    public abstract Object elemAtRank(int r);
    public abstract Object removeAtRank(int r);
    public abstract Object replaceAtRank(int r, Object o);
    public abstract void insertAtRank(int r, Object o);
    public abstract int size();
    public abstract boolean isEmpty();
}