# Grafos
- **Definido por dois conjuntos: um de vértices e outro de arestas**
- **Conjunto de vértices (nós) não pode ser vazio**
- **Conjunto de arestas são pares ordenados que ligam dois vértices**
  - **Se um vértice deixar de existir, a aresta também deixará de existir**

<img width="742" height="242" alt="image" src="https://github.com/user-attachments/assets/1d2f6629-96d2-43d9-b926-74dc5946e7bd" />

- **Pontos indicam vértices**
- **Ligações são as arestas**
- **Situação hipotética: se Ana for removida, as arestas que ligam Ana à Maria e José deixam de existir**
- **As setas possuem direções: Luiz é amigo de José tal qual José é amigo de Luiz (exemplo)**

## Dígrafo (Grafo direcionado)
- **Grafo orientado**
- **Possui um sentido**

<img width="386" height="162" alt="image" src="https://github.com/user-attachments/assets/12de56ba-540c-4f02-974c-2c57f310ef05" />

## Grafo misto
- **Mistura entre grafos direcionados e não direcionados**
- **Exemplo:**
  - Os vértices são os cruzamentos
  - As arestas não direcionadas são as ruas de mão dupla
  - As arestas direcionadas são as ruas de mão única

- **Ordem: Número de vértices no grafo**
- **Adjacência: Dois vértices são adjacentes se houver ao menos uma ligação entre eles**
  - **O mesmo ocorre com duas arestas que incidem sobre o mesmo vértice**
- **Grau: Quantidade de arestas que batem em um vértice**

~~~java
public class Vertice {
    private int grau;
}
~~~

- **Quando é uma aresta direcionada, existe o grau de entrada e o grau de saída**
- **Nó isolado: Vértice que não tem aresta ligando ele a alguém (grau = 0)**
- **Laço: Aresta que começa no vértice e termina nele mesmo**
- **Arestas paralelas: Duas arestas que saem de um vértice (saída) apontam para o outro vértice (chegada), sendo, por exemplo, o caminho mais curto e o caminho mais longo**
- **Multigrafo: É o grafo que possui laços e/ou arestas paralelas, caso contrário é um Grafo Simples**
- **Grafo completo: Todos os vértices estão ligados entre si (K4: grafo completo de ordem 4)**
