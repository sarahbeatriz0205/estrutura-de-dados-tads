package arvore_binaria;

public class TreeSort extends ArvoreBinariaDePesquisa{
    private Integer[] ref;
    private Integer[] ordenada;
    private int i;

    public TreeSort(Integer[] a){
        super(a[0]);
        this.ref = a;
        ordenada = new Integer[a.length];
        this.i = 0;
    }

    public void insert() throws ArvoreExcecao{
        for (int n = 1; n < ref.length; n++){
            super.insert(ref[n], raiz);
        }  
    }

    @Override
    public void visite(NoArvore v){
        ordenada[this.i] = v.getElemento();
        this.i++;
    }

    public void ordenar(){
        inOrder(raiz);
    }

    public Integer[] mostrarOrdenada(){
        return this.ordenada;
    }

}
