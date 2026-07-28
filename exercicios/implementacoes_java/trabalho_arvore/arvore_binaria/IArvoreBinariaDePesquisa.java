package arvore_binaria;
import java.util.Iterator;

public interface IArvoreBinariaDePesquisa {
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract NoArvore root();
    public abstract int depht(NoArvore v);
    public abstract int heigth(NoArvore r, NoArvore v);
    public abstract NoArvore parent(NoArvore v);
    public abstract NoArvore leftChild(NoArvore v);  
    public abstract NoArvore rightChild(NoArvore v);
    public abstract boolean hasLeft(NoArvore v);
    public abstract boolean hasRight(NoArvore v);
    public abstract Iterator<NoArvore> children(NoArvore v);
    public abstract boolean isExternal(NoArvore v); 
    public abstract boolean isInternal(NoArvore v); 
    public abstract boolean isRoot(NoArvore v);
    public abstract Iterator<Object> elements();
    public abstract Iterator<NoArvore> nos();
    public abstract void preOrder(NoArvore v);
    public abstract void postOrder(NoArvore v);
    public abstract void inOrder(NoArvore v);
    public abstract void visite(NoArvore v);
    public abstract NoArvore search(int k, NoArvore v);
    public abstract void insert(int k, NoArvore v) throws ArvoreExcecao;
    public abstract int remove(NoArvore v);
    public abstract void imprimirArvore();
}
