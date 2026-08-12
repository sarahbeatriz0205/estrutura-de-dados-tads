# Fila de prioridade
**É uma TAD onde os elementos são organizados e processados com base na sua importância ou urgência, e não simplesmente pela ordem de chegada**
- Uma fila de prioridade armazena coleções de itens
- Um item é um par **(chave, elemento)**
- Quem possui a menor chave, possui maior prioridade de saída
- Chaves crescentes

## Métodos
- **insert(k, o):** Insere um item com chave k e elemento o
- **removeMin():** Remove e retorna o item com a menor chave (prioridade)
- **min():** Retorna, mas não remove, o item com a menor chave
- **size(), isEmpty()**

# Item
**Um item em uma fila de prioridade é simplesmente um par chave-valor**
~~~java
public interface Entry {
  public Object key();
  public Object value();
}
~~~

## Métodos:
- **key():** retorna a chave do item
- **value():** retorna o valor associado com o item

# Comparador
**É um componente externo responsável por ditar a relação de ordem (menor, igual ou maior) entre dois objetos**

## Como funciona
**O comparador não modifica as chaves originais; ele opera de forma externa a elas.**
- O método **compare(x, y)** avalia os objetos **x** e **y** e retorna um valor numérico inteiro:
  - Retorna <0 (negativo): quando x < y
  - Retorna 0 (zero): quando x = y
  - Retorna > 0 (positivo): quando x > y

> [!IMPORTANT]
> Para árvores onde eu mudo o que eu armazeno, deve-se criar um comparador para cada uma dessas mudanças

## Exemplos de comparador
~~~java
/** Classe que representa pontos em um
plano com coordenadas inteiras */

public class Point2D {
    protected int xc, yc; // coordenadas
    public Point2D(int x, int y) {
        xc = x;
        yc = y;
    }

    public int getX() {
        return xc;
    }

    public int getY() {
        return yc;
    }
}
~~~
~~~java
/** Compara pontos 2D sobre o padrão de ordem lexicográfica */

public class Lexicographic implements Comparator {
    int xa, ya, xb, yb;
    public int compare(Object a, Object b) throws ClassCastException {
        xa = ((Point2D) a).getX();
        ya = ((Point2D) a).getY();
        xb = ((Point2D) b).getX();
        yb = ((Point2D) b).getY();
        if (xa != xb)
          return (xb - xa);
        else
          return (yb - ya);
        }
}
~~~

## Ordenação com fila de prioridade
**Podemos usar uma fila de prioridade para ordenar um conjunto de elementos comparáveis**
1. Insira os elementos, um por um, através da operação insert(e, e)
2. Remova os elementos ordenados com uma série de operações
3. removeMin()

~~~
Algoritmo PQ-Sort(S, C) -> O(n)
    Entrada Sequencia S, Comparador
    C para os elementos de S

    Saída Sequencia S ordenada
    crescentemente de acordo com C

    P ← Fila de prioridade com
    comparador C

    enquanto ¬S.isEmpty ()
        e ← S.remove (S. first ())
        P.insert(e, e)

    enquanto ¬P.isEmpty()
        e ← P.removeMin().key()
        S.insertLast(e)
~~~
