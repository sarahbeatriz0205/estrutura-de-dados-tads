package exercicios.trabalho_vetor.implementacao_lista_duplamente_ligada;

public class TesteVetorEncadeado{
    public static void main(String[] args) {
        IVetor lista = new VetorDuplamenteEncadeado(); 

        System.out.println("--- Iniciando Testes da Lista Duplamente Encadeada ---");

        try {
            // 1. Teste de isEmpty e size inicial
            System.out.println("Está vazia? " + lista.isEmpty()); // Esperado: true
            System.out.println("Tamanho inicial: " + lista.size()); // Esperado: 0

            // 2. Teste de Inserção (insertAtRank)
            System.out.println("\nInserindo elementos...");
            lista.insertAtRank(0, "Elemento A"); // [A]
            lista.insertAtRank(1, "Elemento C"); // [A, C]
            lista.insertAtRank(1, "Elemento B"); // [A, B, C] - Inserção no meio
            
            System.out.println("Tamanho após inserções: " + lista.size()); // Esperado: 3
            System.out.println("Elemento no rank 1: " + lista.elemAtRank(1)); // Esperado: Elemento B

            // 3. Teste de Substituição (replaceAtRank)
            System.out.println("\nTestando substituição...");
            Object antigo = lista.replaceAtRank(2, "Elemento Z"); 
            System.out.println("Antigo (rank 2): " + antigo); // Esperado: Elemento C
            System.out.println("Novo (rank 2): " + lista.elemAtRank(2)); // Esperado: Elemento Z

            // 4. Teste de Remoção (removeAtRank)
            System.out.println("\nTestando remoção...");
            Object removido = lista.removeAtRank(1); // Remove "Elemento B"
            System.out.println("Removido: " + removido); // Esperado: Elemento B
            System.out.println("Novo tamanho: " + lista.size()); // Esperado: 2
            System.out.println("Quem assumiu o rank 1: " + lista.elemAtRank(1)); // Esperado: Elemento Z

            // 5. Teste de Exceção (Rank inválido)
            System.out.println("\nTestando erro de rank inválido:");
            lista.insertAtRank(10, "Erro"); // Deve disparar sua VetorExcecao

        } catch (Exception e) {
            System.err.println("Capturado erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Fim dos Testes ---");
    }
}
