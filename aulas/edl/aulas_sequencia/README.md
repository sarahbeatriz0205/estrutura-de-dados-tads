# Sequência
- O TAD Sequencia é a união de Vetor e Lista
- Elementos podem ser acessados por: colocação (rank) ou posição


## Métodos genéricos:
> size()

> isEmpty()


## Métodos de Vetor:
> elemAtRank(r) 

> replaceAtRank(r, o) 

> insertAtRank(r, o)

> removeAtRank(r)

## Métodos de Lista:
> first() 

> last(),

> before(n)

> after(n) 

> replaceElement(n, o) 

> swapElements(n, q)

> insertBefore(n, o)

> insertAfter(n, o)

> insertFirst(o) 

>insertLast(o) 

> remove(n)

## Métodos “ponte”
> **atRank(r):** Retorna a posição (nó) correspondente ao rank \(r\).
~~~java
public Nó AtRank (int rank) {
    Nó node;
    if (rank <= size()/2) {
        node = header.getNext();
        for(int i=0; i < rank; i++)
            node = node.getNext();
    }else{
        node = trailer.getPrev();
        for(int i=0; i < size()-rank-1 ; i++)
            node = node.getPrev();
    }
    return node;
}
~~~

> rankOf(n): Retorna o rank da posição \(n\).

