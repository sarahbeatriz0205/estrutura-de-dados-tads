namespace ArvoreBinaria;

public class NoArvore {
    private NoArvore FilhoEsquerdo;
    private NoArvore FilhoDireito;
    private NoArvore Pai;
    private int Elemento;

    public NoArvore(NoArvore FilhoEsquerdo, NoArvore FilhoDireito, NoArvore Pai, int Elemento) {
        this.FilhoEsquerdo = FilhoEsquerdo;
        this.FilhoDireito = FilhoDireito;
        this.Pai = Pai;
        this.Elemento = Elemento;
    }

    public NoArvore GetFilhoEsquerdo() {
        return FilhoEsquerdo;
    }

    public NoArvore GetFilhoDireito() {
        return FilhoDireito;
    }

    public NoArvore GetPai() {
        return Pai;
    }

    public int GetElemento() {
        return Elemento;
    }

    public void SetFilhoEsquerdo(NoArvore No) {
        FilhoEsquerdo = No;
    }

    public void SetFilhoDireito(NoArvore No) {
        FilhoDireito = No;
    }

    public void SetPai(NoArvore No) {
        Pai = No;
    }

    public void SetElemento(NoArvore No) {
        Elemento = No;
    }
}