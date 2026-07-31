namespace ArvoreBinariaPesquisa;

public class No {

    // a interrogação permite que sejam aceitos valores nulos
    // usei properties do c# pra os getters e setters
    
    public No? FilhoEsquerdo {get; set;}
    public No? FilhoDireito {get; set;}
    public No? Pai {get; set;}
    public int Elemento {get; set;}

    public No(No? FilhoEsquerdo, No? FilhoDireito, No? Pai, int Elemento) {
        this.FilhoEsquerdo = FilhoEsquerdo;
        this.FilhoDireito = FilhoDireito;
        this.Pai = Pai;
        this.Elemento = Elemento;
    }
}