# Skiplists
- **É um tipo de dicionário**
- **Composto por várias listas**
- **Substituto para lista encadeada**
- **Um sorteio aleatório determina a ação que será executada**
- **É uma estrutura de dados não determinante**
- **Contém chaves em ordem não-decrescente (pode-se repetir chaves)**
- **Por padrão, a última lista Sn é vazia**

<img width="701" height="180" alt="image" src="https://github.com/user-attachments/assets/50d394c8-8b2b-4e9a-8ce0-a8f0c4f9edd6" />

- **Lista S0: guarda todas as chaves**
- **Lista S1: guarda a metade da quantidade total de todas as chaves**
- **Lista S2: guarda a metade da quantidade presentes em S1**

**[e assim vai...]**

- **Como S3 é a última lista, ela fica vazia**


## Implementação
- **Pode-se implementar a skiplist com um quad-nodes**
- **Um quad-node armazena:**
  - item
  - link para o nó anterior
  - link para o nó posterior
  - link para o nó abaixo
  - link para o nó acima
    
- **Também, define-se chaves especiais para ```MAIS_INF``` e ```MENOS_INF``` (nó sentinela), e deve-se realizar as modificações necessárias no comparator**

## Busca
- **Por padrão, começamos sempre do canto superior esquerdo do skiplist**

<img width="709" height="225" alt="image" src="https://github.com/user-attachments/assets/c4394c55-dad5-41e9-8bfc-89234e3e2757" />

- **Haverá um ponteiro apontando para o ```MAIS_INF```, que é onde a gente começa**
- **O ponteiro captura a próxima chave e compara com meu X**
- **Se meu X = 78 for menor que a próxima chave, ele vai para baixo e compara com o próximo**
- **Se for maior, vai para a esquerda e pega o próximo**
- **Se o final inferior da lista for atingido, retornamos NO_SUCH_KEY**

## Algoritmos randômicos
**Um algoritmo randômico faz uso de um fator aleatório para controlar sua execução. Ele contém um código do tipo:**
```
b <- random()
if b = 0
  do A ...
else { b = 1}
  do B ...
```
- **A probabilidade de cair 0 várias vezes e o skiplist ficar grande demais vai diminuindo com o passar das execuções**

## Inserção
- **Repetidamente faz-se o sorteio (0 ou 1) enquanto for zero soma i mais 1 (i denota o número de vezes que o zero foi sorteado)**
  - **Se i > h, adicionar ao the skip uma nova lista Sh+1, ... , Si +1, contendo somente as duas chaves especiais**
  - Procurar por x no skip list e encontrar a posição p0, p1 , ..., pi dos itens com a maior chave menor do que x em cada list S0, S1, ... , Si
- **Para j <- 0, ..., i, insira o item (x, o) na lista Sj após a posição pj**
