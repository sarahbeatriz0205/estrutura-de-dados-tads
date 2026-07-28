package heap_array;

public class HeapArray{
    private int o[];
    private int tamanho;

    public HeapArray(int capacidade){
        this.tamanho = 0;
        o = new int[capacidade+1];
    }

    public void upheap(){
        int n = this.tamanho;
        
        while (n > 1){
            int p = n/2;

            if (o[n] >= o[p]) {
                break;
            }

            int novo = o[n];
            o[n] = o[p];
            o[p] = novo;
            n = p;
        }
    }

    public void insert(int k){
        this.tamanho++;
        o[this.tamanho] = k;
        upheap();
    }

    public void downheap(){
        int atual = 1;
        while (atual*2 <= this.tamanho){
            int filhoEsquerdo = atual*2;
            int filhoDireito = atual*2+1;
            int menor = o[filhoEsquerdo] < o[filhoDireito] ? filhoEsquerdo : filhoDireito;
            if (filhoDireito <= tamanho && o[filhoDireito] < o[filhoEsquerdo]) {
                menor = filhoDireito;
            }

            if (o[atual] <= o[menor]) {
                break;
            }

            int temp = o[atual];
            o[atual] = o[menor];
            o[menor] = temp;

            atual = menor;
        }
        
    }

    public Object removeMin(){
        Object elemento = o[1];
        o[1] = o[this.tamanho];
        this.tamanho--;
        downheap();
        return elemento;
    }
}