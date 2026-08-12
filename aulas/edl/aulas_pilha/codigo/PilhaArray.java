package aulas_pilha.codigo;

public class PilhaArray implements Pilha{
    private int capacidade;
    private Object[] a;
    private int t;
    private int FC;
    
    public PilhaArray(int capacidade, int crescimento){
        this.capacidade = capacidade;
        t = -1;
        FC = crescimento; // fator de crescimento: determina se a estratégia adotada será duplicação ou incremental
        if (crescimento <= 0){
            FC = 0; 
        }
        a = new Object[capacidade];
    }

    public void push(Object o){
        if (t >= capacidade-1){ // testa se o array está cheio
            if (FC == 0){
                capacidade*=2; // estratégia duplicação
            }
            else{
                capacidade += FC; // estratégia incremental
            }
            Object b[] = new Object[capacidade]; // aray com nova capacidade
            for (int f=0; f < a.length; f++){ // copia do array cheio [a] para o array novo [b]
                b[f] = a[f];
            }
            a = b; // referência -> o "a" vai apontar pro "b"
        } // RIP array "a" antigo, F no chat porque o coletor de lixo mata
        a[++t] = o; 
    }

    public Object pop() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("Pilha vazia"); // se o array tiver vazio, lança a exceção (throw)
        }
        return a[t--]; // retorna o elemento do índice anterior ao do topo
    }

    public boolean isEmpty(){
        return t == -1;
    }

    public int size(){
        return t + 1;
    }

    public Object top() throws PilhaVaziaExcecao{
        if (isEmpty()){
            throw new PilhaVaziaExcecao("Pilha vazia");
        }
        return a[t];
    }
}

// System.currentTimeMillis(); -> retorna o tempo em milissegundos