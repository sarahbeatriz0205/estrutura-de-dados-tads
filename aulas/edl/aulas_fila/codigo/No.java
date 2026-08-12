package aulas_fila.codigo;

public class No {
    private Object elemento;
    private No proximo;

    public ClasseNo(Object o){
        this.elemento = o;
    }

    public Object getElemento() {
        return elemento;
    }
    public Object getProximo(){
        this.proximo = proximo;
    }
    public void setElemento(Object o){
        elemento = o;
    }
    public void setProximo(Object o){
        return this.proximo;
    }
}