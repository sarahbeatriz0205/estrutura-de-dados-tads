package arvore_binaria;

public class NoArvore{
    private NoArvore filhoEsquerdo;
    private NoArvore filhoDireito;
    private NoArvore pai;
    private int elemento;

    public NoArvore(NoArvore filhoEsquerdo, NoArvore filhoDireito, NoArvore pai, int o){
        this.filhoEsquerdo = filhoEsquerdo;
        this.filhoDireito = filhoDireito;
        this.pai = pai;
        this.elemento = o;
    }

    public NoArvore getFilhoEsquerdo(){
        return this.filhoEsquerdo;
    }

    public NoArvore getFilhoDireito(){
        return this.filhoDireito;
    }

    public NoArvore getPai(){
        return this.pai;
    }

    public int getElemento(){
        return this.elemento;
    }

    public void setFilhoEsquerdo(NoArvore v){
        this.filhoEsquerdo = v;
    }

    public void setFilhoDireito(NoArvore v){
        this.filhoDireito = v;
    }

    public void setPai(NoArvore v){
        this.pai = v;
    }

    public void setElemento(int o){
        this.elemento = o;
    }
}