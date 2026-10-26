package arvore_b;

public class ArvoreB {
    private NoB raiz;
    private int ordem;

    public ArvoreB(int ordem) {
        this.raiz = new NoB(ordem);
        this.ordem = ordem;
    }

    public NoB getRaiz() {
        return this.raiz;
    }

    // busca normal pra achar um item
    public Item buscar(NoB noProx, Item itemBuscado){
        Item itemEncontrado;
        for (int i = 0; i < noProx.getNumItens(); i++) {
            itemEncontrado = noProx.getItens()[i];
            int comp = itemEncontrado.compareTo(itemBuscado.getChave());
            if (comp == 0) {
                itemEncontrado = noProx.getItens()[i];
                return itemEncontrado;
            }
            else if (comp > 0 && noProx.ContemFilhos()){
                // obs pra mim: se uma chave for maior que a comparada, o próximo nó da busca deve conter as chaves que ficam entre 
                // a chave anterior (a que foi comparada e nao caiu no if > 0) e a chave maior que a da busca
                return buscar(noProx.getFilhos()[i], itemBuscado); 
            }
        }
        if (noProx.ContemFilhos()) {
            return buscar(noProx.getFilhos()[noProx.getNumItens()], itemBuscado);
        }
        return itemBuscado; // pro insert e remove saberem onde fazer suas ações
    }

    // pra buscar o nó pra inserir e remover
    public NoB buscarNo(NoB noProx, Item itemBuscado){
        Item itemEncontrado;
        for (int i = 0; i < noProx.getNumItens(); i++) {
            itemEncontrado = noProx.getItens()[i];
            int comp = itemEncontrado.compareTo(itemBuscado.getChave());
            if (comp == 0) {
                itemEncontrado = noProx.getItens()[i];
                return noProx;
            }
            else if (comp > 0 && noProx.ContemFilhos()){
                return buscarNo(noProx.getFilhos()[i], itemBuscado); 
            }
        }
        if (noProx.ContemFilhos()) {
            return buscarNo(noProx.getFilhos()[noProx.getNumItens()], itemBuscado);
        }
        return noProx; 
    }


    public void inserir(Item item, NoB no) throws Exception{
        NoB encontrado = buscarNo(no, item);

        // indice pra fazer o deslocamento
        int indice = encontrado.getNumItens() - 1;
        while (indice >= 0) {
            Item itemEncontrado = encontrado.getItens()[indice];
            int comp = encontrado.getItens()[indice].compareTo(item.getChave());

            if (comp == 0) {
                throw new Exception("Item já existente");
            }

            else if (comp > 0) {
                encontrado.getItens()[indice + 1] = itemEncontrado;
                indice--;
            }
        }

        int posInserir = indice + 1;
        encontrado.getItens()[posInserir] = item;
        encontrado.setNumItens(encontrado.getNumItens() + 1);

        if (encontrado.getNumItens() > (2*this.ordem - 1)) {
            balancear(encontrado);
        }
    }

    private void balancear(NoB no) {
        if (no.getNumItens() > (2*this.ordem - 1)) {
            balancear(no);
        }
    }
}