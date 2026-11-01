package exercicios.implementacoes_java.trabalho_grafos.lista_de_adjacencia;
import java.util.Vector;

public class Vertice {
    private int verticeId;
    private int grauEntrada; // lembrar de mudar na matriz
    // grauSaida vai ter o conceito de grau em grafos não direcionados caso ele não seja direcionado
    // se for direcionado, mudo grauEntrada e grauSaida. senão, mudo só grauSaida em ambos os vértices
    private int grauSaida;
    private Object elemento;
    private Vector<Adjacencia> adjacentes; // o vértice vai ter suas adjacências, contendo vertice-aresta

    public Vertice(Object elemento, int numVertices) {
        this.elemento = elemento;
        this.verticeId = numVertices+1;
        this.adjacentes = new Vector<Adjacencia>();
        this.grauSaida = 0;
        this.grauEntrada = 0;
    }

    public Vector<Adjacencia> getAdjacencias() {
        return this.adjacentes;
    }

    public int getGrau() {
        return this.grauSaida;
    }

    public int getGrauEntrada() {
        return this.grauEntrada;
    }

    public int getId() {
        return this.verticeId;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public void substituir(Object elemento) {
        this.elemento = elemento;
    }

    public void setGrau(int grau) {
        this.grauSaida = grau;
    }

    public void setGrauEntrada(int grau) {
        this.grauEntrada = grau;
    }

    public void setAdjacencia(Vector<Adjacencia> adjacencias) {
        this.adjacentes = adjacencias;
    }
}