package exercicios.trabalho_vetor.implementacao_array;

public class Vetor{
    private int tamanho; 
    private Object a[];

    public Vetor(int tamanho){
        a = new Object[tamanho];
        this.tamanho = tamanho;
    }

    public Object elemAtRank(int r) throws VetorExcecaoArray{
        if (r > tamanho || r < 0){
            throw new VetorExcecaoArray("Erro! Rank fora do limite do vetor ou rank inexistente");
        }
        else{
            return o[r];
        }
    }

    public Object removeAtRank(int r) throws VetorExcecaoArray{
        if (r > tamanho || r < 0){
            throw new VetorExcecaoArray("Erro! Rank fora do limite do vetor ou rank inexistente");
        }
        else{
            Object elemento = o[r];
            for (int i=r; i < tamanho-1; i++){
                o[i] = o[i+1];
            }
            this.tamanho--;
        }
        return elemento;
    }

    public Object replaceAtRank(int r, Object o) throws VetorExcecaoArray{
        if (r > tamanho || r < 0){
            throw new VetorExcecaoArray("Erro! Rank fora do limite do vetor ou rank inexistente");
        }
        else{
            Object elemento = o[r];
            o[r] = o;
            return elemento;
        }
    }

    public void insertAtRank(int r, Object o){
        int n = this.tamanho + 1;
        for (int i = n; i > r; i--){
            o[i] = o[i-1]; 
        }
    }

    public int size(){
        return tamanho;
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
