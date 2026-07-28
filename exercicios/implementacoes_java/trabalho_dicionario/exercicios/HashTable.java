package exercicios;
import java.util.ArrayList;
import java.util.Comparator;

class HashTable{
    private Item e;
    private ArrayList<Item> dicionario = new ArrayList<>();

    public HashTable(Item e){
        this.e = e;
        this.dicionario.add(this.e);
    }

    private Object buscaBinaria(ArrayList<Item> itens, int k, int min, int max){
        int m  = (max+min)/2;
        int meio = itens[m];

        if (min < max){
            return NO_SUCH_KEY;
        } 
        else if (meio.key() == k){
            return meio.value();
        }
        else if (k < meio.key()){
            buscaBinaria(itens, k, min, m - 1);
        }
        else if (k > meio.key()){
            buscaBinaria(itens, k, m + 1, max);
        }
        return NO_SUCH_KEY;
    }

    private int funcaoPrimaria(int k){
        return k % dicionario.length;
    }


    public Object findElement(int k){
        this.dicionario.sort(Comparator.comparingInt(Item::key)); // conferir, porque provavelmente não vai dar certo ordenar assim
        int elementoMax = dicionario.length - 1;
        int max = dicionario[elementoMax].key();
        int min = dicionario[0].key();

        Object b = buscaBinaria(this.dicionario, k, min, max);

        return b;
    }

    public void insertElement(Item k){
        int f = funcaoPrimaria(k.key());

        
    }
}