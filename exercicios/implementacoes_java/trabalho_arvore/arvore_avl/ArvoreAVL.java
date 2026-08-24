package arvore_avl;
import arvore_binaria.ArvoreBinariaDePesquisa;

public class ArvoreAVL extends ArvoreBinariaDePesquisa{

    public ArvoreAVL(int elemento){
        super(elemento);
    }

    public void rebalancear(NoAVL noDesbalanceado, NoAVL noFilho){
        if (noDesbalanceado.getFB() == -2 && noFilho.getFB() <= 0){
            rotacionarEsquerdaSimples(noDesbalanceado, noFilho);
        }
        else if (noDesbalanceado.getFB() == 2 && noFilho.getFB() >= 0){
            rotacionarDireitaSimples(noDesbalanceado, noFilho);
        }
        else if (noDesbalanceado.getFB() == -2 && noFilho.getFB() >= 0){
            rotacionarDireitaDupla(noDesbalanceado, noFilho);
        }
        else {
            rotacionarEsquerdaDupla(noDesbalanceado, noFilho);
        }
    }

    private void rotacionarEsquerdaSimples(NoAVL noDesbalanceado, NoAVL noFilho){ /* ... */ }
    private void rotacionarDireitaSimples(NoAVL noDesbalanceado, NoAVL noFilho){ /* ... */ }
    private void rotacionarEsquerdaDupla(NoAVL noDesbalanceado, NoAVL noFilho){ /* ... */ }
    private void rotacionarDireitaDupla(NoAVL noDesbalanceado, NoAVL noFilho){ /* ... */ }

}