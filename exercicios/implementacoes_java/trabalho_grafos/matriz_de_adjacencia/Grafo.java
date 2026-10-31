package exercicios.implementacoes_java.trabalho_grafos.matriz_de_adjacencia;
import java.util.Vector;

public class Grafo {  
    private Vector<Aresta>[][] matriz_adjancencia; // vai guardar os vetores com objs Aresta
    private Vector<Vertice> vertices;
    private Vector<Aresta> arestas;
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
        this.arestas = new Vector<Aresta>();
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
        arestas = this.matriz_adjancencia[vertice1.getId()][vertice2.getId()];
        if (arestas.size() != 0) {
            for (int i=0; i < arestas.size(); i++) {
                // se for direcionada, a ordem a qual os parametros foram inseridos vai importar
                if (arestas.get(i).getFlagDirecionada() && arestas.get(i).getVerticeOrigem() == vertice1) {
                    return true;
                }
            }
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
        // faz o trabalho de add o vértice no grafo, pra dizer que ele existe 
        Vertice novoVertice = new Vertice(elemento, this.numVertices+1);
        this.vertices.add(novoVertice);

        // faz o trabalho de redimensionar a matriz pra abrir espaço pro novo vértice
        int novoTamanho = this.numVertices+1;
        Vector<Aresta>[][] novaMatriz = new Vector[novoTamanho][novoTamanho];
        for (int i=0; i < this.numVertices; i++) {
            for (int j=0; j < this.numVertices; j++) {
                if (this.matriz_adjancencia[i][j] == null) {
                    
                } else {
                    novaMatriz[i][j] = new Vector<Aresta>();
                }
            }
        }

        for (int k=0; k < novoTamanho; k++) {
            novaMatriz[k][novoTamanho - 1] = new Vector<Aresta>();
            novaMatriz[novoTamanho - 1][k] = new Vector<Aresta>();
        }

        this.matriz_adjancencia = novaMatriz;
        this.numVertices = novoTamanho;
    }

    public void inserirAresta(Vertice vertice1, Vertice vertice2, int elemento, boolean ehDirecionada) {
        Aresta aresta = new Aresta(elemento, vertice1, vertice2, ehDirecionada);
        this.arestas.add(aresta);
        if (ehDirecionada) {
            this.matriz_adjancencia[vertice1.getId()][vertice2.getId()].add(aresta);
            return;
        }
        this.matriz_adjancencia[vertice1.getId()][vertice2.getId()].add(aresta);
        this.matriz_adjancencia[vertice2.getId()][vertice1.getId()].add(aresta);
        return;  
    }

    public void removeVertice(Vertice vertice) {
        // quando um vértice é removido, suas arestas somem. eu tinha esquecido disso
        Vector<Aresta> arestasParaRemover = new Vector<>();
        for (Aresta a : this.arestas) {
            if (a.getVerticeOrigem() == vertice || a.getVerticeDestino() == vertice) {
                arestasParaRemover.add(a);
            }
        }
        for (Aresta a : arestasParaRemover) {
            removeAresta(a); 
        }

        this.vertices.remove(vertice); // primeiro remove da lista geral

        int novoTamanho = this.numVertices-1;
        Vector<Aresta>[][] novaMatriz = new Vector[novoTamanho][novoTamanho];
        for (int i=0; i < novoTamanho; i++) {
            for (int j=0; j < novoTamanho; j++) {
                int novoI = (i >= vertice.getId()) ? i + 1 : i;
                int novoJ = (j >= vertice.getId()) ? j + 1 : j;
                novaMatriz[i][j] = this.matriz_adjancencia[novoI][novoJ]; 
            }
        }

        for (int k=0; k < novoTamanho; k++) {
            this.vertices.get(k).setId(k);
        }
        
        this.matriz_adjancencia = novaMatriz;
        this.numVertices = novoTamanho;
    }

    public void removeAresta(Aresta aresta) {
        this.arestas.remove(aresta);

        Vector<Aresta> arestasTotais1 = new Vector<Aresta>();
        if (aresta.getFlagDirecionada()) {
           arestasTotais1 = this.matriz_adjancencia[aresta.getVerticeOrigem().getId()][aresta.getVerticeDestino().getId()];
           for (int i=0; i < arestasTotais1.size(); i++) {
                if (arestasTotais1.get(i) == aresta) {
                    arestasTotais1.remove(aresta);
                    break;
                }
           } 
        }
        else {
            arestasTotais1 = this.matriz_adjancencia[aresta.getVerticeOrigem().getId()][aresta.getVerticeDestino().getId()];
            Vector<Aresta> arestasTotais2 = this.matriz_adjancencia[aresta.getVerticeDestino().getId()][aresta.getVerticeOrigem().getId()];

            for (int i=0; i < arestasTotais1.size(); i++) {
                if (arestasTotais1.get(i) == aresta) {
                    arestasTotais1.remove(i);
                    break;
                }
            }

            for (int j=0; j < arestasTotais2.size(); j++) {
                if (arestasTotais2.get(j) == aresta) {
                    arestasTotais2.remove(j);
                    break;
                }
            } 
        }
    }

    public Vector<Vector<Aresta>> arestasIncidentes(Vertice vertice) {
        Vector<Vector<Aresta>> incidentes = new Vector<Vector<Aresta>>();
        for (int i=0; i < this.numVertices; i++) {
            incidentes.add(this.matriz_adjancencia[vertice.getId()][i]);
        }
        return incidentes;
    }

    public Vector<Vertice> vertices() {
        return this.vertices;
    }

    public Vector<Aresta> arestas() {
        return this.arestas;
    }

    public boolean ehDirecionada(Aresta aresta) {
        if (aresta.getFlagDirecionada()) {
            return true;
        }
        return false;
    }

    public void printMatriz() {
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print("[ ");
                Vector<Aresta> arestas = this.matriz_adjancencia[i][j];
                if (arestas != null && arestas.size() > 0) {
                    for (int k=0; k < arestas.size(); k++){
                        System.out.print(arestas.get(k).getValor());
                        if (k < arestas.size() - 1) {
                            System.out.print(" "); 
                        }
                    }    
                }
                else {
                    System.out.print(" ");
                }  
                System.out.print(" ]"); 
            }
            System.out.println();   
        }
    }         
}