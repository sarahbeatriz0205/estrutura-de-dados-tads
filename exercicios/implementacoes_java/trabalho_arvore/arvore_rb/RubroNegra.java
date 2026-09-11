package arvore_rb;
import arvore_binaria.ArvoreBinariaDePesquisa;
import arvore_binaria.NoArvore;
import arvore_avl.ArvoreAVL; // ainda vai ser usada pra as rotações

/* 
    1 - Se v é nó externo , v é negro
    2 - O nó raiz é negro
    3 - Se v é rubro, então ambos os filhos são negros
    4 - Os caminhos de v para seus nós descendentes externos possuem idêntico número de nós negros
*/

public class RubroNegra extends ArvoreBinariaDePesquisa{
    public RubroNegra(int raiz){
        super(raiz);
        this.raiz = transformarNo(raiz);
    }

    @Override 
    protected NoRubroNegro transformarNo(int elemento){
        return new NoRubroNegro(null, null, null, elemento);
    }

    /*
        Suponha w(pai de v) rubro e t, o pai
        de w(avó de v) é negro. Se u, o irmão de w
        (tio de v) é rubro, ainda é possível manter o
        critério IV apenas fazendo a re-coloração de
        t(Rubro),u(Negro) e w(Negro)
    */
   public void casosInsercao(NoRubroNegro no){
        if (no == null || no.getPai() == null) {
            return;
        }
        
        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();
        NoRubroNegro tio;
        if (pai.getElemento() < avo.getElemento()){ tio = avo.getFilhoDireito(); }
        tio = avo.getFilhoEsquerdo();

        // caso 1
        if (no.getPai().getCor() == false){
            return;
        }
        // caso 2
        else if (pai.getCor() == true && tio.getCor() == true) {
            executaCasoDoisPosInsercao(no);
        }
        else {
            executaCasoTresPosInsercao(no);
        }
   }

    private void executaCasoDoisPosInsercao(NoRubroNegro no){
        if (no == null || no.getPai() == null || no.getPai().getCor() == false) {
            return;
        }

        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();
        NoRubroNegro tio;

        if (pai.getElemento() < avo.getElemento()){ 
            tio = avo.getFilhoDireito(); 
        }
        else { 
            tio = avo.getFilhoEsquerdo(); 
        }

        // lógica principal
        if (pai == null || pai.getCor() == false) {
            return;
        }

        if (tio.getCor() == true) {
            avo.setCor(true);
            tio.setCor(false);
            pai.setCor(false);
        }

        executaCasoDoisPosInsercao(avo);
    }

    private void executaCasoTresPosInsercao(NoRubroNegro no){
        
    }
    
    // chamar o executaCasoUmPosInsercao()
    @Override 
    public NoRubroNegro insert(int elemento, NoArvore no){
        NoRubroNegro inserido = (NoRubroNegro) super.insert(elemento, no);
        casosInsercao(inserido);
        return inserido;
    }
}
