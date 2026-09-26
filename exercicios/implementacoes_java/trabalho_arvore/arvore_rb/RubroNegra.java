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


    // ===== SÓ PARA INSERÇÃO ===== 
   public void casosInsercao(NoRubroNegro no){      
        NoRubroNegro pai = no.getPai();
        if (pai == null || pai.getCor() == false) {
            return; 
        }

        NoRubroNegro avo = pai.getPai();
        if (avo == null) {
            return; 
        }

        NoRubroNegro tio;
        if (pai.getElemento() < avo.getElemento()){ tio = avo.getFilhoDireito(); }
        else { tio = avo.getFilhoEsquerdo(); }

        if (no.getPai().getCor() == false){
            return;
        }

        if (pai.getCor() == true && tio.getCor() == true && avo.getCor() == false) {
            executaCasoDoisPosInsercao(no);
        }

        if (pai.getCor() == true && tio.getCor() == false && avo.getCor() == false) {
            executaCasoTresPosInsercao(no);
        }
        
   }

    public void executaCasoDoisPosInsercao(NoRubroNegro no){
        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();
        NoRubroNegro tio;

        if (pai.getElemento() < avo.getElemento()){ tio = avo.getFilhoDireito(); }
        else { tio = avo.getFilhoEsquerdo(); }

        // lógica principal
        avo.setCor(true);
        tio.setCor(false);
        pai.setCor(false);

        // verifica se cai em outro caso
        if (avo.getPai() != null || avo.getPai().getCor() == true) {
            casosInsercao(avo); // avo vira novo candidato pra deixar a árvore desbalanceada
        }
    }

    public void executaCasoTresPosInsercao(NoRubroNegro no){
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
        else {
            rotacionaEsquerdaDupla(avo, tio);
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
    
    @Override 
    public NoRubroNegro insert(int elemento, NoArvore no){
        NoRubroNegro inserido = (NoRubroNegro) super.insert(elemento, no);
        inserido.setCor(true);
        casosInsercao(inserido);
        return inserido;
    }

    // ===== SÓ PARA REMOÇÃO =====
    public void casosRemocao(NoRubroNegro no) {
        NoRubroNegro sucessor = no.getFilhoDireito();
        while (sucessor.getFilhoEsquerdo() != null) {
            sucessor = sucessor.getFilhoEsquerdo();
        }  

        NoRubroNegro pai = sucessor.getPai();
        if (pai == null || pai.getCor() == false) {
            return; 
        }

        NoRubroNegro avo = pai.getPai();
        if (avo == null) {
            return; 
        }

        NoRubroNegro irmao;
        if (pai.getElemento() < avo.getElemento()){ irmao = avo.getFilhoDireito(); }
        else { irmao = avo.getFilhoEsquerdo(); }

        // situação 1, não tem casos e nada precisa ser feito. nao chama casos
        if (no.getCor() == true && sucessor.getCor() == true){
            return;
        }

        // situação 2, pinta o sucessor de negro e para. nao chama casos
        if (no.getCor() == false && sucessor.getCor() == true){
            sucessor.setCor(false);
            return;
        }

        // situação 3, nó é negro e sucessor é negro
        if (no.getCor() == false && sucessor.getCor() == false){
            // caso 1
            if (sucessor.getCor() == false && irmao.getCor() == true) {
                executaCasoUmSituacaoTresPosRemocao(sucessor);
                return;
            }

            // caso 2a
            if (irmao.getFilhoDireito().getCor() == false && irmao.getFilhoEsquerdo().getCor() == false && pai.getCor() == false) {
                executaCasoDoisASituacaoTresPosRemocao(pai, irmao);
                return;
            }
            // caso 2b
            else if (irmao.getFilhoDireito().getCor() == false && irmao.getFilhoEsquerdo().getCor() == false && pai.getCor() == true) {
                executaCasoDoisBSituacaoTresPosRemocao(pai, irmao);
                return;
            }

            // caso 3
            if (irmao.getFilhoEsquerdo().getCor() == true && irmao.getFilhoDireito().getCor() == false) {
                executaCasoTresSituacaoTresPosRemocao(sucessor, irmao);
                return;
            }

            // caso 4
            else if ((irmao.getFilhoEsquerdo().getCor() == true || irmao.getFilhoEsquerdo().getCor() == false) && irmao.getFilhoDireito().getCor() == false) {
                executaCasoQuatroSituacaoTresPosRemocao(sucessor, irmao);
                return;
            }
        }

        // situação 4
        if (no.getCor() == true && sucessor.getCor() == false) {
            executaSituacaoQuatroPosRemocao(sucessor);
            return;
        }
    }

    // verificação separada caso caia na situação 4
    public void resolveCasosSituacaoTres(NoRubroNegro no) {
        NoRubroNegro sucessor = no.getFilhoDireito();
        while (sucessor.getFilhoEsquerdo() != null) {
            sucessor = sucessor.getFilhoEsquerdo();
        }  

        NoRubroNegro pai = sucessor.getPai();
        if (pai == null || pai.getCor() == false) {
            return; 
        }

        NoRubroNegro avo = pai.getPai();
        if (avo == null) {
            return; 
        }

        NoRubroNegro irmao;
        if (pai.getElemento() < avo.getElemento()){ irmao = avo.getFilhoDireito(); }
        else { irmao = avo.getFilhoEsquerdo(); }

        // situação 3, nó é negro e sucessor é negro
        if (no.getCor() == false && sucessor.getCor() == false){
            // caso 1
            if (sucessor.getCor() == false && irmao.getCor() == true) {
                executaCasoUmSituacaoTresPosRemocao(sucessor);
                return;
            }

            // caso 2a
            if (irmao.getFilhoDireito().getCor() == false && irmao.getFilhoEsquerdo().getCor() == false && pai.getCor() == false) {
                executaCasoDoisASituacaoTresPosRemocao(pai, irmao);
                return;
            }
            // caso 2b
            else if (irmao.getFilhoDireito().getCor() == false && irmao.getFilhoEsquerdo().getCor() == false && pai.getCor() == true) {
                executaCasoDoisBSituacaoTresPosRemocao(pai, irmao);
                return;
            }

            // caso 3
            if (irmao.getFilhoEsquerdo().getCor() == true && irmao.getFilhoDireito().getCor() == false) {
                executaCasoTresSituacaoTresPosRemocao(sucessor, irmao);
                return;
            }

            // caso 4
            else if ((irmao.getFilhoEsquerdo().getCor() == true || irmao.getFilhoEsquerdo().getCor() == false) && irmao.getFilhoDireito().getCor() == false) {
                executaCasoQuatroSituacaoTresPosRemocao(sucessor, irmao);
                return;
            }
        }
    }

    // caso 1 da situação 3
    public void executaCasoUmSituacaoTresPosRemocao(NoRubroNegro no) {
        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();
        NoRubroNegro irmao;

        if (pai.getElemento() < avo.getElemento()){ irmao = avo.getFilhoDireito(); }
        else { irmao = avo.getFilhoEsquerdo(); }

        // lógica
        rotacionaEsquerdaSimples(pai, irmao);
        irmao.setCor(false);
        pai.setCor(true);
        casosRemocao(no);
    }

    // tô separando esses casos (por mais que pequenos) em métodos 
    // pra eu conseguir visualizar melhor o fluxo lá no casosRemocao()
    
    // caso 2a da situação 3
    public void executaCasoDoisASituacaoTresPosRemocao(NoRubroNegro pai, NoRubroNegro irmao) {
        irmao.setCor(true);
        casosRemocao(pai);
    }

    // caso 2b da situação 3
    public void executaCasoDoisBSituacaoTresPosRemocao(NoRubroNegro pai, NoRubroNegro irmao) {
        irmao.setCor(true);
        pai.setCor(false);
        // eu nao to implementando duplo negro, mas aparentemente ele é absolvido então esse 
        // caso é terminal
    }

    // caso 3 da situação 3
    public void executaCasoTresSituacaoTresPosRemocao(NoRubroNegro sucessor, NoRubroNegro irmao) {
        NoRubroNegro filhoEsq = irmao.getFilhoEsquerdo();
        boolean corPai = irmao.getCor();
        rotacionaDireitaSimples(irmao, filhoEsq);
        irmao.setCor(filhoEsq.getCor()); // troca a cor do irmão pela a do seu filho esquerdo
        filhoEsq.setCor(corPai); // troca a cor do filho esquerdo pela a do seu pai
        executaCasoQuatroSituacaoTresPosRemocao(sucessor, irmao); // passa pro caso 4
    }

    public void executaCasoQuatroSituacaoTresPosRemocao(NoRubroNegro sucessor, NoRubroNegro irmao) {
        NoRubroNegro filhoDir = irmao.getFilhoDireito();
        boolean corPai = irmao.getPai().getCor(); // isso é válido pq antes da rotação, o pai do irmão do sucessor ainda é o pai do sucessor
        rotacionaEsquerdaSimples(irmao, filhoDir);
        sucessor.getPai().setCor(false);
        irmao.setCor(corPai);
        irmao.getFilhoDireito().setCor(false);
        // caso terminal
    }

    public void executaSituacaoQuatroPosRemocao(NoRubroNegro sucessor) {
        sucessor.setCor(true);
        resolveCasosSituacaoTres(sucessor);
    }

    @Override 
    public int remove(NoArvore no) {
        int elemento = no.getElemento();
        NoRubroNegro removido = (NoRubroNegro) no;
        super.remove(removido);
        return elemento;
    }

    @Override
    protected void preencherMatriz(NoArvore no, String[][] matriz, int linha, int coluna, int deslocamento){
        NoRubroNegro noTransformado = (NoRubroNegro) no;
        if (no == null || linha >= matriz.length || coluna < 0 || coluna >= matriz[0].length) return;
        if (deslocamento < 1) deslocamento = 1;
        
        String cor;
        if (noTransformado.getCor() == false) {
            cor = "Negro";
        }
        else {
            cor = "Rubro";
        }

        String elementoComFB = noTransformado.getElemento() + " " + "[" + cor + "]";

        matriz[linha][coluna] = elementoComFB;

        preencherMatriz(
            no.getFilhoEsquerdo(),
            matriz,
            linha + 1,
            coluna - deslocamento,
            deslocamento / 2
        );

        preencherMatriz(
            no.getFilhoDireito(),
            matriz,
            linha + 1,
            coluna + deslocamento,
            deslocamento / 2
        );
    }
}