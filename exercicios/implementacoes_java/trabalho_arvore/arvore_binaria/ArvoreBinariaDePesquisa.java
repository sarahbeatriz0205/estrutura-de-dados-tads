package arvore_binaria;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaDePesquisa{
    public NoArvore raiz;
    public int size;
    public ArrayList<NoArvore> nos;

    public ArvoreBinariaDePesquisa(int o){
        this.raiz = new NoArvore(null, null, null, o);
        this.size = 1;
        this.nos = new ArrayList<>();
        nos.add(this.raiz);
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if (this.size == 0){ 
            return true; 
        } 
        return false;
    }

    public int depht(NoArvore v){
        if (isRoot(v)){
            return 0;
        }
        return 1+depht(parent(v));
    }

    public int heigth(NoArvore r, NoArvore v){
        if (isExternal(v)){
            return 0;
        }
        else{
            int h = 0;
            Iterator<NoArvore> f = children(v);
            while (f.hasNext()){
                NoArvore w = f.next();
                h = Math.max(h, heigth(r, w));
            }
            return 1+h;
        }
    }


    public Iterator<NoArvore> children(NoArvore v){
        List<NoArvore> filhos = new ArrayList<>();
        if (v.getFilhoEsquerdo() != null){
            filhos.add(v.getFilhoEsquerdo());
        }
        if (v.getFilhoDireito() != null){
            filhos.add(v.getFilhoDireito());
        }
        return filhos.iterator();
    }

    public boolean isExternal(NoArvore v){
        if (v.getFilhoEsquerdo() == null && v.getFilhoDireito() == null){
            return true;
        }
        return false;
    }

    public boolean isInternal(NoArvore v){
        if (v.getFilhoEsquerdo() != null || v.getFilhoDireito() != null){
            return true;
        }
        return false;
    }

    public boolean isRoot(NoArvore v){
        if (v.getPai() == null){
            return true;
        }
        return false;
    }

    public NoArvore root(){
        return this.raiz;
    }

    public NoArvore leftChild(NoArvore v){
        return v.getFilhoEsquerdo();
    }

    public NoArvore rightChild(NoArvore v){
        return v.getFilhoDireito();
    }

    public boolean hasLeft(NoArvore v){
        if (leftChild(v) != null){
            return true;
        }
        return false;
    }

    public boolean hasRight(NoArvore v){
        if (rightChild(v) != null){
            return true;
        }
        return false;
    }

    public NoArvore parent(NoArvore v){
        return v.getPai();
    }

    public Iterator<Object> elements(){
		ArrayList<Object> elementos = new ArrayList<Object>();
		for (NoArvore n : nos){
			elementos.add(n.getElemento());
		}
		return elementos.iterator();
	}

    public Iterator<NoArvore> nos(){
		return this.nos.iterator();
	}

    public void preOrder(NoArvore v){
        if (v == null){
            return;
        }
        visite(v);
        preOrder(leftChild(v));
        preOrder(rightChild(v));
    }

    public void postOrder(NoArvore v){
        if (v == null){
            return;
        }
        postOrder(leftChild(v));
        postOrder(rightChild(v));
        visite(v);
    }

    public void inOrder(NoArvore v){
        if (v == null){
            return;
        }
        inOrder(leftChild(v));
        visite(v);
        inOrder(rightChild(v));
    }

    public void visite(NoArvore v){
        System.out.print(v.getElemento() + " ");
    }

    public NoArvore search(int k, NoArvore v){
        if (k == v.getElemento()){
            return v;
        }  
        if (k < v.getElemento() && v.getFilhoEsquerdo() != null){
                return search(k, v.getFilhoEsquerdo());
        }
        if (k > v.getElemento() && v.getFilhoDireito() != null){
            return search(k, v.getFilhoDireito());
        }
        return v;
    }

    public void insert(int k, NoArvore v) throws ArvoreExcecao{
        NoArvore encontrado = search(k, v);
        if (encontrado.getElemento() == k){
            throw new ArvoreExcecao("Erro! Nó já existente");
        }

        NoArvore novo = new NoArvore(null, null, encontrado, k);

        if (novo.getElemento() < encontrado.getElemento()){
            encontrado.setFilhoEsquerdo(novo);
        }
        else {
            encontrado.setFilhoDireito(novo);
        }
        this.nos.add(novo);
        this.size++;
    } 

    public int remove(NoArvore v){
        int element = v.getElemento();

        /* Se um nó for externo, basta ele virar null */
        if (isExternal(v) && v != null){
            if (v.getElemento() < v.getPai().getElemento()){
                v.getPai().setFilhoEsquerdo(null);
            } else {
                v.getPai().setFilhoDireito(null);
            }
            this.size--;
            this.nos.remove(v);
            return element;
        }

        /* Se o nó tiver apenas UM filho */
        if (v.getFilhoEsquerdo() == null || v.getFilhoDireito() == null) {
            NoArvore filho;
            if (v.getFilhoEsquerdo() != null)
                filho = v.getFilhoEsquerdo();
            else
                filho = v.getFilhoDireito();

            filho.setPai(v.getPai());
            if (filho.getElemento() < v.getPai().getElemento())
                v.getPai().setFilhoEsquerdo(filho);
            else
                v.getPai().setFilhoDireito(filho);
            this.size--;
            this.nos.remove(v);
            return element;
        }

        /* Nó com DOIS filhos */
        NoArvore sucessor = v.getFilhoDireito();
        while (sucessor.getFilhoEsquerdo() != null) {
            sucessor = sucessor.getFilhoEsquerdo();
        }
        int temp = sucessor.getElemento();
        remove(sucessor);
        v.setElemento(temp);
        return element;
    }

    private void preencherMatriz(NoArvore no, int[][] matriz, int linha, int coluna, int deslocamento){
        if (no == null || linha >= matriz.length || coluna < 0 || coluna >= matriz[0].length) return;
        if (deslocamento < 1) deslocamento = 1;
        
        matriz[linha][coluna] = no.getElemento();

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


    public void imprimirArvore(){
    int h = heigth(this.raiz, this.raiz);
    int linhas  = h + 1;
    int colunas = (int)Math.pow(2, h + 2) - 1;

    int[][] matriz = new int[linhas][colunas];
    preencherMatriz(this.raiz, matriz, 0, colunas / 2, colunas / 4);

    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            if (matriz[i][j] == 0) System.out.print("    ");
            else                   System.out.printf("%4d", matriz[i][j]);
        }
        System.out.println();
        }
    }
}