package exercicios.trabalho_sequencia.implementacao_array;

public class Sequencia{
    private int tamanho; 
    private Object a[];

    public Sequencia(int tamanho){
        this.tamanho = 0;
        a = new Object[tamanho];
    } 

    public Object elemAtRank(int r) throws SequenciaExcecaoArray{
        if (r > tamanho || r < 0){
            throw new SequenciaExcecaoArray("Erro! Rank fora do limite do vetor ou rank inexistente");
        }
        else{
            return a[r];
        }
    }

    public Object removeAtRank(int r) throws SequenciaExcecaoArray{
        if (r > tamanho || r < 0){
            throw new SequenciaExcecaoArray("Erro! Rank fora do limite do vetor ou rank inexistente");
        }
        else{
            Object elemento = a[r];
            for (int i=r; i < tamanho-1; i++){
                a[i] = a[i+1];
            }
            this.tamanho--;
        }
        return elemento;
    }

    public Object replaceAtRank(int r, Object o) throws SequenciaExcecaoArray{
        if (r > tamanho || r < 0){
            throw new SequenciaExcecaoArray("Erro! Rank fora do limite do vetor ou rank inexistente");
        }
        else{
            Object elemento = a[r];
            a[r] = o;
            return elemento;
        }
    }

    public void insertAtRank(int r, Object o) throws SequenciaExcecaoArray {
        if (r > tamanho || r < 0) {
            throw new SequenciaExcecaoArray("Erro! Rank inválido");
        }
        if (this.tamanho == a.length) {
            Object[] b = new Object[this.tamanho * 2];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
            a = b;
        }
        for (int i = this.tamanho; i > r; i--) {
            a[i] = a[i - 1]; 
        }
        a[r] = o;
        this.tamanho++;
    }
    
    public Object first(){
        return a[0];
    }

    public Object last(){
        return a[this.tamanho-1];
    }

    public Object before(int p) throws SequenciaExcecaoArray{
        if  (p > this.tamanho || p <= 0){
            throw new SequenciaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            return a[p-1];
        }
    }

    public Object after(int p) throws SequenciaExcecaoArray{
        if  (p > this.tamanho || p < 0){
            throw new SequenciaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            return a[p+1];
        }
    }

    public Object replaceElement(int n, Object o) throws SequenciaExcecaoArray{
        if  (n > this.tamanho || n < 0){
            throw new SequenciaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            Object aux = a[n];
            a[n] = o;
            return aux;
        }
    }

    public void swapElements(int n, int q) throws SequenciaExcecaoArray{
        if  (n >= this.tamanho || n < 0 || q >= this.tamanho || q < 0){
            throw new SequenciaExcecaoArray("Erro! Posição inexistente");
        }
        else{
            Object posicao_n = a[n]; 
            a[n] = a[q];
            a[q] = posicao_n;
        }
    }

    public void insertBefore(int n, Object o) throws SequenciaExcecaoArray{
        if  (n > this.tamanho || n < 0){
            throw new SequenciaExcecaoArray("Erro! Posição inexistente");
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

    public void insertAfter(int n, Object o) throws SequenciaExcecaoArray{
        if (n >= this.tamanho || n < 0){
            throw new SequenciaExcecaoArray("Erro! Posição inexistente");
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

    public Object remove(int n) throws SequenciaExcecaoArray{
        if (n >= this.tamanho || n < 0){
            throw new SequenciaExcecaoArray("Erro! Posição inexistente");
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