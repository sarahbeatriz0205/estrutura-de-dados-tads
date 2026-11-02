package exercicios.implementacoes_java.trabalho_grafos.lista_de_adjacencia;

import java.util.Vector;

public class TesteGrafoLista {

    public static void main(String[] args) throws Exception {
        System.out.println("=== INICIANDO TESTES EXPANDIDOS DO GRAFO (LISTA) ===\n");

        Grafo grafo = new Grafo();
        System.out.println("Grafo criado com sucesso.");

        grafo.inserirVertice("A");
        grafo.inserirVertice("B");
        grafo.inserirVertice("C");
        grafo.inserirVertice("D");

        Vector<Vertice> v = grafo.vertices();
        Vertice a = v.get(0);
        Vertice b = v.get(1);
        Vertice c = v.get(2);
        Vertice d = v.get(3);
        System.out.println("-> 4 Vértices inseridos (A, B, C, D). Total: " + grafo.vertices().size());

        grafo.inserirAresta(a, b, 10, false);
        grafo.inserirAresta(b, c, 20, true);
        grafo.inserirAresta(c, d, 30, false);
        grafo.inserirAresta(d, a, 40, true);

        Vector<Aresta> arestas = grafo.arestas();
        System.out.println("-> 4 Arestas inseridas. Total de arestas no grafo: " + arestas.size());

        System.out.println("\n--- TESTANDO ADJACÊNCIAS ---");
        System.out.println("A é adjacente a B? " + grafo.ehAdjacente(a, b));
        System.out.println("B é adjacente a A? " + grafo.ehAdjacente(b, a));
        System.out.println("B é adjacente a C? " + grafo.ehAdjacente(b, c));
        System.out.println("A é adjacente a C? " + grafo.ehAdjacente(a, c));

        System.out.println("\n--- TESTANDO FINALVERTICES E OPOSTO ---");
        Aresta e1 = arestas.get(0);
        Aresta e2 = arestas.get(1);
        
        System.out.println("Testando finalVertices(e1)... Executado.");
        Object extremosE1 = grafo.finalVertices(e1); 

        Vertice opostoA = grafo.oposto(a, e1);
        System.out.println("Oposto de A em relação a e1 é o vértice B? " + (opostoA == b));

        System.out.println("\n--- TESTANDO DIREIONAMENTO ---");
        System.out.println("A aresta e1 é direcionada? " + grafo.ehDirecionada(e1));
        System.out.println("A aresta e2 é direcionada? " + grafo.ehDirecionada(e2));

        System.out.println("\n--- TESTANDO INCIDÊNCIAS E SUBSTITUIÇÕES ---");
        Aresta[] incidentesB = grafo.arestasIncidentes(b);
        System.out.println("Quantidade de arestas incidentes no vértice B: " + incidentesB.length);

        grafo.substituirElementoVertice(a, "A_Modificado");
        System.out.println("Elemento do vértice a substituído com sucesso.");

        grafo.substituirElementoAresta(e1, 99);
        System.out.println("Elemento da aresta e1 substituído com sucesso.");

        imprimirListasAdjacencia(grafo, "ESTADO DO GRAFO ANTES DAS REMOÇÕES");

        System.out.println("\n--- TESTANDO REMOÇÃO DE ARESTA ---");
        grafo.removeAresta(e2);
        System.out.println("Aresta e2 removida. Novo total de arestas: " + grafo.arestas().size());

        System.out.println("\n--- TESTANDO REMOÇÃO DE VÉRTICE ---");
        grafo.removeVertice(c);
        System.out.println("Vértice c (C) removido. Novo total de vértices: " + grafo.vertices().size());

        imprimirListasAdjacencia(grafo, "ESTADO FINAL DO GRAFO APÓS REMOÇÕES");
    }

    private static void imprimirListasAdjacencia(Grafo grafo, String titulo) throws Exception {
        System.out.println("\n=== " + titulo + " ===");
        Vector<Vertice> verticesAtuais = grafo.vertices();
        if (verticesAtuais.isEmpty()) {
            System.out.println("Grafo vazio.");
            return;
        }
        for (Vertice vertice : verticesAtuais) {
            System.out.print("Vértice [" + vertice.getElemento() + "] (Grau: " + vertice.getGrau() + ") -> Arestas incidentes: ");
            Aresta[] arestasVertice = grafo.arestasIncidentes(vertice);
            if (arestasVertice == null || arestasVertice.length == 0) {
                System.out.println("Nenhuma (isolado)");
            } else {
                System.out.print("[ ");
                for (Aresta aresta : arestasVertice) {
                    Vertice vizinho = grafo.oposto(vertice, aresta);
                    String direcao = grafo.ehDirecionada(aresta) ? "Dir." : "Não-dir.";
                    System.out.print("(Aresta Valor: " + aresta.getValor() + " [" + direcao + "], Vizinho: " + vizinho.getElemento() + ") ");
                }
                System.out.println("]");
            }
        }
    }
}