package exercicios.trabalho_lista.implementacao_lista_duplamente_ligada;

public class ListaDuplamenteEncadeada implements ILista{
    private No head;
    private No tail;
    private int size;

    public ListaDuplamenteEncadeada(){
        this.head = new No(null);
        this.tail = new No(null);
        this.head.setProximo(this.tail);  
        this.head.setAnterior(null);
        this.tail.setAnterior(this.head); 
        this.tail.setProximo(null);
        this.size = 0;
    }

    public boolean isFirst(No n){
        if (n.getAnterior() == null){
            return true;
        }
        return false;
    }

    public boolean isLast(No n){
        if (n.getProximo() == null){
            return true;
        }
        return false;
    }

    public Object first() throws ListaExcecao{
        if (isEmpty()){
            throw new ListaExcecao("Erro! Lista vazia");
        }
        else{
            return this.head.getProximo().getElemento();
        }
    }

    public Object last() throws ListaExcecao{
        if (isEmpty()){
            throw new ListaExcecao("Erro! Lista vazia");
        }
        else{
            return this.tail.getAnterior().getElemento();
        }
    }

    public Object before(No p) throws ListaExcecao{
        if (p == null){
            throw new ListaExcecao("Exceção! Nó não existe");
        }
        else if (p == this.head){
            throw new ListaExcecao("Exceção! O nó aponta para null");
        }
        else{
            No elemento = p.getAnterior();
            return elemento.getElemento();
        }
    }

    public Object after(No p){
        if (p == null){
            throw new ListaExcecao("Exceção! Nó não existe");
        }
        else if (p == this.tail){
            throw new ListaExcecao("Exceção! O nó aponta para null");
        }
        else{
            No elemento = p.getProximo();
            return elemento.getElemento();
        }
    }

    public Object replaceElement(No n, Object o) throws ListaExcecao{
        Object element = n.getElemento();
        if (n == null){
            throw new ListaExcecao("Exceção! Nó não existe");
        }
        else if (n == this.head){
            this.head.setElemento(o);
        }
        else{
            n.setElemento(o);
        }
        return element;
    }

    public void swapElements(No n, No q){
        if (n == null || q == null){
            throw new ListaExcecao("Exceção! Nós não existem");
        }
        else{
           Object aux = n.getElemento();
           n.setElemento(q.getElemento());
           q.setElemento(aux);
        }
    }

    public No insertAfter(No n, Object o){
        No q = new No(o);
        q.setAnterior(n);
        q.setProximo(n.getProximo());
        if (n.getProximo() != null) {
            n.getProximo().setAnterior(q);
        }
        n.setProximo(q);
        this.size++;
        return q;
    } 

    public No insertBefore(No n, Object o){
        No q = new No(o);
        q.setProximo(n);
        q.setAnterior(n.getAnterior());
        if (n.getAnterior() != null) {
            n.getAnterior().setProximo(q);
        }
        n.getAnterior().setProximo(q);
        n.setAnterior(q);
        this.size++;
        return q;
    }

    public No insertFirst(Object o){
        No novo = new No(o);
        No proximo = this.head.getProximo();
        this.head.setProximo(novo);
        novo.setAnterior(this.head);
        novo.setProximo(proximo);
        proximo.setAnterior(novo);
        this.size++;
        return novo;
    }

    public No insertLast(Object o){
        No novo = new No(o);
        No anterior =  this.tail.getAnterior();
        this.tail.setAnterior(novo);
        novo.setProximo(this.tail);
        novo.setAnterior(anterior);
        anterior.setProximo(novo);
        this.size++;
        return novo;
    }

    public Object remove(No n){
        Object removido = n.getElemento();
        n.getAnterior().setProximo(n.getProximo());
        n.getProximo().setAnterior(n.getAnterior());
        this.size--;
        return removido;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if (this.size == 0){
            return true;
        }
        else{
            return false;
        }
    }
}