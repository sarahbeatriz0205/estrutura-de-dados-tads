package exercicios.implementacoes_java.trabalho_grafos.matriz_de_adjacencia;
import java.util.Vector;

public class Vertice {
    private int verticeId;
    private int grau;
    private Object elemento;

    public Vertice(Object elemento, int numVertices) {
        this.elemento = elemento;
        // passar o numVertices geral pra conseguir com que o id do vértice seja igual ao do índice
        this.verticeId = numVertices - 1; 
    }

    public int getId() {
        return this.verticeId;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public int getGrau() {
        return this.grau;
    }

    // método do TAD Grafo (seria o setElemento)
    public void substituirElemento(Object elemento) {
        this.elemento = elemento;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public void setId(int verticeId) {
        this.verticeId = verticeId;
    }
}
