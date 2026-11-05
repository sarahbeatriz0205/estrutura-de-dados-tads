package exercicios.implementacoes_java.trabalho_grafos.lista_de_adjacencia;
import java.util.Vector;

public class Grafo {
    private int numVertices;
    private int numArestas;
    private Vector<Vertice> vertices;
    private Vector<Aresta> arestas;

    public Grafo() {
        this.numVertices = 0;
        this.numArestas = 0;
        this.vertices = new Vector<Vertice>();
        this.arestas = new Vector<Aresta>();
    }

    public Vertice[] finalVertices(Aresta aresta) {
        Vertice[] verticesPertencentes = new Vertice[2];
        verticesPertencentes[0] = aresta.getVerticeOrigem();
        verticesPertencentes[1] = aresta.getVerticeDestino();

        return verticesPertencentes;
    }

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
        for (Adjacencia adj : vertice1.getAdjacencias()) {
            if (adj.getVertice() == vertice2) {
                return true;
            }
        }
        return false;
    }

    public boolean ehDirecionada(Aresta aresta) {
        return aresta.getFlagDirecionada();
    }

    public void substituirElementoVertice(Vertice vertice, Object elemento) {
        vertice.substituir(elemento);
    }

    public void substituirElementoAresta(Aresta aresta, int valor) {
        aresta.substituir(valor);
    }

    public void inserirVertice(Object elemento) {
        Vertice novoVertice = new Vertice(elemento, this.numVertices);
        this.vertices.add(novoVertice);
        this.numVertices++;
    }

    // recebe logo se é direcionada ou não
    public void inserirAresta(Vertice vertice1, Vertice vertice2, int valor, boolean ehDirecionada) {
        Aresta novaAresta = new Aresta(valor, vertice1, vertice2, ehDirecionada);
        this.arestas.add(novaAresta);
        this.numArestas++;

        if (ehDirecionada) {
            Adjacencia adj = new Adjacencia(vertice2, novaAresta);
            vertice1.getAdjacencias().add(adj);
            vertice1.setGrau(vertice1.getGrau()+1);
            vertice2.setGrauEntrada(vertice2.getGrauEntrada()+1);
            return;
        }
        // se ela for paralela (não direcionada), só adiciono dois obj Adjacencia na lista dos dois e mudo o grau
        Adjacencia adjVertice1 = new Adjacencia(vertice2, novaAresta);
        Adjacencia adjVertice2 = new Adjacencia(vertice1, novaAresta);
        vertice1.getAdjacencias().add(adjVertice1);
        vertice2.getAdjacencias().add(adjVertice2);

        // mudança de grau de ambas
        vertice1.setGrau(vertice1.getGrau()+1);
        vertice2.setGrau(vertice2.getGrau()+1);
    }

    public void removeVertice(Vertice vertice) {
        int i = 0;
        while (i < vertice.getAdjacencias().size()) {
            Adjacencia adjAtual = vertice.getAdjacencias().get(i);
            Vertice verticeParaVerificar = adjAtual.getVertice();
            Vector<Adjacencia> paraRemover = new Vector<Adjacencia>(verticeParaVerificar.getAdjacencias());
            
            for (int j=0; j < paraRemover.size(); j++) {
                Adjacencia adjRemover = paraRemover.get(j);
                if (adjRemover.getVertice() == vertice) {
                    if (adjRemover.getAresta().getFlagDirecionada()) {
                        verticeParaVerificar.setGrauEntrada(verticeParaVerificar.getGrauEntrada()-1);
                    }
                    verticeParaVerificar.setGrau(verticeParaVerificar.getGrau()-1);
                    paraRemover.remove(j);
                    j--;
                } 
            }
            verticeParaVerificar.setAdjacencia(paraRemover);
            i++;
        }
        this.vertices.remove(vertice);
        this.numVertices--;
    }

    public void removeAresta(Aresta aresta) {
        this.arestas.remove(aresta);
        this.numArestas--;
        Vertice origem = aresta.getVerticeOrigem();
        Vertice destino = aresta.getVerticeDestino();

        if (aresta.getFlagDirecionada()) {
            for (int i=0; i < origem.getAdjacencias().size(); i++) {
                Adjacencia adj = origem.getAdjacencias().get(i);
                if (adj.getAresta() == aresta) {
                    origem.setGrau(origem.getGrau()-1);
                    origem.getAdjacencias().remove(i);
                    destino.setGrauEntrada(destino.getGrauEntrada()-1);
                    return;
                }
            }
        }
        // se nao for direcionada
        for (int i=0; i < origem.getAdjacencias().size(); i++) {
            Adjacencia adj = origem.getAdjacencias().get(i);
            if (adj.getAresta() == aresta) {
                origem.setGrau(origem.getGrau()-1);
                origem.getAdjacencias().remove(i);
            }
        }

        for (int j=0; j < destino.getAdjacencias().size(); j++) {
            Adjacencia adj = origem.getAdjacencias().get(j);
            if (adj.getAresta() == aresta) {
                destino.setGrau(destino.getGrau()-1);
                destino.getAdjacencias().remove(j);
            }
        }
    }

    public Aresta[] arestasIncidentes(Vertice vertice) {
        Aresta[] arestas = new Aresta[vertice.getAdjacencias().size()];
        for (int i=0; i < vertice.getAdjacencias().size(); i++) {
            Adjacencia adj = vertice.getAdjacencias().get(i);
            arestas[i] = adj.getAresta(); 
        }
        return arestas;
    }

    public Vector<Vertice> vertices() {
        return this.vertices;
    }

    public Vector<Aresta> arestas() {
        return this.arestas;
    }
}