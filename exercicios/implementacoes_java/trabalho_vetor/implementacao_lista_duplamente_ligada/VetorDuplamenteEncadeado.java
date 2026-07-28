package exercicios.trabalho_vetor.implementacao_lista_duplamente_ligada;

public class VetorDuplamenteEncadeado implements IVetor{
    private No head;
    private No tail;
    private int size;

    public VetorDuplamenteEncadeado(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if (this.head == null && this.tail == null){
            return true;
        }
        return false;
    }

    public Object elemAtRank(int r) throws VetorExcecao{
        No aux = this.head.getProximo();
        if (r < 0 || r >= size()){
            throw new VetorExcecao("Erro! Rank inválido");
        }
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        return aux.getElemento();
    }

    public Object removeAtRank(int r) throws VetorExcecao{
        if (r < 0 || r >= size()){
            throw new VetorExcecao("Erro! Rank inválido");
        }
        if (isEmpty()){
            throw new VetorExcecao("Erro! Vetor vazio");
        }
        No aux = this.head;
        Object element;
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        element = aux.getElemento();
        if (aux.getAnterior() != null){
            aux.getAnterior().setProximo(aux.getProximo());
        }
        else{
            this.head = aux.getProximo();
        }
        if (aux.getProximo() != null){
            aux.getProximo().setAnterior(aux.getAnterior());
        }
        else{
            this.tail = aux.getAnterior();
        } 
        this.size--;
        return element;  
    }

    public Object replaceAtRank(int r, Object o) throws VetorExcecao{
        if (r > size()){
            throw new VetorExcecao("Erro! Rank inválido");
        }
        No aux = this.head;
        Object element;
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        element = aux.getElemento();
        aux.setElemento(o);
        return element;
    }

    public void insertAtRank(int r, Object o) throws VetorExcecao{
        if (r > size()){
            throw new VetorExcecao("Erro! Rank inválido");
        }
        else{
            No novo = new No(o);
            if (this.size == 0) {
                this.head = novo;
                this.tail = novo;
            } 
            else if (r == 0) {
                novo.setProximo(this.head);
                this.head.setAnterior(novo);
                this.head = novo;
            }
            else if (r == this.size){
                No ultimo = this.tail; 
                ultimo.setProximo(novo);
                novo.setAnterior(ultimo);
                tail = novo;
            }
            else{
                No aux = this.head;
                No anterior;
                for (int i=0; i < r; ++i){
                    aux = aux.getProximo();
                }
                anterior = aux.getAnterior();
                novo.setProximo(aux);
                novo.setAnterior(anterior);
                aux.setAnterior(novo);
                anterior.setProximo(novo);
            } 
        }
        this.size++;
    }
}