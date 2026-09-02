# Árvore Rubro Negra
- **É uma árvore binária de pesquisa balanceada**
- **Cada nó estará associado a uma cor (rubro ou negra)**
- **Uma árvore é rubro-negra quando as seguintes condições são satisfeitas:**
  - Se v é nó externo , é negro
  - O nó raiz sempre é negro
  - Se o nó é rubro, então ambos os filhos são negros
  - Os caminhos de v para seus nós descendentes externos possuem idêntico número de nós negros
    - Se você contar quantos nós pretos existem do nó \(v\) até qualquer folha (nó externo/NIL) abaixo dele, o número será sempre o mesmo, não importa qual caminho você siga. 
- **Existe a possibilidade de existir uma árvore totalmente negra, mas nunca uma árvore totalmente rubro**
- **Altura negra: quantidade de nós negros que eu passo para chegar em um nó folha**

## Inserção
- **Ao inserir um nó v numa posição vazia da árvore (nó nulo) este é pintado de rubro.**
- **Pintando o nó de rubro o critério IV é preservado, já que um nó rubro não contribui para a altura negra da árvore**

## Casos de Inserção
### Caso 1
Se w, o pai de v, é negro, nada mais precisa ser feito já que o critério IV foi mantido

<img width="507" height="197" alt="image" src="https://github.com/user-attachments/assets/99700eca-5c2e-4e76-9c82-90785ecc3325" />

### Caso 2
Suponha w(pai de v) rubro e t, o pai de w(avó de v) é negro. Se u, o irmão de w (tio de v) é rubro, ainda é possível manter o critério IV apenas fazendo a recoloração de **t(Rubro),u(Negro) e w(Negro)**

Em outras palavras, se for detectado um **duplo rubro**, olha-se para o tio. Se for rubro, muda-se a cor para o seguinte: tio = negro / irmão do tio = negro / pai dos dois = rubro
Se o pai for raiz, não se muda a cor e permanece negro

<img width="660" height="246" alt="image" src="https://github.com/user-attachments/assets/2b23e6c6-2272-401b-a075-6c1e37e3639a" />

### Caso 3
Se o tio for negro, realiza-se uma das rotações. Sobre a recoloração, ocorre o inverso do caso 2: os filhos ficam rubros e o pai vira negro

**Configuração final em todas as versões do caso 3:**

<img width="272" height="228" alt="image" src="https://github.com/user-attachments/assets/93111071-0b2f-434a-86c9-00398fef95c3" />

> [!IMPORTANT]
> OBS: para saber qual rotação fazer: se toda a sub-árvore estiver em apenas um lado, a rotação é simples (lado direito: rotação simples esquerda / lado esquerdo: rotação simples direita)
