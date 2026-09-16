package arvore_avl;
import arvore_binaria.ArvoreBinariaDePesquisa;
import arvore_binaria.NoArvore;

public class ArvoreAVL extends ArvoreBinariaDePesquisa{

    public ArvoreAVL(int elemento){
        super(elemento);
        NoAVL elementoTransformado = transformarNo(elemento);
        this.raiz = elementoTransformado;
    }

    public void rebalancear(NoAVL noDesbalanceado, NoAVL noFilho){
        if (noDesbalanceado.getFB() == -2 && noFilho.getFB() <= 0){
            rotacionaEsquerdaSimples(noDesbalanceado, noFilho);
        }
        else if (noDesbalanceado.getFB() == 2 && noFilho.getFB() >= 0){
            rotacionaDireitaSimples(noDesbalanceado, noFilho);
        }
        else if (noDesbalanceado.getFB() == -2 && noFilho.getFB() >= 0){
            rotacionaDireitaDupla(noDesbalanceado, noFilho);
        }
        else if (noDesbalanceado.getFB() == 2 && noFilho.getFB() <= 0){
            rotacionaEsquerdaDupla(noDesbalanceado, noFilho);
        }
        else {
            return;
        }
    }

    private void atualizaFBPosRotacaoEsquerda(NoAVL noDesbalanceado, NoAVL noFilho){
        int fbNoB = noDesbalanceado.getFB();
        int fbNoA = noFilho.getFB();
        int fbNoBNovo= fbNoB + 1 - Math.min(fbNoA, 0);
        int fbNoANovo= fbNoA + 1 + Math.max(fbNoBNovo, 0);
        noDesbalanceado.setFB(fbNoBNovo);
        noFilho.setFB(fbNoANovo);
    }

    private void atualizaFBPosRotacaoDireita(NoAVL noDesbalanceado, NoAVL noFilho){
        int fbNoB = noDesbalanceado.getFB();
        int fbNoA = noFilho.getFB();
        int fbNoBNovo= fbNoB - 1 - Math.max(fbNoA, 0);
        int fbNoANovo= fbNoA - 1 + Math.min(fbNoBNovo, 0);
        noDesbalanceado.setFB(fbNoBNovo);
        noFilho.setFB(fbNoANovo);
    }

    private void atualizaFBPosInsercao(NoAVL no){
        NoAVL pai = no.getPai();

        // indica que chegou na raiz
        if (pai == null){
            return;
        }
        
        if (no.getElemento() < pai.getElemento()){
            pai.setFB(pai.getFB() + 1);
        }
        else {
            pai.setFB(pai.getFB() - 1);
        }
        // verifica se precisa de balanceamento
        if (pai.getFB() == 2){
            rebalancear(pai, pai.getFilhoEsquerdo());
            return;
        }
        else if (pai.getFB() == -2){
            rebalancear(pai, pai.getFilhoDireito());
            return;
        }
        // caso base
        if (pai.getFB() == 0){
            return;
        }
        atualizaFBPosInsercao(pai);
    }

    private void atualizaFBPosRemocao(NoAVL no){
        NoAVL pai = no.getPai();

        // indica que chegou na raiz
        if (pai == null){
            return;
        }

        if (no.getElemento() < pai.getElemento()){
            pai.setFB(pai.getFB() - 1);
        }
        else {
            pai.setFB(pai.getFB() + 1);
        }
        // verifica se precisa de balanceamento
        if (pai.getFB() == 2){
            rebalancear(pai, pai.getFilhoEsquerdo());
        }
        else if (pai.getFB() == -2){
            rebalancear(pai, pai.getFilhoDireito());
        }
        // caso base
        if (pai.getFB() != 0){
            return;
        }
        atualizaFBPosRemocao(pai);
    }

    private void rotacionaEsquerdaSimples(NoAVL noDesbalanceado, NoAVL noFilho){ 
        if (noFilho.getFilhoEsquerdo() == null && isRoot(noDesbalanceado)){
            noDesbalanceado.setFilhoDireito(null);
            noFilho.setFilhoEsquerdo(noDesbalanceado);
            noDesbalanceado.setPai(noFilho);
            noFilho.setPai(null);
            this.raiz = noFilho;
            atualizaFBPosRotacaoEsquerda(noDesbalanceado, noFilho);
            return;
        }
        else if (!isRoot(noDesbalanceado) && noFilho.getFilhoEsquerdo() != null){
            NoAVL antigoPai = (NoAVL) noDesbalanceado.getPai();
            NoAVL filhoEsq = (NoAVL) noFilho.getFilhoEsquerdo();
            noFilho.setFilhoEsquerdo(noDesbalanceado);
            if (noDesbalanceado.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(noFilho);
            }
            else {
                antigoPai.setFilhoDireito(noFilho);
            }
            noDesbalanceado.setPai(noFilho);
            noDesbalanceado.setFilhoDireito(filhoEsq);
            filhoEsq.setPai(noDesbalanceado);
            noFilho.setPai(antigoPai);
            atualizaFBPosRotacaoEsquerda(noDesbalanceado, noFilho);
            return;
        }
        else if(isRoot(noDesbalanceado) && noFilho.getFilhoEsquerdo() != null){
            NoAVL filhoEsq = (NoAVL) noFilho.getFilhoEsquerdo();
            noFilho.setFilhoEsquerdo(noDesbalanceado);
            noDesbalanceado.setPai(noFilho);
            noDesbalanceado.setFilhoDireito(filhoEsq);
            filhoEsq.setPai(noDesbalanceado);
            noFilho.setPai(null);
            this.raiz = noFilho;
            atualizaFBPosRotacaoEsquerda(noDesbalanceado, noFilho);
            return;
        }
        else if (noFilho.getFilhoEsquerdo() == null && !isRoot(noDesbalanceado)){
            NoAVL antigoPai = (NoAVL) noDesbalanceado.getPai();
            noFilho.setFilhoEsquerdo(noDesbalanceado);
            if (noDesbalanceado.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(noFilho);
            }
            else {
                antigoPai.setFilhoDireito(noFilho);
            }
            noDesbalanceado.setFilhoDireito(null);
            noDesbalanceado.setPai(noFilho);
            noFilho.setPai(antigoPai);
            atualizaFBPosRotacaoEsquerda(noDesbalanceado, noFilho);
            return;
        }
    }

