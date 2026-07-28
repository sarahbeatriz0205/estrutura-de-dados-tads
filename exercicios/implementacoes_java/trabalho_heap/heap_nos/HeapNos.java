package heap_nos;
import java.util.ArrayList;

public class HeapNos implements IHeap{
    private NoHeap raiz;
    private int size;
    private ArrayList<NoHeap> nos;

    public HeapNos(Item o){
        this.raiz = new NoHeap(null, null, null, o);
        this.size = 1;
        nos = new ArrayList<>(); nos.add(this.raiz);
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return false;
    }

    public Item min(){
        return this.raiz.getElemento();
    }

    public static NoHeap leftChild(NoHeap v){
        return v.getFilhoEsquerdo();
    }

    public static NoHeap rightChild(NoHeap v){
        return v.getFilhoDireito();
    }

    public boolean hasLeft(NoHeap v){
        if (HeapNos.leftChild(v) != null){
            return true;
        }
        return false;
    }

    public boolean hasRight(NoHeap v){
        if (HeapNos.rightChild(v) != null){
            return true;
        }
        return false;
    }

    public static boolean isExternal(NoHeap v){
        if (v.getFilhoEsquerdo() == null && v.getFilhoDireito() == null){
            return true;
        }
        return false;
    }

    public static boolean isInternal(NoHeap v){
        if (v.getFilhoEsquerdo() != null || v.getFilhoDireito() != null){
            return true;
        }
        return false;
    }

    /* suponho que, já que um heap com lado direito preenchido e lado esquerdo não preenchido não 
    é considerado um heap, a viagem pela esquerda é suficiente */
    public int heapHeigth(){
        NoHeap atual = this.raiz;
        int h = 0;

        while (isInternal(leftChild(atual))){
            atual = atual.getFilhoEsquerdo();
            h += 1;
        }

        return h;
    }

    public NoHeap last(){
        return nos.get(this.size - 1);
    }

    public NoHeap nextInsert(){
        return nos.get((size - 1) / 2);
    }

    public void swapElements(NoHeap v, NoHeap w){
        Item temp = v.getElemento();
		v.setElemento(w.getElemento());
		w.setElemento(temp);
    }


    public void upheap(NoHeap v){
        NoHeap atual = v;
        while (atual.getPai() != null && atual.getElemento().key() < atual.getPai().getElemento().key()){
            swapElements(atual, atual.getPai());
            atual = atual.getPai();
        }
    }

    public void insert(Item o){
        NoHeap ultimo = nextInsert();
        NoHeap novo = new NoHeap(null, null, ultimo, o);

        if (ultimo.getFilhoEsquerdo() != null && ultimo.getFilhoDireito() == null){
            ultimo.setFilhoDireito(novo);
        } else {
            ultimo.setFilhoEsquerdo(novo);
        }
        this.size++;
        nos.add(novo);
        upheap(novo);
    }

    public void downheap(NoHeap v) {
    NoHeap atual = v;

    while (atual.getFilhoEsquerdo() != null) {
        NoHeap menorFilho = atual.getFilhoEsquerdo();
        NoHeap filhoDireito = atual.getFilhoDireito();

        if (filhoDireito != null && filhoDireito.getElemento().key() < menorFilho.getElemento().key()) {
            menorFilho = filhoDireito;
        }

        if (atual.getElemento().key() <= menorFilho.getElemento().key()) {
            break;
        }

        swapElements(atual, menorFilho);

        atual = menorFilho;
    }
}


    public Item removeMin(){
        NoHeap removido = last();
        Item menor = this.raiz.getElemento();
        this.raiz.setElemento(removido.getElemento());
        if (removido == removido.getPai().getFilhoEsquerdo()){
            removido.getPai().setFilhoEsquerdo(null);
        } else {
            removido.getPai().setFilhoDireito(null);
        }
        removido.setPai(null);
        nos.remove(this.size - 1);
        this.size--;
        downheap(this.raiz);
        return menor;
    }
}