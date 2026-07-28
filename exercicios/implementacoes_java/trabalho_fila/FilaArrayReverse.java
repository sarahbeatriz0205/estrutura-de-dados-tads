package exercicios.trabalho_fila;

public class FilaArrayReverse implements IFila{
    private int i;
    private int f;
    private int tamanho;
    private int incremento; 
    private boolean reverse;
    private Object o[];
i
    public FilaArrayReverse(int tamanho, int incremento){
        o = new Object[tamanho];
        this.tamanho = tamanho;
        this.incremento = incremento;
    }

    public void reverse(){
        reverse = !reverse;
    }

    public void enqueue(Object elemento){
        if (size() == this.tamanho - 1){
            int novoTamanho = this.tamanho*2;
            Object[] b = new Object[novoTamanho]; 
            int inicio_dois = i;
            for (int final_dois = 0; final_dois < size(); final_dois++){ 
                b[final_dois] = o[inicio_dois];
                inicio_dois = (inicio_dois+1)%this.tamanho;
            }
            f  = size(); 
            i = 0; 
            this.tamanho = novoTamanho; 
            o = b;
        }
        if (reverse){
            i = (i-1+this.tamanho)%this.tamanho;
            o[i] = elemento;
        }
        else{
            o[f] = elemento; 
            f = (f+1)%this.tamanho;
        }
    }

        
    public Object dequeue() throws FilaVaziaExcecao{
        Object temp = null;
        if(isEmpty()){ throw new FilaVaziaExcecao("A Fila está vazia");}
        else{
            if (reverse){
                f = (f-1+this.tamanho)%this.tamanho;
                temp = o[f]; 
            }
            else{
                temp = o[i]; 
                i = (i+1)%this.tamanho; 
            }
        }
        if (size() <= this.tamanho / 3) {
            int novoTamanho = this.tamanho / 2;
            Object[] b = new Object[novoTamanho];
            int inicio_dois = i;
            for (int final_dois = 0; final_dois < size(); final_dois++) {
                b[final_dois] = o[inicio_dois];
                inicio_dois = (inicio_dois + 1) % this.tamanho;
            }
            f = size();
            i = 0;
            this.tamanho = novoTamanho;
            o = b;
        }
        return temp;
    }

    public int size(){
        return (this.tamanho-i+f)%this.tamanho;
    }

    public boolean isEmpty(){
        return f==i;
    }

    public Object first() throws FilaVaziaExcecao{
        if(isEmpty()){ throw new FilaVaziaExcecao("A Fila está vazia");}
        else{
            if (reverse){
                f = (f-1+this.tamanho)%this.tamanho;
                return o[f];
            }
            else{
                return o[i];
            }
        }
    }
}