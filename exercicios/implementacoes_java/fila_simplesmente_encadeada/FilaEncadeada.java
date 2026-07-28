package exercicios.fila_simplesmente_encadeada;

public class FilaEncadeada implements IFila {
    private ClasseNo i;
    private ClasseNo f;
    private int tamanho;

    public FilaEncadeada(){
    // nós de início e fim começam como null, indicando que a fila está vazia
       this.i = null;
       this.f = null;
       this.tamanho = 0;
    }

    public void enqueue(Object o){
        ClasseNo novo = new ClasseNo(o); // nó deve ser criado antes das validações
        if (this.i == null){ // se a fila tiver vazia, início e fim vão ser "novo"
            this.i = novo;
            this.f = novo;
        }
        else{ // se já tiver elementos, faça o nó do fim apontar pra pro nó criado no início com o obj, depois atualize o nó do fim pra ser o novo
            this.f.setProximo(novo);
            this.f = novo;
            }
        this.tamanho++;
        }

    public Object dequeue() throws FilaEncadeadaVaziaExcecao{
        Object antigo;
        if (isEmpty()){
            throw new FilaEncadeadaVaziaExcecao("A fila está vazia");
        }
        else{
            antigo = this.i.getElemento(); // cria uma cópia do elemento do início
            this.i = this.i.getProximo(); // o final não se move no dequeue, só o início
            if (this.i == null){ // se ficar vazia depois da op, apontar início e fim pra null
                this.f = null;
            }
        }
        this.tamanho--;
        return antigo;
        }

    public int size(){
        return this.tamanho;
    }

    public boolean isEmpty(){
        return this.i == null;
    }

    public Object first() throws FilaEncadeadaVaziaExcecao{
        if (i == null){
            throw new FilaEncadeadaVaziaExcecao("A fila está vazia"); 
        }
        return this.i.getElemento();
    }
}
