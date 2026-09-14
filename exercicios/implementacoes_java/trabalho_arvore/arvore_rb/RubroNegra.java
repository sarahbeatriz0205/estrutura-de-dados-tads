package arvore_rb;
import arvore_binaria.ArvoreBinariaDePesquisa;
import arvore_binaria.NoArvore;
import arvore_avl.ArvoreAVL; // ainda vai ser usada pra as rotações

public class RubroNegra extends ArvoreBinariaDePesquisa{
    public RubroNegra(int raiz){
        super(raiz);
        this.raiz = transformarNo(raiz);
    }

    @Override 
    protected NoRubroNegro transformarNo(int elemento){
        return new NoRubroNegro(null, null, null, elemento);
    }

   public void casosInsercao(NoRubroNegro no){      
        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();
        NoRubroNegro tio;
        if (pai.getElemento() < avo.getElemento()){ tio = avo.getFilhoDireito(); }
        else { tio = avo.getFilhoEsquerdo(); }

        // caso 1
        if (no.getPai().getCor() == false){
            // caso 2 dentro do caso 1 se possível
            if (pai.getCor() == true && tio.getCor() == true) {
                executaCasoDoisPosInsercao(no);
                // caso 3 dentro do caso 2 depois de passar pelo caso 1 se possível
                if (pai.getCor() == true && tio.getCor() == false) {
                    executaCasoTresPosInsercao(no);
                }
            }
            else {
                // tenta o caso 3 se não cair no caso 2
                if (pai.getCor() == true && tio.getCor() == false) {
                    executaCasoTresPosInsercao(no);
                }
            }
        }
        
   }

    private void executaCasoDoisPosInsercao(NoRubroNegro no){
        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();
        NoRubroNegro tio;

        if (pai.getElemento() < avo.getElemento()){ tio = avo.getFilhoDireito(); }
        else { tio = avo.getFilhoEsquerdo(); }

        // lógica principal
        if (pai == null || pai.getCor() == false) {
            executaCasoTresPosInsercao(no);
        }

        if (tio.getCor() == true) {
            avo.setCor(true);
            tio.setCor(false);
            pai.setCor(false);
        }

        executaCasoDoisPosInsercao(avo);
    }

    private void executaCasoTresPosInsercao(NoRubroNegro no){
        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();
        NoRubroNegro tio;

        if (pai.getElemento() < avo.getElemento()){ tio = avo.getFilhoDireito(); }
        else { tio = avo.getFilhoEsquerdo(); }
        
        // caso 3a: rotação direita simples
        if (tio.getCor() == false && tio.getElemento() < avo.getElemento()) {
            ArvoreAVL.rotacionaDireitaSimples(avo, tio);
        }
        // caso 3b: rotação esquerda simples
        else {
            ArvoreAVL.rotacionaEsquerdaSimples(avo, tio);
        }
        // caso 3c: rotação esquerda simples
        if (no.getElemento() < pai.getElemento() && pai.getElemento() > avo.getElemento()) {
            ArvoreAVL.rotacionaDireitaDupla(avo, tio);
        }
        // caso 3d: rotação esquerda simples
        else if (no.getElemento() > pai.getElemento() && pai.getElemento() < avo.getElemento()) {
            ArvoreAVL.rotacionaEsquerdaDupla(avo, tio);
        }
    }
    
    @Override 
    public NoRubroNegro insert(int elemento, NoArvore no){
        NoRubroNegro inserido = (NoRubroNegro) super.insert(elemento, no);
        casosInsercao(inserido);
        return inserido;
    }
}