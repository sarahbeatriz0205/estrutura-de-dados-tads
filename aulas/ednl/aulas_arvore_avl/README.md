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

> Se transformará em método na árvore

## Rotações
- Operação que altera o balanceamento de uma árvore, mantendo a sequência de percurso em ordem
- Modifica referências
- Quando uma árvore ou subárvore tem um fator de balanceamento FB=-2, deve-se fazer uma rotação a esquerda
- Quando uma árvore ou subárvore tem um fator de balanceamento FB=2, deve-se fazer uma rotação a direita

### Tipos de rotações
#### Esquerda Simples e Direita Simples
- O pai do nó desbalanceado vira pai do seu filho e o nó desbalanceado vira filho do seu filho

#### Esquerda Dupla
- Primeiro se faz uma rotação simples direita no filho do nó direito e depois faz uma rotação simples esquerda no nó originalmente desbalanceado
- Se o fator de balanceamento do nó desbalanceado for negativo e o do seu filho direito for positivo (diferentes), rotação dupla a esquerda
  
#### Direita Dupla
- Primeiro se faz uma rotação simples esquerda no filho do nó esquerdo e depois faz uma rotação simples direita no nó originalmente desbalanceado
- Se o fator de balanceamento do nó desbalanceado for negativo e o do seu filho esquerdo for positivo (diferentes), rotação dupla a direita

## Atualização do FB após as rotações
- Em uma rotação simples, se altera apenas dois FB, que é o nó originalmente desbalanceado e um dos seus filhos, onde para saber qual é deve-se observar:
> FB = -2 = FB do filho direito muda

> FB = 2 = FB do filho esquerdo muda

## Atualização do FB após as rotações
### Após a rotação Esquerda  
> FB_B_novo= FB_B + 1 - min(FB_A, 0);

> FB_A_novo= FB_A + 1 +max(FB_B_novo, 0);

### Após a rotação Direita 
> FB_B_novo= FB_B - 1 - max(FB_A, 0);

> FB_A_novo= FB_A - 1 + min(FB_B_novo, 0);

## Inserção
- Insere normalmente como em uma ABP e verifica se algum nó ficou desbalanceado (se tiver, chama o método ```rebalancear()```)