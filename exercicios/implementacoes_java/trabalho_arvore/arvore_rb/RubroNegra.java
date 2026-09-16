package arvore_rb;
import arvore_binaria.ArvoreBinariaDePesquisa;
import arvore_binaria.NoArvore;

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

        if (no.getPai().getCor() == false){
            return;
        }

        if (pai.getCor() == true && tio.getCor() == true) {
            executaCasoDoisPosInsercao(no);
        }

        if (pai.getCor() == true && tio.getCor() == false) {
            executaCasoTresPosInsercao(no);
        }
        
   }

    private void executaCasoDoisPosInsercao(NoRubroNegro no){
        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();
        NoRubroNegro tio;

        if (pai.getElemento() < avo.getElemento()){ tio = avo.getFilhoDireito(); }
        else { tio = avo.getFilhoEsquerdo(); }

        if (tio.getCor() == true) {
            avo.setCor(true);
            tio.setCor(false);
            pai.setCor(false);
        }

        if (avo.getPai().getCor() == true) {
            executaCasoDoisPosInsercao(avo);
        }
        else { // teoricamente o caso base
            return;
        }
    }

    // rotações refeitas (eu acho né) porque tem que mudar a cor e eu não posso fazer extends
    private void rotacionaDireitaSimples(NoRubroNegro avo, NoRubroNegro irmao) {
        if (irmao.getFilhoDireito() == null && isRoot(avo)){
            irmao.setFilhoDireito(avo);
            avo.setPai(irmao);
            irmao.setPai(null);
            this.raiz = irmao;
            irmao.setCor(false);
            avo.setCor(true);
            return;
        }
        else if (!isRoot(avo) && irmao.getFilhoDireito() != null){
            NoRubroNegro antigoPai = avo.getPai();
            NoRubroNegro filhoDir = irmao.getFilhoDireito();
            irmao.setFilhoDireito(avo);
            if (avo.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(irmao);
            }
            else {
                antigoPai.setFilhoDireito(irmao);
            }
            avo.setPai(irmao);
            avo.setFilhoEsquerdo(filhoDir);
            filhoDir.setPai(avo);
            irmao.setPai(antigoPai);
            // troca cor dps do processo
            irmao.setCor(false);
            avo.setCor(true);
            return;
        }
        else if(isRoot(avo) && irmao.getFilhoDireito() != null){
            NoRubroNegro filhoDir = irmao.getFilhoDireito();
            irmao.setFilhoDireito(avo);
            avo.setPai(irmao);
            avo.setFilhoEsquerdo(filhoDir);
            filhoDir.setPai(avo);
            irmao.setPai(null);
            this.raiz = irmao;
            // troca cor dps do processo
            irmao.setCor(false);
            avo.setCor(true);
            return;
        }
        else if (irmao.getFilhoDireito() == null && !isRoot(avo)){
            NoRubroNegro antigoPai = avo.getPai();
            irmao.setFilhoDireito(avo);
            if (avo.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(irmao);
            }
            else {
                antigoPai.setFilhoDireito(irmao);
            }
            avo.setPai(irmao);
            irmao.setPai(antigoPai);
            // troca cor dps do processo
            irmao.setCor(false);
            avo.setCor(true);
            return;
        }
    }

    private void rotacionaEsquerdaSimples(NoRubroNegro avo, NoRubroNegro irmao) {
        if (irmao.getFilhoEsquerdo() == null && isRoot(avo)){
            irmao.setFilhoEsquerdo(avo);
            avo.setPai(irmao);
            irmao.setPai(null);
            this.raiz = irmao;
            // troca cor dps do processo
            irmao.setCor(false);
            avo.setCor(true);
            return;
        }
        else if (!isRoot(avo) && irmao.getFilhoEsquerdo() != null){
            NoRubroNegro antigoPai = avo.getPai();
            NoRubroNegro filhoEsq = irmao.getFilhoEsquerdo();
            irmao.setFilhoEsquerdo(avo);
            if (avo.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(irmao);
            }
            else {
                antigoPai.setFilhoDireito(irmao);
            }
            avo.setPai(irmao);
            avo.setFilhoDireito(filhoEsq);
            filhoEsq.setPai(avo);
            irmao.setPai(antigoPai);
            // troca cor dps do processo
            irmao.setCor(false);
            avo.setCor(true);
            return;
        }
        else if(isRoot(avo) && irmao.getFilhoEsquerdo() != null){
            NoRubroNegro filhoEsq = irmao.getFilhoEsquerdo();
            irmao.setFilhoEsquerdo(avo);
            avo.setPai(irmao);
            avo.setFilhoDireito(filhoEsq);
            filhoEsq.setPai(avo);
            irmao.setPai(null);
            this.raiz = irmao;
            // troca cor dps do processo
            irmao.setCor(false);
            avo.setCor(true);
            return;
        }
        else if (irmao.getFilhoEsquerdo() == null && !isRoot(avo)){
            NoRubroNegro antigoPai = avo.getPai();
            irmao.setFilhoEsquerdo(avo);
            if (avo.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(irmao);
            }
            else {
                antigoPai.setFilhoDireito(irmao);
            }
            avo.setFilhoDireito(null);
            avo.setPai(irmao);
            irmao.setPai(antigoPai);
            // troca cor dps do processo
            irmao.setCor(false);
            avo.setCor(true);
            return;
        }
    }

    private void rotacionaDireitaDupla(NoRubroNegro avo, NoRubroNegro irmao) {
        rotacionaEsquerdaSimples(avo, irmao);
        rotacionaDireitaSimples(avo, irmao);
    }

    private void rotacionaEsquerdaDupla(NoRubroNegro avo, NoRubroNegro irmao) {
        rotacionaDireitaSimples(avo, irmao);
        rotacionaEsquerdaSimples(avo, irmao);
    }

    private void executaCasoTresPosInsercao(NoRubroNegro no){
        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();
        NoRubroNegro tio;

        if (pai.getElemento() < avo.getElemento()){ tio = avo.getFilhoDireito(); }
        else { tio = avo.getFilhoEsquerdo(); }
        
        // caso 3a: rotação direita simples
        if (tio.getCor() == false && tio.getElemento() < avo.getElemento()) {
            rotacionaDireitaSimples(avo, tio);
        }
        // caso 3b: rotação esquerda simples
        else {
            rotacionaEsquerdaSimples(avo, tio);
        }
        // caso 3c: rotação esquerda simples
        if (no.getElemento() < pai.getElemento() && pai.getElemento() > avo.getElemento()) {
            rotacionaDireitaDupla(avo, tio);
        }
        // caso 3d: rotação esquerda simples
        else if (no.getElemento() > pai.getElemento() && pai.getElemento() < avo.getElemento()) {
            rotacionaEsquerdaDupla(avo, tio);
        }
    }
    
    @Override 
    public NoRubroNegro insert(int elemento, NoArvore no){
        NoRubroNegro inserido = (NoRubroNegro) super.insert(elemento, no);
        casosInsercao(inserido);
        return inserido;
    }
}