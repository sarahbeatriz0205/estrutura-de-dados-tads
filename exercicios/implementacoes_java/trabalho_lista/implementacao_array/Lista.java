package exercicios.trabalho_lista.implementacao_array;

public class Lista implements ILista{
    private int tamanho; 
    private Object a[];

    public Lista(int tamanho){
        this.tamanho = 0;
        a = new Object[tamanho];
    } 

    public boolean isFirst(Object o){
        if (a[0] == o){ return true; }
        else{ return false; }
    }

    public boolean isLast(Object o){
        if (a[this.tamanho - 1] == o){ return true; }
        else{ return false; }
    }

    public Object first(){
        return a[0];
    }

    public Object last(){
        return a[this.tamanho-1];
    }

    public Object before(int p) throws ListaExcecaoArray{
        if  (p > this.tamanho || p <= 0){
            throw new ListaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            return a[p-1];
        }
    }

    public Object after(int p) throws ListaExcecaoArray{
        if  (p > this.tamanho || p < 0){
            throw new ListaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            return a[p+1];
        }
    }

    public Object replaceElement(int n, Object o) throws ListaExcecaoArray{
        if  (n > this.tamanho || n < 0){
            throw new ListaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            Object aux = a[n];
            a[n] = o;
            return aux;
        }
    }

    public void swapElements(int n, int q) throws ListaExcecaoArray{
        if  (n >= this.tamanho || n < 0 || q >= this.tamanho || q < 0){
            throw new ListaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            Object posicao_n = a[n]; 
            a[n] = a[q];
            a[q] = posicao_n;
        }
    }

    public void insertBefore(int n, Object o) throws ListaExcecaoArray{
        if  (n > this.tamanho || n < 0){
            throw new ListaExcecaoArray("Erro! Posição inexistente");
        }
        if (this.tamanho == a.length){
            Object[] b = new Object[this.tamanho * 2];
            for (int i = 0; i < a.length; i++){
                b[i] = a[i];
            }
            a = b;
        }
        for (int i = this.tamanho; i > n; i--) {
            a[i] = a[i - 1];
        }
        a[n] = o;
        this.tamanho++;
    }

    public void insertAfter(int n, Object o) throws ListaExcecaoArray{
        if (n >= this.tamanho || n < 0){
            throw new ListaExcecaoArray("Erro! Posição inexistente");
        }
        if (this.tamanho == a.length){
            Object[] b = new Object[this.tamanho * 2];
            for (int i = 0; i < a.length; i++){
                b[i] = a[i];
            }
            a = b;
        }
        for (int i = this.tamanho; i > n+1; i--) {
            a[i] = a[i - 1];
        }
        a[n+1] = o;
        this.tamanho++;
    }

    public void insertFirst(Object o){
        if (this.tamanho == a.length){
            Object[] b = new Object[this.tamanho * 2];
            for (int i = 0; i < a.length; i++){
                b[i] = a[i];
            }
            a = b;
        }
        for (int i = this.tamanho; i > 0; i--) {
            a[i] = a[i - 1]; 
        }
        a[0] = o;
        this.tamanho++;
    }

    public void insertLast(Object o){
        if (this.tamanho == a.length){
            Object[] b = new Object[this.tamanho * 2];
            for (int i = 0; i < a.length; i++){
                b[i] = a[i];
            }
            a = b;
        }
        a[this.tamanho] = o;
        this.tamanho++;
    }

    public Object remove(int n) throws ListaExcecaoArray{
        if (n >= this.tamanho || n < 0){
            throw new ListaExcecaoArray("Erro! Posição inexistente");
        }
        Object aux = a[n];
        for (int i = n; i < this.tamanho - 1; i++) {
            a[i] = a[i + 1];
        }
        this.tamanho--;
        return aux;
    }

    public int size(){
        return this.tamanho;
    }

    public boolean isEmpty(){
        if (this.tamanho == 0){
            return true;
        }
        else{
            return false;
        }
    }
}