    private void rotacionaDireitaSimples(NoAVL noDesbalanceado, NoAVL noFilho){ 
        if (noFilho.getFilhoDireito() == null && isRoot(noDesbalanceado)){
            noDesbalanceado.setFilhoEsquerdo(null);
            noFilho.setFilhoDireito(noDesbalanceado);
            noDesbalanceado.setPai(noFilho);
            noFilho.setPai(null);
            this.raiz = noFilho;
            atualizaFBPosRotacaoDireita(noDesbalanceado, noFilho);
            return;
        }
        else if (!isRoot(noDesbalanceado) && noFilho.getFilhoDireito() != null){
            NoAVL antigoPai = (NoAVL) noDesbalanceado.getPai();
            NoAVL filhoDir = (NoAVL) noFilho.getFilhoDireito();
            noFilho.setFilhoDireito(noDesbalanceado);
            if (noDesbalanceado.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(noFilho);
            }
            else {
                antigoPai.setFilhoDireito(noFilho);
            }
            noDesbalanceado.setPai(noFilho);
            noDesbalanceado.setFilhoEsquerdo(filhoDir);
            filhoDir.setPai(noDesbalanceado);
            noFilho.setPai(antigoPai);
            atualizaFBPosRotacaoDireita(noDesbalanceado, noFilho);
            return;
        }
        else if(isRoot(noDesbalanceado) && noFilho.getFilhoDireito() != null){
            NoAVL filhoDir = (NoAVL) noFilho.getFilhoDireito();
            noFilho.setFilhoDireito(noDesbalanceado);
            noDesbalanceado.setPai(noFilho);
            noDesbalanceado.setFilhoEsquerdo(filhoDir);
            filhoDir.setPai(noDesbalanceado);
            noFilho.setPai(null);
            this.raiz = noFilho;
            atualizaFBPosRotacaoDireita(noDesbalanceado, noFilho);
            return;
        }
        else if (noFilho.getFilhoDireito() == null && !isRoot(noDesbalanceado)){
            NoAVL antigoPai = (NoAVL) noDesbalanceado.getPai();
            noFilho.setFilhoDireito(noDesbalanceado);
            if (noDesbalanceado.getElemento() < antigoPai.getElemento()){
                antigoPai.setFilhoEsquerdo(noFilho);
            }
            else {
                antigoPai.setFilhoDireito(noFilho);
            }
            noDesbalanceado.setPai(noFilho);
            noFilho.setPai(antigoPai);
            atualizaFBPosRotacaoDireita(noDesbalanceado, noFilho);
            return;
        }
    }

    private void rotacionaEsquerdaDupla(NoAVL noDesbalanceado, NoAVL noFilho){ 
        rotacionaDireitaSimples(noFilho, noFilho.getFilhoDireito());
        rotacionaEsquerdaSimples(noDesbalanceado, noFilho);
    }

    private void rotacionaDireitaDupla(NoAVL noDesbalanceado, NoAVL noFilho){ 
        rotacionaEsquerdaSimples(noFilho, noFilho.getFilhoEsquerdo());
        rotacionaDireitaSimples(noDesbalanceado, noFilho);
    }

    @Override
    protected NoAVL transformarNo(int e){
        return new NoAVL(null, null, null, e);
    }

    @Override
    protected void preencherMatriz(NoArvore no, String[][] matriz, int linha, int coluna, int deslocamento){
        NoAVL noTransformado = (NoAVL) no;
        if (no == null || linha >= matriz.length || coluna < 0 || coluna >= matriz[0].length) return;
        if (deslocamento < 1) deslocamento = 1;
        
        String elementoComFB = noTransformado.getElemento() + " " + "[" + noTransformado.getFB() + "]";

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

    @Override 
    public NoAVL insert(int e, NoArvore no){
        NoAVL novo = (NoAVL) super.insert(e, no);
        atualizaFBPosInsercao(novo);
        return novo;
    }

    @Override 
    public int remove(NoArvore no){
        int elemento = no.getElemento();
        if (no.getFilhoDireito() != null &&  no.getFilhoEsquerdo() != null){
            NoAVL sucessor = (NoAVL) no.getFilhoDireito();
            while (sucessor.getFilhoEsquerdo() != null) {
                sucessor = sucessor.getFilhoEsquerdo();
            }
            int temp = sucessor.getElemento();
            super.remove(sucessor);
            no.setElemento(temp);
            atualizaFBPosRemocao((NoAVL) sucessor);
            return elemento;
        }
        NoAVL ref = (NoAVL) no;
        NoAVL copia = new NoAVL(ref.getFilhoEsquerdo(), ref.getFilhoDireito(), ref.getPai(), ref.getElemento());
        super.remove(no);
        atualizaFBPosRemocao((NoAVL) copia);
        return elemento;
    }
}