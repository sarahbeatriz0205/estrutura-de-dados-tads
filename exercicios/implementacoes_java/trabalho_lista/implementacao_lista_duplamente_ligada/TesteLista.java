package exercicios.trabalho_lista.implementacao_lista_duplamente_ligada;

public class TesteLista {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        try {
            System.out.println("--- Teste de Inserção ---");
            // Capturando as referências dos nós retornados
            No no1 = lista.insertFirst("Elemento 1");
            No no3 = lista.insertLast("Elemento 3");
            No no2 = lista.insertAfter(no1, "Elemento 2");
            No no0 = lista.insertBefore(no1, "Elemento 0");

            // Estado atual: [0, 1, 2, 3]
            System.out.println("Tamanho esperado (4): " + lista.size()); // Saída: 4
            System.out.println("Primeiro (Elemento 0): " + lista.first()); // Saída: Elemento 0
            System.out.println("Último (Elemento 3): " + lista.last());   // Saída: Elemento 3

            System.out.println("\n--- Teste de Navegação ---");
            System.out.println("Depois do no1 (Elemento 2): " + lista.after(no1)); // Saída: Elemento 2
            System.out.println("Antes do no1 (Elemento 0): " + lista.before(no1)); // Saída: Elemento 0

            System.out.println("\n--- Teste de Substituição e Troca ---");
            System.out.println("Substituindo no2...");
            Object antigo = lista.replaceElement(no2, "Elemento 2 Editado");
            System.out.println("Valor antigo: " + antigo); // Saída: Elemento 2
            System.out.println("Novo valor no2: " + no2.getElemento()); // Saída: Elemento 2 Editado

            System.out.println("Trocando no0 com no3...");
            lista.swapElements(no0, no3); 
            // Agora no0 tem "Elemento 3" e no3 tem "Elemento 0"
            System.out.println("Novo Primeiro (Elemento 3): " + lista.first()); // Saída: Elemento 3
            System.out.println("Novo Último (Elemento 0): " + lista.last());   // Saída: Elemento 0

            System.out.println("\n--- Teste de Verificação de Posição ---");
            // Retorna false porque o anterior do no3 é o sentinela 'head', não null
            System.out.println("no3 (agora na frente) é o primeiro? " + lista.isFirst(no3)); // Saída: false

            System.out.println("\n--- Teste de Remoção ---");
            Object removido = lista.remove(no1);
            System.out.println("Removido: " + removido); // Saída: Elemento 1
            System.out.println("Tamanho atual (3): " + lista.size()); // Saída: 3

            System.out.println("\n--- Teste de Exceção ---");
            ListaDuplamenteEncadeada listaVazia = new ListaDuplamenteEncadeada();
            listaVazia.first(); // Deve disparar a exceção configurada no seu código

        } catch (ListaExcecao e) {
            // Saída: Exceção capturada com sucesso: Erro! Lista vazia
            System.out.println("Exceção capturada com sucesso: " + e.getMessage()); 
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}