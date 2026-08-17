# Árvores AVL
- **Árvore Balanceada:** Ocorre quando a árvore está cheia ou quase cheia, com o nível $n-1$ completamente preenchido.
- **Árvore AVL:** Um lado da árvore (ou sub-árvore da árvore, a partir de qualquer nó) só pode ser maior que o outro lado em uma unidade, ou seja, ter apenas um filho a mais que o outro lado.
  - *Exemplo:* lado esquerdo com altura 10 e lado direito com altura 11 ainda está balanceada. Passou disso já não é mais uma árvore balanceada
- Evita a degeneração da árvore
- São árvore binárias de pesquisa
- À medida que são realizadas inserções e remoções, a árvore se rebalanceia automaticamente caso haja violação da propriedade AVL.

## Fator de Balanceamento (FB)
- É dado pela altura da subárvores da esquerda menos a altura da subárvore da direita.
- Cada nó possui seu fator de balanceamento
- Nós balanceados são aqueles onde o fb é +1, -1 ou 0
- Nós desbalanceados são aqueles onde o fb é diferente de +1, -1 ou 0

## Estrutura da classe Nó (Java)

```java
public class NoArvore {
    private NoArvore filhoEsquerdo;
    private NoArvore filhoDireito;
    private NoArvore pai;
    private int elemento;
    private int fb; // Fator de balanceamento
}
```
- Se um elemento da direita for removido, soma-se + 1 ao fator de balanceamento do pai
- Se um elemento da esquerda for removido, subtrai - 1 ao fator de balanceamento do pai
- Se um elemento da direita for inserido, subtrai - 1 ao fator de balanceamento do pai
- Se um elemento da esquerda for inserido, soma-se + 1 ao fator de balanceamento do pai

## Atualização do FB dos antecessores
- Descobrir a altura para calcular o FB é O(n), o que não pode
- Se for uma inserção, deve-se verificar se o FB do antecessor for igual a 0 e se for verdadeiro, o recálculo para
- Se for uma remoção, deve-se verificar se o FB do antecessor é diferente de 0 e se for verdadeiro, o recálculo para
