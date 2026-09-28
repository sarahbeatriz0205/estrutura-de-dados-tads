package arvore_rb;
import arvore_binaria.ArvoreBinariaDePesquisa;
import arvore_binaria.NoArvore;

public class RubroNegra extends ArvoreBinariaDePesquisa{
    public RubroNegra(int raiz){
        super(raiz);
        this.raiz = transformarNo(raiz);
        ((NoRubroNegro) this.raiz).setCor(false);
    }

    @Override 
    protected NoRubroNegro transformarNo(int elemento){
        return new NoRubroNegro(null, null, null, elemento);
    }

    private boolean verificaNull(NoRubroNegro no) {
        if (no == null) {
            return false; // se o nó for nulo, ele é negro
        }
        return no.getCor(); // se não for, vai retornar a cor real dele
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

        if (pai.getCor() == true && verificaNull(tio) == true && avo.getCor() == false) {
            executaCasoDoisPosInsercao(no);
        }

        if (avo.getCor() == false && verificaNull(tio) == false && pai.getCor() == true) {
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
        if (isRoot(avo)) {
            avo.setCor(false);
            tio.setCor(false);
            pai.setCor(false);
        }
        else {
            avo.setCor(true);
            tio.setCor(false);
            pai.setCor(false);
        }

        // verifica se cai em outro caso
        if (avo.getPai() != null && avo.getPai().getCor() == true) {
            casosInsercao(avo); // avo vira novo candidato pra deixar a árvore desbalanceada
        }
    }

    public void executaCasoTresPosInsercao(NoRubroNegro no){
        NoRubroNegro pai = no.getPai();
        NoRubroNegro avo = pai.getPai();

        // caso 3c: rotação dupla (pai é filho esquerdo, nó é filho direito)
        if (pai.getElemento() < avo.getElemento() && no.getElemento() > pai.getElemento()) {
            rotacionaDireitaDupla(pai, no);  
            no.setCor(false);
            avo.setCor(true);
        }
        // caso 3d: rotação dupla (pai é filho direito, nó é filho esquerdo)
        else if (pai.getElemento() > avo.getElemento() && no.getElemento() < pai.getElemento()) {
            rotacionaEsquerdaDupla(pai, no);
            // troca cor dps do processo
            no.setCor(false);
            avo.setCor(true);
        }
        // caso 3a: rotação direita simples (pai e nó são filhos esquerdos)
        else if (pai.getElemento() < avo.getElemento()) {
            rotacionaDireitaSimples(avo, pai);
            // troca cor dps do processo
            pai.setCor(false);
            avo.setCor(true);
        }
        // caso 3b: rotação esquerda simples (pai e nó são filhos direitos)
        else {
            rotacionaEsquerdaSimples(avo, pai);
            // troca cor dps do processo
            pai.setCor(false);
            avo.setCor(true);
        }
    }

    // rotações refeitas (eu acho né) porque tem que mudar a cor
    private void rotacionaDireitaSimples(NoRubroNegro avo, NoRubroNegro pai) {
        if (pai.getFilhoDireito() == null && isRoot(avo)){
            pai.setFilhoDireito(avo);
            avo.setFilhoEsquerdo(null); 
            avo.setPai(pai);
            pai.setPai(null);
            this.raiz = pai;
            return;
        }
        else if (!isRoot(avo) && pai.getFilhoDireito() != null){
            NoRubroNegro antigoPai = avo.getPai();
            NoRubroNegro filhoDir = pai.getFilhoDireito();
            pai.setFilhoDireito(avo);
            if (avo.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(pai);
            }
            else {
                antigoPai.setFilhoDireito(pai);
            }
            avo.setPai(pai);
            avo.setFilhoEsquerdo(filhoDir);
            filhoDir.setPai(avo);
            pai.setPai(antigoPai);
            return;
        }
        else if(isRoot(avo) && pai.getFilhoDireito() != null){
            NoRubroNegro filhoDir = pai.getFilhoDireito();
            pai.setFilhoDireito(avo);
            avo.setPai(pai);
            avo.setFilhoEsquerdo(filhoDir);
            filhoDir.setPai(avo);
            pai.setPai(null);
            this.raiz = pai;
            return;
        }
        else if (pai.getFilhoDireito() == null && !isRoot(avo)){
            NoRubroNegro antigoPai = avo.getPai();
            pai.setFilhoDireito(avo);
            if (avo.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(pai);
            }
            else {
                antigoPai.setFilhoDireito(pai);
            }
            avo.setFilhoEsquerdo(null); 
            avo.setPai(pai);
            pai.setPai(antigoPai);
            return;
        }
    }

    private void rotacionaEsquerdaSimples(NoRubroNegro avo, NoRubroNegro pai) {
        if (pai.getFilhoEsquerdo() == null && isRoot(avo)){
            pai.setFilhoEsquerdo(avo);
            avo.setFilhoDireito(null);
            avo.setPai(pai);
            pai.setPai(null);
            this.raiz = pai;
            return;
        }
        else if (!isRoot(avo) && pai.getFilhoEsquerdo() != null){
            NoRubroNegro antigoPai = avo.getPai();
            NoRubroNegro filhoEsq = pai.getFilhoEsquerdo();
            pai.setFilhoEsquerdo(avo);
            if (avo.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(pai);
            }
            else {
                antigoPai.setFilhoDireito(pai);
            }
            avo.setPai(pai);
            avo.setFilhoDireito(filhoEsq);
            filhoEsq.setPai(avo);
            pai.setPai(antigoPai);
            return;
        }
        else if(isRoot(avo) && pai.getFilhoEsquerdo() != null){
            NoRubroNegro filhoEsq = pai.getFilhoEsquerdo();
            pai.setFilhoEsquerdo(avo);
            avo.setPai(pai);
            avo.setFilhoDireito(filhoEsq);
            filhoEsq.setPai(avo);
            pai.setPai(null);
            this.raiz = pai;
            return;
        }
        else if (pai.getFilhoEsquerdo() == null && !isRoot(avo)){
            NoRubroNegro antigoPai = avo.getPai();
            pai.setFilhoEsquerdo(avo);
            if (avo.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(pai);
            }
            else {
                antigoPai.setFilhoDireito(pai);
            }
            avo.setFilhoDireito(null);
            avo.setPai(pai);
            pai.setPai(antigoPai);
            return;
        }
    }

    private void rotacionaDireitaDupla(NoRubroNegro pai, NoRubroNegro filho) {
        NoRubroNegro avo = pai.getPai();
        rotacionaEsquerdaSimples(pai, filho);
        rotacionaDireitaSimples(avo, filho);
    }

    private void rotacionaEsquerdaDupla(NoRubroNegro pai, NoRubroNegro filho) {
        NoRubroNegro avo = pai.getPai();
        rotacionaDireitaSimples(pai, filho);
        rotacionaEsquerdaSimples(avo, filho);
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
            if (verificaNull(irmao.getFilhoDireito()) == false && verificaNull(irmao.getFilhoEsquerdo()) == false && pai.getCor() == false) {
                executaCasoDoisASituacaoTresPosRemocao(pai, irmao);
                return;
            }
            // caso 2b
            else if (verificaNull(irmao.getFilhoDireito()) == false && (verificaNull(irmao.getFilhoEsquerdo())) == false && pai.getCor() == true) {
                executaCasoDoisBSituacaoTresPosRemocao(pai, irmao);
                return;
            }

            // caso 3
            if ((verificaNull(irmao.getFilhoEsquerdo())) == true && verificaNull(irmao.getFilhoDireito()) == false) {
                executaCasoTresSituacaoTresPosRemocao(sucessor, irmao);
                return;
            }

            // caso 4
            else if ((verificaNull(irmao.getFilhoEsquerdo()) == true || verificaNull(irmao.getFilhoEsquerdo()) == false) && verificaNull(irmao.getFilhoDireito()) == false) {
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
            if (verificaNull(irmao.getFilhoDireito()) == false && verificaNull(irmao.getFilhoEsquerdo()) == false && pai.getCor() == false) {
                executaCasoDoisASituacaoTresPosRemocao(pai, irmao);
                return;
            }
            // caso 2b
            else if (verificaNull(irmao.getFilhoDireito()) == false && verificaNull(irmao.getFilhoEsquerdo()) == false && pai.getCor() == true) {
                executaCasoDoisBSituacaoTresPosRemocao(pai, irmao);
                return;
            }

            // caso 3
            if (verificaNull(irmao.getFilhoEsquerdo()) == true && verificaNull(irmao.getFilhoDireito()) == false) {
                executaCasoTresSituacaoTresPosRemocao(sucessor, irmao);
                return;
            }

            // caso 4
            else if ((verificaNull(irmao.getFilhoEsquerdo()) == true || verificaNull(irmao.getFilhoEsquerdo()) == false) && verificaNull(irmao.getFilhoDireito()) == false) {
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
        casosRemocao(removido);
        return elemento;
    }

    @Override
    protected void preencherMatriz(NoArvore no, String[][] matriz, int linha, int coluna, int deslocamento){
        if (no == null || linha >= matriz.length || coluna < 0 || coluna >= matriz[0].length) return;
        if (deslocamento < 1) deslocamento = 1;
        NoRubroNegro noTransformado = (NoRubroNegro) no;
        
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