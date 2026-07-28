package exercicios.trabalho_lista.implementacao_array;

public class TesteListaArray {

    public static void main(String[] args) {
        // Inicializando com capacidade para 5 elementos
        ILista lista = new Lista(5);

        System.out.println("=== INICIANDO TESTES DA LISTA (VIA ARRAY) ===");

        // 1. Verificação de estado inicial
        System.out.println("Lista está vazia? " + lista.isEmpty()); // Esperado: true
        System.out.println("Tamanho inicial: " + lista.size());    // Esperado: 0

        // 2. Testando Inserções (Lógica de deslocamento de array)
        lista.insertFirst("C");          // [C]
        lista.insertFirst("A");          // [A, C]
        lista.insertAfter(0, "B");       // Insere B após índice 0: [A, B, C]
        lista.insertLast("E");           // [A, B, C, E]
        lista.insertBefore(3, "D");      // Insere D antes do índice 3: [A, B, C, D, E]

        System.out.println("\n--- Após Inserções ---");
        System.out.println("Tamanho (esperado 5): " + lista.size());
        System.out.println("Primeiro: " + lista.first()); // A
        System.out.println("Último: " + lista.last());   // E

        // 3. Testando Navegação e Busca
        System.out.println("\n--- Navegação ---");
        System.out.println("O 'A' é o primeiro? " + lista.isFirst("A")); // true
        System.out.println("O 'E' é o último? " + lista.isLast("E"));   // true
        System.out.println("Elemento antes do índice 2 (C): " + lista.before(2)); // B
        System.out.println("Elemento depois do índice 3 (D): " + lista.after(3));  // E

        // 4. Testando Modificações
        System.out.println("\n--- Modificações ---");
        // Troca A (índice 0) com C (índice 2) -> [C, B, A, D, E]
        lista.swapElements(0, 2);
        System.out.println("Novo primeiro após swap(0,2): " + lista.first()); // C
        
        // Substitui B (índice 1) por 'X'
        Object antigo = lista.replaceElement(1, "X");
        System.out.println("Substituiu: " + antigo + " por: X");

        // 5. Testando Remoção (Lógica de fechar o buraco no array)
        System.out.println("\n--- Remoção ---");
        // Lista atual: [C, X, A, D, E]
        Object removido = lista.remove(1); // Remove X
        System.out.println("Removido: " + removido);
        System.out.println("Novo tamanho (esperado 4): " + lista.size());
        System.out.println("Elemento que ocupou a vaga do removido: " + lista.after(0)); // A

        // 6. Teste de Esvaziamento Dinâmico
        System.out.println("\n--- Esvaziando a lista dinamicamente ---");
        
        int totalRemovido = 0;
        while (!lista.isEmpty()) {
            Object item = lista.remove(0); // Remove sempre o primeiro disponível
            System.out.println("Removendo: " + item);
            totalRemovido++;
        }

        System.out.println("Total de itens removidos: " + totalRemovido);
        System.out.println("Lista está vazia agora? " + lista.isEmpty()); // true
        System.out.println("Tamanho final: " + lista.size());             // 0
    }
}