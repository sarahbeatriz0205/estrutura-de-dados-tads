package exercicios.implementacoes_java.trabalho_grafos.matriz_de_adjacencia;
import java.util.Vector;

public class Grafo {  
    private Vector<Aresta>[][] matriz_adjancencia; // vai guardar as arestas
    private Vector<Vertice> vertices;
    private int numVertices;

    private Vector<Aresta>[][] inicializarMatriz(int numVertices) {
        Vector<Aresta>[][] grafoInicializado = new Vector[numVertices][numVertices];
        for (int i=0; i < numVertices; i++) {
            for (int j=0; j < numVertices; j++) {
                grafoInicializado[i][j] = new Vector<Aresta>();
            }
        }
        return grafoInicializado;
    }

    public Grafo(Vertice verticeInicializador) {
        this.numVertices = 1; // inicia com 1 pq na inicialização, já haverá 1 vértice
        this.matriz_adjancencia = inicializarMatriz(this.numVertices);
        this.vertices = new Vector<Vertice>(); this.vertices.add(verticeInicializador);
    }

    // Aresta, independente de grafo simples ou paralelo, possui os vértices que ela liga.
    // Passo uma aresta e ele me retorna um array com os dois vértices que fazem parte dessa aresta 
    public Vertice[] finalVertices(Aresta aresta) {
        Vertice[] verticesPertencentes = new Vertice[2];
        verticesPertencentes[0] = aresta.getVerticeOrigem();
        verticesPertencentes[1] = aresta.getVerticeDestino();

        return verticesPertencentes;
    }

    // Passo um vértice e uma aresta e ele me passa o vértice oposto
    public Vertice oposto(Vertice vertice, Aresta aresta) throws Exception{
        Vertice[] vertices = finalVertices(aresta);
        if (vertices == null) {
            throw new Exception("Essa aresta não existe no grafo");
        }
        if (vertices[0] == vertice) {
            return vertices[1];
        }
        return vertices[0];
    }

    public boolean ehAdjacente(Vertice vertice1, Vertice vertice2) {
        Vector<Aresta> arestas = new Vector<Aresta>();
        // id tá sendo sempre numVertices - 1, então sempre vai ser um índice diferente
        arestas = this.matriz_adjancencia[vertice1.getId()][vertice2.getId()];
        if (arestas != null) {
            return true;
        }
        return false;
    } 

    public void substituirElementoVertice(Vertice vertice, Object elemento) {
        vertice.substituirElemento(elemento);
    }

    public void substituirElementoAresta(Aresta aresta, int elemento) {
        aresta.substituirElemento(elemento);
    }

    public void inserirVertice(Object elemento) {
        // faz o trabalho de add o vértice no grafo, pra dizer que ele existe ("eu existo porra")
        Vertice novoVertice = new Vertice(elemento, this.numVertices);
        this.vertices.add(novoVertice);

        // faz o trabalho de redimensionar a matriz pra abrir espaço pro novo vértice
        // "que coisa horrível, coitado do pc que processa esse lixo"
        int novoTamanho = ++this.numVertices;
        Vector<Aresta>[][] novaMatriz = new Vector[novoTamanho][novoTamanho];
        for (int i=0; i < novoTamanho - 1; i++) {
            for (int j=0; j < novoTamanho; j++) {
                novaMatriz[i][j] = this.matriz_adjancencia[i][j];
            }
        }

        for (int k=0; k < novoTamanho; k++) {
            novaMatriz[k][novoTamanho - 1] = new Vector<Aresta>();
            novaMatriz[novoTamanho - 1][k] = new Vector<Aresta>();
        }

        this.matriz_adjancencia = novaMatriz;
        this.numVertices = novoTamanho;
    }

    public void inserirAresta(Vertice vertice1, Vertice vertice2, int elemento) {
        Aresta aresta = new Aresta(elemento, vertice1, vertice2, false);
        this.matriz_adjancencia[vertice1.getId()][vertice2.getId()].add(aresta);
    }

    public void removeVertice(Vertice vertice) {
        this.vertices.remove(vertice); // primeiro remove da lista geral

        int novoTamanho = --this.numVertices;
        Vector<Aresta>[][] novaMatriz = new Vector[novoTamanho][novoTamanho];
        for (int i=0; i < novoTamanho - 1; i++) {
            for (int j=0; j < novoTamanho; j++) {
                if (i != vertice.getId() && j != vertice.getId()) {
                    novaMatriz[i][j] = this.matriz_adjancencia[i][j];
                }
                // oq acontece se for igual?
            }
        }
    }
}