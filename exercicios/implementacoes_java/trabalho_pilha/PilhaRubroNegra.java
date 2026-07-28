public class PilhaRubroNegra{
    private int capacidade;
    private Object[] a;
    private int tVermelho;
    private int tPreto;

    public PilhaRubroNegra(int capacidade){
        this.capacidade = capacidade;
        tVermelho = -1;
        tPreto = capacidade; // tamanho do array
        a = new Object[capacidade];
    }

    public class PilhaVaziaExcecao extends RuntimeException{
        public PilhaVaziaExcecao(String error){
            super(error);
        }
    }

    private int sizeVermelho() {
        return tVermelho + 1;
    }

    private int sizePreto(){
        return capacidade - tPreto; // subtraindo a capacidade pelo indice atual do preto, dá a qtd de elementos da pilha preta
    }

    private int qtdElementos(){
        return sizeVermelho() + sizePreto();
    }

    private void realocarElementosArray(){
        Object b[] = new Object[capacidade];
        for (int f=0; f <= tVermelho; f++){
            b[f] = a[f];
        }
        int qtdPretos = a.length - tPreto;
        int novoTPreto = capacidade - qtdPretos;
        int indiceNovoAux = novoTPreto;
        for (int i = 0; i < qtdPretos; i++){
            b[indiceNovoAux] = a[tPreto + i];
            indiceNovoAux++;
        }
        a = b;
        tPreto = novoTPreto;
    }

    public void pushVermelho(Object o){
        if (qtdElementos() >= capacidade){
            capacidade *= 2;
            realocarElementosArray();
        }
        a[++tVermelho] = o;
    }

    public void pushPreto(Object o){
        if (qtdElementos() >= capacidade){
            capacidade *= 2;
            realocarElementosArray();
        }
        a[--tPreto] = o;
    }

    public Object popVermelho() throws PilhaVaziaExcecao{
        if (isEmptyVermelho()){
            throw new PilhaVaziaExcecao("Pilha vermelha vazia");
        }
        Object elemento = a[tVermelho--];
        if (qtdElementos() * 3 <= capacidade && capacidade > 3){ // capacidade > 3 pra que o array não fique muito pequeno 
            capacidade /= 2;
            realocarElementosArray();
        }
        return elemento;
    }

    public Object popPreto() throws PilhaVaziaExcecao{
        if (isEmptyPreto())
            throw new PilhaVaziaExcecao("Pilha preta vazia");
        Object elemento = a[tPreto++];
        if (qtdElementos() * 3 <= capacidade && capacidade > 3){
            capacidade /= 2;
            realocarElementosArray();
        }
        return elemento;
    }

    public boolean isEmptyVermelho(){
        return tVermelho == -1;
    }

    public boolean isEmptyPreto(){
        return tPreto == capacidade;
    }

    public Object topVermelho() throws PilhaVaziaExcecao{
        if (isEmptyVermelho()){
            throw new PilhaVaziaExcecao("Pilha vermelha vazia");
        }
        return a[tVermelho];
    }

    public Object topPreto() throws PilhaVaziaExcecao{
        if (isEmptyPreto()){
            throw new PilhaVaziaExcecao("Pilha preta vazia");
        }
        return a[tPreto];
    }

    public int retornaIndiceTopPreto() throws PilhaVaziaExcecao{
        return tPreto;
    }

    public int retornaIndiceTopVermelho() throws PilhaVaziaExcecao{
        return tVermelho;
    }
}