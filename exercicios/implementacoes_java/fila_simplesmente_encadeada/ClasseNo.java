package exercicios.fila_simplesmente_encadeada;

public class ClasseNo {
    private Object elemento;
    private ClasseNo proximo;

    public ClasseNo(Object o){
        this.elemento = o;
    }
    public Object getElemento() {
        return elemento;
    }
    public void setProximo(ClasseNo o){
        this.proximo = o;
    }
    public ClasseNo getProximo(){
        return this.proximo;
    }
    public void setElemento(Object o){
        elemento = o;
    }
}