# Métodos de ordenação
## Bubble Sort
- **Considere uma sequência de n elementos que se deseja ordenar. O método da bolha resolve esse problema através de várias passagens sobre a sequência**
- **Eficiência: O(n²)**
```
Algorithm bubbleSort(A)
    Input array A com n elementos
    Output array A ordenado
    for i=0 até n-2
        for j=0 até n-2-i
          if (A[j] > A[j+1] )
            aux <- A[j]
            A[j] <- A[j+1]
            A[j+1] <- aux
```
### Funcionamento:
- **Na primeira passagem, uma vez encontrado o maior elemento, este terá sua colocação trocada até atingir a última posição**
- **Na segunda passagem, uma vez encontrado o segundo maior elemento, este terá sua colocação trocada até atingir a penúltima posição**
- **E assim por diante**

## Select Sort
- **O método de ordenação por Seleção Direta é levemente mais eficiente que o método Bubblesort**
- **Eficiência: O(n²)**
```
Algorithm selectSort(A)
    Input array A com n elementos
    Output array A ordenado
    for i=0 até n-2
        for j=i+1 até n-1
            if (A[j] < A[i] )
              aux <- A[j]
              A[j] <- A[i]
              A[i] <- aux
```

## Insert Sort
- O método de ordenação por Inserção Direta é o mais rápido entre os outros métodos considerados básicos (Bubblesort e Seleção Direta)
- A principal característica deste método consiste em ordenarmos nosso arranjo utilizando um sub-arranjo ordenado localizado em seu inicio.
- A cada novo passo, acrescentamos a este sub-
arranjo mais um elemento, até

que atingimos o último
elemento do arranjo fazendo
assim com que ele se torne
ordenado

## Heap Sort
