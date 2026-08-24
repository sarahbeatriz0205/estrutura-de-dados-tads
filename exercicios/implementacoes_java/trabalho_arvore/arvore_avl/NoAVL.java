package arvore_avl;
import arvore_binaria.NoArvore;

public class NoAVL extends NoArvore{
    private int fb;

    public NoAVL(NoAVL filhoEsquerdo, NoAVL filhoDireito, NoAVL pai, int o){
        super(filhoEsquerdo, filhoDireito, pai, o);
        this.fb = 0;
    }

    public int getFB(){
        return this.fb;
    }
}