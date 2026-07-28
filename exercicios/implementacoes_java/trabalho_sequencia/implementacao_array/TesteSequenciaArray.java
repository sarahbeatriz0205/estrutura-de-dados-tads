package exercicios.trabalho_sequencia.implementacao_array;

public class TesteSequenciaArray {
    public static void main(String[] args) {
        try {
            // Iniciamos com capacidade 3 para testar o redimensionamento automático
            Sequencia seq = new Sequencia(3);

            System.out.println("--- 1. Testando Inserções por Rank (Manual) ---");
            seq.insertAtRank(0, "B");      // [B]
            seq.insertAtRank(0, "A");      // [A, B]
            seq.insertAtRank(2, "D");      // [A, B, D]
            seq.insertAtRank(2, "C");      // [A, B, C, D] (Aqui deve ter redimensionado)
            
            imprimirSequencia(seq); // Esperado: [A] [B] [C] [D]

            System.out.println("\n--- 2. Testando Acessos e Vizinhos ---");
            System.out.println("Primeiro elemento: " + seq.first()); // A
            System.out.println("Último elemento: " + seq.last());   // D
            System.out.println("Quem vem antes do rank 2 (C)? " + seq.before(2)); // B
            System.out.println("Quem vem depois do rank 2 (C)? " + seq.after(2));   // D

            System.out.println("\n--- 3. Testando Trocas e Substituições ---");
            System.out.print("Trocando rank 0 com rank 3... ");
            seq.swapElements(0, 3);
            imprimirSequencia(seq); // Esperado: [D] [B] [C] [A]

            System.out.print("Substituindo rank 1 por 'NOVO'... ");
            seq.replaceAtRank(1, "NOVO");
            imprimirSequencia(seq); // Esperado: [D] [NOVO] [C] [A]

            System.out.println("\n--- 4. Testando Remoções ---");
            Object removido = seq.removeAtRank(1);
            System.out.println("Elemento removido do rank 1: " + removido);
            imprimirSequencia(seq); // Esperado: [D] [C] [A]

            System.out.println("\n--- 5. Testando Casos de Erro (Exceções) ---");
            try {
                System.out.println("Tentando acessar rank 10...");
                seq.elemAtRank(10);
            } catch (SequenciaExcecaoArray e) {
                System.out.println("Sucesso: Capturou o erro esperado -> " + e.getMessage());
            }

            System.out.println("\n--- Teste Finalizado! ---");
            System.out.println("Tamanho final: " + seq.size());
            System.out.println("Está vazia? " + seq.isEmpty());

        } catch (Exception e) {
            System.err.println("\nERRO CRÍTICO NO TESTE: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método auxiliar para facilitar a visualização no console
    private static void imprimirSequencia(Sequencia s) {
        System.out.print("Sequência atual: ");
        try {
            for (int i = 0; i < s.size(); i++) {
                System.out.print("[" + s.elemAtRank(i) + "] ");
            }
        } catch (Exception e) {
            System.out.print("Erro ao ler elemento.");
        }
        System.out.println();
    }
}