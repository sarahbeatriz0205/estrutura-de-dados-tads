package arvore_b;

public class NoB {
  private Item[] itens; // par chave-valor 
  private int ordem;
  private NoB[] filhos; 
  private int numItens; 
  private int numFilhos; 
  
  public NoB(int ordem) {
    this.ordem = ordem; 
    this.itens = new Item[2 * this.ordem - 1];
    this.filhos = new NoB[2 * this.ordem]; 
    this.numItens = 0; 
    this.numFilhos = 0;
  }  

  public boolean ContemFilhos() {
      if (numFilhos != 0) {
        return true; // indica que o nó tem outros nós pra comparar na busca
      }
      return false; // indica que já posso supor que ele é folha 
    }

  public int getOrdem() {
    return this.ordem;
  }

  public int getNumItens() {
    return this.numItens;
  }

  public NoB[] getFilhos() {
    return this.filhos;
  }

  public Item[] getItens() {
    return this.itens;
  }

  public void setNumItens(int novoNumItens) {
    this.numItens = novoNumItens;
  }
}
