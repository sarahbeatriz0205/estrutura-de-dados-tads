# TAD Dicionário
**O TAD dicionário modela uma coleção “buscável” de itens chave-elemento**

## Métodos do TAD dicionário:
- **findElement(k)**: se o dicionário tem um item com chave k, retorna o elemento, senão, retorna **NO_SUCH_KEY**
- **insertItem(k, o)**: insere um item no dicionário
- **removeElement(k)**: Se existe um item com chave k, remove e retorna, senão, retorna **NO_SUCH_KEY**
- **size(), isEmpty()**
- **keys(), Elements()**

## Arquivo de LOG
- **É um arquivo de texto onde se isnere novos elementos apenas ao final**
- **Um arquivo de log é um dicionário implementado como um sequência não ordenada**
- **insertItem roda em O(1), mas os outros métodos são O(n)**

## Busca binária
**Busca binária realiza a operação findElement(k) em um dicionário implementado com uma sequencia baseada em array, ordenada pela chave**

> [!TIP]
> O dicionário deve estar ordenado!

~~~
Algoritmo BuscaBinária(A,k,min,max)
    m <- (max+min)/2
    c <- A[m]
    se min>max
        retorne NO_SUCH_KEY
    senão se c.getKey()= k
        retorne c.getElement()
    senão se(k < c.getKey()
        BuscaBinaria(A,k, min, m-1)
    senão se(k>c.getKey())
        BuscaBinaria(A,k, m +1,max)
    retorne NO_SUCH_KEY
~~~

<img width="669" height="219" alt="image" src="https://github.com/user-attachments/assets/c5b32190-304b-48f6-99d6-3256531855f5" />

## Tabela de pesquisa
- **Uma tabela de pesquisa é um dicionário implementado através de uma estrutura ordenada**
- **Ineficiente**

## Tabelas Hash
**Uma tabela de dispersão para um dado tipo de chave consiste de:**
- **função de dispersão h**: ```elemento % N```
- **arranjo (chamado tabela) de tamanho N**

### Problema: Colisão
Uma colisão ocorre quando duas chaves no dicionário têm o mesmo valor de dispersão
**Esquemas de tratamento de colisões:**
- **encadeiamento**: itens que colidem são armazenados numa sequência encadeada (lista duplamente encadeada)
- **endereçamento**: o item que colide é colocado em um lugar diferente na tabela
  - **endereçamento aberto:** verifica se existe vaga ao lado. O find() funciona da mesma maneira, ele percorre e verifica que o número passado é igual a o número encontrado

### Códigos de dispersão
- **Acumulação polinomial:**
    - Particiona-se os bits da chave em uma sequencia de componentes de tamanho fixo
    - Leva em consideração a ordem em que os caracteres estão nas chaves
    - Plenamente adaptável a String
      > ex: chaves ABC e CBA

### Mapa de compressão
#### Divisão
<img width="195" height="33" alt="image" src="https://github.com/user-attachments/assets/333decbe-5da5-4bb2-a03d-5728d71e5ad0" />

- **O tamanho de N da tabela de dispersão é geralmente um número primo**

#### Multiplicação, Adição e Divisão (MAD)
<img width="263" height="37" alt="image" src="https://github.com/user-attachments/assets/4a489631-ee81-407e-aae4-c98b0530e3d8" />

- **a e b são inteiros não negativos tais que *a mod N != 0***
- **Se for igual a zero, a colisão será garantida, pois ele vai mapear sempre no mesmo lugar**

#### Linear Probing
- **Trata colisões colocando o item que colide na próxima (circular) célula disponível**
- **Utilizado array circular**

<img width="182" height="39" alt="image" src="https://github.com/user-attachments/assets/fa633c19-6cdc-44df-b110-1383d8823307" />

> Sempre usar o resto da divisão por 13. O resto vai apontar o índice onde eu vou inserir a chave

> Se der colisão, verificar se o índice ao lado está vazio. Se estiver, inserir nele. Senão, continuar a verificar até achar um vago 

> Para encontrar uma chave específica, pegar o resto da divisão da chave por 13. Se o elemento encontrado não for o que foi passado, verifica o do lado e continua até achar

> Caso na busca for encontrado um espaço vazio antes da chave ser encontrada, inserir um objeto no lugar vazio para indicar que ele está disponível para inserção de outras chaves (se houve um elemento removido dele)

~~~
Algoritmo findElement(k)
    i <- h(k)
    p <- 0
    repita
        c <- A[i]
        se c = []
            retorne NO_SUCH_KEY
        senão se c.key () = k
            retorne c.element()
        senão
            i <- (i + 1) mod N
            p <- p + 1
    até p = N
    retorne NO_SUCH_KEY
~~~

### Remoção
**removeElement(k)**
- **Procura-se por um item com chave k**
- **Se o item é encontrado, substitue ele com o objeto especial AVAILABLE e retorna-se o elemento O**
- **Senão, retorna-se NO_SUCH_KEY**

### Inserção
**insert Item(k, o)**
- **Uma exceção é disparada se a tabela está cheia**
- **Começa-se na célula h(k)**
- **Procura-se em consecutivas células até que o seguinte ocorra:**
    - **Uma célula i é encontrada e está vazia ou armazena AVAILABLE, ou**
    - **N células tenham sido verificadas**
- **Armazena-se o item na célula i**

## Hashing Duplo
- **Se der colisão na função principal, tentar uma função secundária**
- **A função secundária basicamente define a quantidade de pulos que vão ser dados se der colisão**

#### Exemplo
<img width="712" height="501" alt="image" src="https://github.com/user-attachments/assets/be982908-cbcb-4a68-802e-6aa167d2cd0d" />

> No exemplo acima, foram escolhidos de livre e espontânea vontade os números 7 e 13 para as funções primárias e secundárias. Obrigatoriamente os números devem ser primos para garantir que todos os espaços serão visitados

> Se a função secundária também falhar, somar o resultado dado com ele mesmo. Vai ser a quantidade de pulos

### Estratégia de incremento
**Dobra o tamanho do array (primo) e encontra o maior valor primo mais próximo desse dobro**

### Fator de carga
```a = quantidade de elementos no hash / tamanho total```
- **Me retorna a taxa de ocupação do array**
- **Se passar de 50, dobrar o tamanho**

```1 / (1 - a)```
- **Número de probes**
