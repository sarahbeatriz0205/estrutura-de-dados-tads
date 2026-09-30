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
- **Grafo bipartido: Os vértices de um conjunto possui ligação com todos os vértices de outro conjunto, mas não entre si**
- **Grafo rotulado: Rotula vértices**
- **Grafo valorado: Rotula arestas com valores**
- **Subgrafo: Grafo contido em um grafo maior. Para ser subgrafo, tem que ser possível tirar um vértice**
- **Grafo isomorfo: Deve ser possível manter as ligações (adjacências) entre as mesmas arestas mesmo que a forma seja mudada**
<img width="662" height="201" alt="image" src="https://github.com/user-attachments/assets/b78cc5fa-9d0d-4d31-a2e8-4816a564b7c5" />

- **Grafo regular: Todos os graus de todos os vértices são iguais**
- **Clique: É um subgrafo completo**
  
    <img width="402" height="169" alt="image" src="https://github.com/user-attachments/assets/9cc75938-1ddd-4bcc-9005-97e7643017f2" />
    
  - **Na imagem, se eu retirar os vértices 5 e 1, resultará em um subgrafo que possui ligações entre todos (completo)**

- **Conjunto independente de vértices: Vértices que não possuem ligações entre si**
- **Grafo complementar: Arestas que faltam para um grafo ser completo. Possui a mesma quantidade de vértices, mas criam apenas as ligações que faltam para outro grafo ser completo**
- **Grafo parcial: Remove arestas, mas não remove vértices**
