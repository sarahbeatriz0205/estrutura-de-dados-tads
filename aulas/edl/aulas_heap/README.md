# Heap
- **Um heap é uma árvore binária armazenando chaves nos nós e satisfazendo as seguintes propriedades**
- **É uma árvore binária, mas não é de pesquisa**
- **A raiz sempre vai ser o menor elemento**
- **As chaves dos pais sempre são menores que as chaves dos filhos**
- **Ou a árvore deve estar totalmente preenchida ou o preenchimento vai ser da esquerda para a direita**

## Heaps mínimos e máximos
- **Min-heap: A chave do pai sempre é menor que a dos filhos**
- **Max-heap: A chave do pai sempre é maior que a dos filhos**

## Altura de um heap
- **Altura é logarítmica (O(log n))**
- **Teorema: Um heap armazenando n chaves tem altura O(log n)**
- **Prova: (Aplicamos a propriedade da árvore binária completa)**
    - Seja h a altura de um heap com n chaves
    -  Como existem 2**i chaves na profundiadde i=0,..., h-1 e pelo menos uma chave na profundidade h, temos que n >= 1 + 2 + 4 + ... + 2h-1 + 1
- Dessa forma, n >= 2**h, i.e., h <= log n
<img width="642" height="198" alt="image" src="https://github.com/user-attachments/assets/3cad7565-0f8c-4b3f-a913-6b5b0d7770a0" />

## Inserção
- **Pode-se inserir apenas da esquerda para a direita no último nível**
<img width="376" height="359" alt="image" src="https://github.com/user-attachments/assets/df594223-596a-4682-8048-b9da69f97684" />

### Algoritmo Upheap
- **Porém o 1 inserido acima é menor que seu pai, o que quebra a lógica de Heap, então deve-se chamar o algoritmo para fazer a troca**
- **Esse algoritmo será executado até que a raiz seja o menor valor do heap**
<img width="702" height="195" alt="image" src="https://github.com/user-attachments/assets/a00d5fb9-061f-4535-9181-0730eaaca84e" />

## Remoção
- **Ao retirar a raiz deve-se substituí-la pelo último nó da direita pra a esquerda**
<img width="293" height="400" alt="image" src="https://github.com/user-attachments/assets/e98b4100-84e0-4e1a-a10a-93b187cda650" />

### Algoritmo Downheap
- **Porém, a raiz não pode ser maior que os seus filhos, então o menor filho da raiz toma seu lugar**
<img width="660" height="184" alt="image" src="https://github.com/user-attachments/assets/ab9528d3-2b28-4c35-bb8d-6849c1adba74" />
