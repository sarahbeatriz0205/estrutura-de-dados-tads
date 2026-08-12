# Pilhas
## TAD (Tipos abstratos de dados)
- Abstração de uma estrutura de dados
- Uma TAD define **atributos, métodos e exceções**

## TAD Pilha
- Pilha: Segue o esquema **LIFO (Last In, First Out)**
- Armazena objetos **arbitrários** (eu que decido o que quero colocar na minha pilha)
- Exemplo de uso de pilha: recursividade, voltar uma página no browser

## Métodos da pilha
- **void push(elemento):** Recebe um elemento e insere ele no topo da pilha
```
Algoritmo push(o) // cria um novo array caso a pilha esteja cheia
  Se (t = S.length-1)
    então
    A ← novo array 
  para i ← 0 até t faça // O(n)
    A[i] ← S[i]
    S ← A
  t ← t + 1
  S[t] ← o


Algoritmo push(o) // lança uma exceção caso a pilha esteja cheia
  Se (t = S.length - 1) // se pilha tiver cheia, exceção. se t for igual ao tamanho do array
    throw EPilhaCheia
  senão
    t ← t + 1 // passa para o índice "vazio"
    S[t] ← o // insere o objeto nesse índice

```
- **elemento pop():** Remove o elemento do topo e retorna ele
```
Algoritmo pop()
  Se (estaVazia()) // exceção
    throw EPilhaVazia // lança exceção
  senão
    t ← t - 1 // atribui a variável anterior como atual
  retorne S[t + 1] // retorna o elemento "removido"
```
- **integer size():** Retorna o tamanho da pilha
```
Algoritmo size()
  retorne t + 1 // o último índice + 1
```
- **boolean isEmpty():** Indica se há ou não elementos na pilha
- **elemento top():** Retorna o elemento do topo (o último inserido) sem removê-lo

## Exceções
- Executar um pop() e/ou um top() em uma pilha vazia gera uma exceção
- Executar um push() em uma pilha cheia gera uma exceção

## Pilhas baseadas em arrays
- Declara-se uma variável **t** que será o **índice do elemento do topo (o último)**
<img width="823" height="123" alt="image" src="https://github.com/user-attachments/assets/2d2d3484-8889-4c3b-bbb3-f5a1caff26e9" />

- Inserção de elementos sempre feita da esquerda para a direita

## Desempenho e limitações
### Desempenho
- O(n)
- Cada operação é O(1)

### Limitações
- O tamanho máximo deve ser definido a priori e não pode ser mudado
- Tentando colocar um novo elemento numa pilha cheia causa uma exceção específica da implementação (array)

## Pilha crescente
### Estratégias de aumento de array
- **Incremental:** Aumenta o array com uma constante c
- **Duplicação:** Aumenta em nível exponencial (dobrando)
