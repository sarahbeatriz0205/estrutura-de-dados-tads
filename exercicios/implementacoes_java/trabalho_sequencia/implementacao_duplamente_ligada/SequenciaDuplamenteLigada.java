package exercicios.trabalho_sequencia.implementacao_duplamente_ligada;

public class SequenciaDuplamenteLigada extends ListaDuplamenteEncadeada{
    private No head;
    private No tail;
    private int size;

    public SequenciaDuplamenteLigada(){
        this.head = new No(null);
        this.tail = new No(null);
        this.head.setProximo(tail);
        this.head.setAnterior(null);
        this.tail.setAnterior(head);
        this.tail.setProximo(null);
        this.size = 0;
    }

    // Métodos "ponte"
    public No atRank(int rank) throws SequenciaExcecao{
        if (rank < 0 || rank >= this.size){
            throw new SequenciaExcecao("Erro! Rank inválido");
        }
        No aux;
        if (rank <= this.size/2){
            aux = this.head.getProximo();
            for (int i=0; i < rank; i++){
                aux = aux.getProximo();
            }
        }
        else{
            aux = this.tail.getAnterior();
            for (int i=0; i < this.size-rank-1; i++){
                aux = aux.getAnterior();
            }
        }
        return aux;
    }

    public int rankOf(No no) throws SequenciaExcecao{
        if (no == null || no == head || no == tail) {
            throw new SequenciaExcecao("Exceção! Nó inválido");
        }
        No n =  this.head.getProximo();
        int r = 0;
        while (n != no && n != this.tail){
            n = n.getProximo();
            r++;
        }
        return r;
    }

    // Métodos de vetor
    public Object elemAtRank(int r) throws SequenciaExcecao{
        No aux = this.head.getProximo();
        if (r < 0 || r >= this.size){
            throw new SequenciaExcecao("Erro! Rank inválido");
        }
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        return aux.getElemento();
    }

    public Object removeAtRank(int r) throws SequenciaExcecao{
        if (r < 0 || r >= this.size){
            throw new SequenciaExcecao("Erro! Rank inválido");
        }
        if (isEmpty()){
            throw new SequenciaExcecao("Erro! Vetor vazio");
        }
        No aux = atRank(r);
        Object element = aux.getElemento();
        No anterior = aux.getAnterior();
        No proximo = aux.getProximo();
        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);
        this.size--;
        return element;
    }

    public Object replaceAtRank(int r, Object o) throws SequenciaExcecao{
        if (r >= this.size || r < 0){
            throw new SequenciaExcecao("Erro! Rank inválido");
        }
        No aux = this.head.getProximo();
        Object element;
        for (int i=0; i < r; ++i){
            aux = aux.getProximo();
        }
        element = aux.getElemento();
        aux.setElemento(o);
        return element;
    }

    public void insertAtRank(int r, Object o) throws SequenciaExcecao{
        No novo = new No(o);
        if (r < 0 || r > this.size){
            throw new SequenciaExcecao("Erro! Rank Inválido!");
        }
        if (this.size == 0) {
            this.head.setProximo(novo);
            novo.setAnterior(this.head);
            this.tail.setAnterior(novo);
            novo.setProximo(this.tail);
        } 
        else if (r == 0) {
            novo.setProximo(this.head.getProximo());
            this.head.getProximo().setAnterior(novo);
            this.head.setProximo(novo);
            novo.setAnterior(this.head);
        }
        else if (r == this.size){
            No ultimo = this.tail.getAnterior(); 
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            novo.setProximo(this.tail);
            this.tail.setAnterior(novo);
        }
        else{
            No aux = this.head.getProximo();
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
        this.size++; 
    }
}