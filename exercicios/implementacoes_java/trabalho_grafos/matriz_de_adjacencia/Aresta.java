package exercicios.implementacoes_java.trabalho_grafos.matriz_de_adjacencia;

public class Aresta {
    private boolean ehDirecionada;
    private int valor; // coloquei int pensando que ele vai guardar uma distância, por exemplo
    private Vertice verticeOrigem;
    private Vertice verticeDestino;

    public Aresta(int valor, Vertice verticeOrigem, Vertice verticeDestino, boolean ehDirecionada) {
        this.valor = valor; 
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
        this.ehDirecionada = ehDirecionada;
    }

    public Vertice getVerticeOrigem() {
        return this.verticeOrigem;
    }

    public Vertice getVerticeDestino() {
        return this.verticeDestino;
    }

    public int getValor() {
        return this.valor;
    }

    public boolean getFlagDirecionada() {
        return this.ehDirecionada;
    }

    public void substituirElemento(int valor) {
        this.valor = valor;
    }
}
