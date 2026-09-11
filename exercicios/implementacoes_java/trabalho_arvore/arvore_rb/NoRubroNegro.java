package arvore_rb;
import arvore_binaria.NoArvore;

public class NoRubroNegro extends NoArvore{
    private boolean cor; // true = rubro e false = negro

    public NoRubroNegro(NoRubroNegro filhoEsquerdo, NoRubroNegro filhoDireito, NoRubroNegro pai, int o){
        super(filhoEsquerdo, filhoDireito, pai, o);
        this.cor = true; // nó sempre começa rubro
    }

    @Override
    public NoRubroNegro getFilhoEsquerdo(){
        return (NoRubroNegro) this.filhoEsquerdo;
    }

    @Override
    public NoRubroNegro getFilhoDireito(){
        return (NoRubroNegro) this.filhoDireito;
    }
    
    @Override
    public NoRubroNegro getPai(){
        return (NoRubroNegro) this.pai;
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

    public boolean getCor(){
        return this.cor;
    }

    public void setCor(boolean cor){
        this.cor = cor;
    }
}