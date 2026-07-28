package exercicios.trabalho_lista.implementacao_lista_duplamente_ligada;

public class No{
    private No proximo;
    private No anterior;
    private Object elemento;

    public No(Object o){
        this.proximo = null;
        this.anterior = null;
        this.elemento = o;
    }

    public No getProximo(){
        return this.proximo;
    }

    public No getAnterior(){
        return this.anterior;
    }

    public Object getElemento(){
        return this.elemento;
    }

    public void setProximo(No proximo){
        this.proximo = proximo;
    }

    public void setAnterior(No anterior){
        this.anterior = anterior;
    }

    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
}
