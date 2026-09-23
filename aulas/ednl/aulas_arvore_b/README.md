# Árvores B
- **Um único nó pode ter várias chaves**
- **Essa quantidade reflete o dispositivo físico utilizado**
- **Garante que todas as folhas estão no mesmo nível (Altura = log n)**
- **Definição:** A ordem (t) da árvore B diz o mínimo e o máximo (dobro) de filhos e chaves que um nó pode ter
- **Os nós são ordenados**

  - **É uma árvore vazia ou que satisfaça as seguintes condições:**
    - A raiz é uma folha ou tem no mínimo dois filhos;
    - Cada nó diferente do raiz e das folhas possui no mínimo t (ordem) filhos;
    - Cada nó tem no máximo 2t (o dobro) filhos. Raiz também obedece essa regra e não existe exceção para ela;
    - Todas as folhas estão no mesmo nível

## Consequência das regras
- Cada nó (página) possui entre t-1 e 2t-1 chaves, exceto o raiz que possui entre 1 e 2t-1 chaves

## Estrutura do `NoB.java` e `ArvoreB.java`
~~~java
public class NoB {
  private Object[] chaves; // Array de chaves
  private int t; // Grau ou Ordem
  private NoB[] filhos; // Array de filhos
  private int numChaves; // Número atual de chaves
  public NoB(int t) {
    this.t = t; // Grau ou Ordem
    this.chaves = new Object[2 * t - 1]; //2t – 1 chaves
    this.filhos = new NoB[2 * t]; //2t filhos
    this.numChaves = 0; // Inicialmente sem chaves
  }  
}

public class ArvoreB {
  private NoB raiz;
  private final int t; // Grau mínimo
  public ArvoreB(int t) {
    this.t = t;
    raiz = new NoB(t);
  }
}
~~~

<img width="484" height="146" alt="image" src="https://github.com/user-attachments/assets/1d3cc8e5-d52a-41b6-b206-0f7aa0a9e9b1" />

- **As bolinhas são os ponteiros que referenciam os filhos. Nesse caso, o local onde eles estão reflete se as chaves do filho que estão apontando são menores ou maiores que a chave que vem depois desse ponteiro**
- **Parecido com a árvore de pesquisa, os filhos maiores estão a direita e os filhos menores estão a esquerda**

## Busca
- **Começa da raiz e vou comparando o valor que quer ser achado com as chaves de um determinado nó, com busca binária, e com essa comparação, decido qual o próximo nó que eu vou verificar e continuo até achar**

## Inserção
- **Chamo a busca**
- **Se um lugar for achado, pode acontecer de estourar a quantidade máxima de chaves no nó. Se acontecer, dividimos o nó no meio e ele se torna dois nós**
  -  **Uma das chaves vai ter que subir para o pai, e se estourar também, subimos recursivamente até existir um nó que não estoura e se for preciso, divide de novo**

> [!IMPORTANT]
> **Quando o raiz já tá cheio (sem estourar), dividimos ele no meio**

## Remoção
- **Caso 1:** Se a chave está num nó com chaves sobrando (está longe do mínimo), apenas remover
- **Caso 2:** Se a chave está num nó interno
  - **Caso 2a:** Verifico o antecessor e se no nó dele tiver chaves sobrando, ele toma o lugar da chave. Tem que sempre verificar se o nó não vai ficar muito pequeno
  - **Se o caso 2a falhar e o nó ficar muito pequeno:** Verifico o sucessor e se no nó dele tiver chaves sobrando, ele toma o lugar da chave
  - **Se falhar novamente:** Se os filhos esquerdo e direito estiverem no mínimo, faço uma fusão e junto os dois
- **Caso 3:** Se a chave está num nó externo e esse nó está no limite, olho pro irmão da esquerda e se ele tiver chaves suficientes, puxo o antecessor para o nó pai e uma das chaves do nó pai descem para ocupar o lugar da chave removida
