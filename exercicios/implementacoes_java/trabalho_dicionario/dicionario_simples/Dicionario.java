package dicionario_simples;

public class Dicionario implements IDicionario {
    private Item a[];
    private int tamanho;
    private int elementos;
    private Item AVAILABLE = new Item(-1, "AVAILABLE");

    public Dicionario(int tamanho){
        int novo = Primo.menorPrimoMaiorOuIgualA(tamanho);
        this.tamanho = novo;
        this.elementos = 0;
        a = new Item[this.tamanho];
    }

    private int funcaoPrimaria(int k){
        return k % this.tamanho;
    }

    private int funcaoSecundaria(int k){
    int primoEscolhido = Primo.maiorPrimoMenorQue(this.tamanho);
    int resto = k % primoEscolhido;
    
    if (resto < 0) {
        resto += primoEscolhido;
    }
    
    int resultado = primoEscolhido - resto;
    return resultado;
}

    private double fatorDeCarga(){
        double alfa = (double) size() / a.length; 
        return alfa;
    }

    private double probes(){
        double p = 1.0 / (1.0 - fatorDeCarga());
        return p;
    }

    private void rehash(){
        int tamanhoNovo = Primo.menorPrimoMaiorOuIgualA(this.tamanho*2);
        Item[] ptrAntiga = this.a;
        a = new Item[tamanhoNovo]; 
        this.tamanho = tamanhoNovo;
        this.elementos = 0;

        for (Item item : ptrAntiga){
            if (item != null && item != this.AVAILABLE){
                insertElement(item);
            }
        }
    }

    public int[] keys(){
        int p = 0;
        int[] k = new int[this.elementos];
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && a[i] != this.AVAILABLE){
                k[p++] = a[i].key();
            }
        }
        return k;
    }

    public Object[] elements(){
        int p = 0;
        Object[] k = new Object[this.elementos];
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && a[i] != this.AVAILABLE){
                k[p++] = a[i].value();
            }
        }
        return k;
    }

    public boolean isEmpty(){
        return this.elementos == 0;
        
    }

    public int size(){
        return this.elementos;
    }

    public Object findElement(Item k) throws NoSuchKeyException{
        int resultadoPrimario = funcaoPrimaria(k.key());
        int resultadoSecundario = funcaoSecundaria(k.key());
        int p = 0;

        while (p != this.tamanho) {
            int posicao = (resultadoPrimario + (p*resultadoSecundario)) % this.tamanho;
            Item c = a[posicao];
            if (c == null){
                throw new NoSuchKeyException("NO_SUCH_KEY");
            }
            if (c != this.AVAILABLE && c.key() == k.key()){
                return c.value();
            }
            p++;
        }
        throw new NoSuchKeyException("NO_SUCH_KEY");
    }

    public Object removeElement(Item k){
        Object item = findElement(k);
        Object elemento = item;
        int resultadoPrimario = funcaoPrimaria(k.key());
        int resultadoSecundario = funcaoSecundaria(k.key());
        int p = 0;
        while (p != this.tamanho){
            int posicao = (resultadoPrimario + (p*resultadoSecundario)) % this.tamanho;
            Item c = a[posicao];
            if (c == null){
                return null;
            }
            if (c != null && c != this.AVAILABLE && c.key() == k.key()){
                a[posicao] = AVAILABLE;
                this.elementos--;
                return elemento;
            }
            p++;
        }
        return elemento;
    } 

    public void insertElement(Item k){
        double fatorDeCarga = fatorDeCarga() * 100;

        if (fatorDeCarga > 50){
            rehash();
        }

        int resultadoPrimario = funcaoPrimaria(k.key());
        int resultadoSecundario = funcaoSecundaria(k.key());

        for (int i = 0; i < a.length; i++){
            int posicao = (resultadoPrimario + (i*resultadoSecundario)) % this.a.length;

            if (this.a[posicao] == null || this.a[posicao] == this.AVAILABLE){
                this.a[posicao] = k;
                this.elementos++;
                break;
            }
        }
    }

}