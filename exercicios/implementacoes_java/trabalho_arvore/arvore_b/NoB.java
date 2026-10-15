package arvore_b;

public class NoB {
  private Object[] chaves; 
  private int ordem;
  private NoB[] filhos; 
  private int numChaves; 
  
  public NoB(int ordem) {
    this.ordem = ordem; 
    this.chaves = new Object[2 * t - 1];
    this.filhos = new NoB[2 * t]; 
    this.numChaves = 0; 
  }  
}
