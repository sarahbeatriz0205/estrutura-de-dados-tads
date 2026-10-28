package exercicios.implementacoes_java.trabalho_grafos.matriz_de_adjacencia;

public class TesteGrafoMatriz {
    public static void main(String[] args) throws Exception {
        Vertice v1Inicial = new Vertice("A", 1);
        Grafo grafo = new Grafo(v1Inicial);

        grafo.inserirVertice("B");
        Vertice v2 = grafo.vertices().get(1);
        grafo.printMatriz();

        grafo.inserirAresta(v1Inicial, v2, 10);
        Aresta e1 = grafo.arestas().get(0);

        System.out.println("É adjacente? " + grafo.ehAdjacente(v1Inicial, v2));

        System.out.println("Oposto de v1: " + grafo.oposto(v1Inicial, e1));

        grafo.printMatriz();

        grafo.removeAresta(e1);
        System.out.println("Ainda é adjacente após remover? " + grafo.ehAdjacente(v1Inicial, v2));
        
        grafo.printMatriz();
    }
}