package aulas_fila.codigo;

public class FilaArray{
    private int i;
    private int f;
    private int tamanho;
    private int incremento; // crescimento
    private Object o[];

    public FilaArray(int tamanho, int incremento){
        o = new Object[tamanho];
        this.tamanho = tamanho;
        this.incremento = incremento;
    }

    public void enqueue(Object elemento){
        if (size() == this.tamanho-1){ // se já estiver cheio
            int novoTamanho; // nova capacidade pro array
            if (incremento == 0){ novoTamanho = this.tamanho*2; } // duplicação
            else{ novoTamanho = this.tamanho+incremento; }
            Object[] b = new Object[novoTamanho]; // array novo com a incrementação
            int inicio_dois = i;
            for (int final_dois = 0; final_dois < size(); final_dois++){ // cópia pro novo array
                b[final_dois] = o[inicio_dois];
                inicio_dois = (inicio_dois+1)%this.tamanho; // recalcula a rota pra o início voltar a ser o índice 0 no novo array
            }
            f  = size(); // novo final
            i = 0; // novo início
            this.tamanho = novoTamanho; // atualizando o tamanho
            o = b; // lista original agora aponta pra a cópia; aqui a lista original ANTIGA é levada pelo garbage collector
        }
        o[f] = elemento; // insere o novo elemento
        f = (f+1)%this.tamanho; // recalcula só o final depois de inserir o elemento
    }

    public Object dequeue() throws FilaVaziaExcecao{
        if(isEmpty()){ throw new FilaVaziaExcecao("A Fila está vazia");}
        Object temp = o[i]; // cria uma cópia do elemento do início
        i = (i+1)%this.tamanho; // avança o início pra remover o elemento que antes era o início
        return temp; // retorna o elemento removido
    }

    public int size(){
        return (this.tamanho-i+f)%this.tamanho;
    }

    public boolean isEmpty(){
        return f==i;
    }

    public Object first(){
        return o[i];
    }
}