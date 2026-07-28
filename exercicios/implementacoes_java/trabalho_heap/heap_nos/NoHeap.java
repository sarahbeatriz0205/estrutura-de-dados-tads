package heap_nos;

public class NoHeap {
    private NoHeap filhoEsquerdo;
    private NoHeap filhoDireito;
    private NoHeap pai;
    private Item elemento;

    public NoHeap(NoHeap filhoEsquerdo, NoHeap filhoDireito, NoHeap pai, Item o){
        this.filhoEsquerdo = filhoEsquerdo;
        this.filhoDireito = filhoDireito;
        this.pai = pai;
        this.elemento = o;
    }

    public NoHeap getFilhoEsquerdo(){
        return this.filhoEsquerdo;
    }

    public NoHeap getFilhoDireito(){
        return this.filhoDireito;
    }

    public NoHeap getPai(){
        return this.pai;
    }

    public Item getElemento(){
        return this.elemento;
    }

    public void setFilhoEsquerdo(NoHeap v){
        this.filhoEsquerdo = v;
    }

    public void setFilhoDireito(NoHeap v){
        this.filhoDireito = v;
    }

    public void setPai(NoHeap v){
        this.pai = v;
    }

    public void setElemento(Item o){
        this.elemento = o;
    }
}
