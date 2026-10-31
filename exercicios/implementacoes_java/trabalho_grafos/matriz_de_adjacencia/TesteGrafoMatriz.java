package exercicios.implementacoes_java.trabalho_grafos.matriz_de_adjacencia;

public class TesteGrafoMatriz {
    public static void main(String[] args) throws Exception {
        Vertice v1 = new Vertice("A", 1); 
        Grafo grafo = new Grafo(v1);

        grafo.inserirVertice("B");
        grafo.inserirVertice("C");
        grafo.inserirVertice("D");
        
        Vertice v2 = grafo.vertices().get(1);
        Vertice v3 = grafo.vertices().get(2);
        Vertice v4 = grafo.vertices().get(3);

        grafo.inserirAresta(v1, v2, 10, false);
        grafo.inserirAresta(v2, v3, 20, true);
        grafo.inserirAresta(v1, v2, 15, true); 
        grafo.inserirAresta(v3, v4, 25, false);
        grafo.inserirAresta(v4, v1, 35, true);

        Aresta e1 = grafo.arestas().get(0);

        grafo.substituirElementoVertice(v3, "C-Modificado");
        
        grafo.substituirElementoAresta(e1, 99);
        System.out.println("Valor da aresta e1: " + e1.getValor());

        grafo.printMatriz();

        System.out.println("v1 é adjacente a v2? " + grafo.ehAdjacente(v1, v2));
        System.out.println("v2 é adjacente a v1? " + grafo.ehAdjacente(v2, v1));
        System.out.println("v3 é adjacente a v2? " + grafo.ehAdjacente(v3, v2));
        System.out.println("v1 é adjacente a v3? " + grafo.ehAdjacente(v1, v3));
        System.out.println("Vértice oposto a v1 na aresta e1: " + grafo.oposto(v1, e1).getElemento());

        grafo.removeVertice(v2);
        grafo.printMatriz();
        System.out.println();

        Aresta arestaParaRemover = grafo.arestas().get(0);
        grafo.removeAresta(arestaParaRemover);
        grafo.printMatriz();
        System.out.println();

        Aresta outraAresta = grafo.arestas().get(0);
        grafo.removeAresta(outraAresta);
        grafo.printMatriz();
    }
}