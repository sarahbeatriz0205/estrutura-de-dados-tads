package exercicios.trabalho_sequencia.implementacao_duplamente_ligada;

public class TesteSequencia {
    public static void main(String[] args) {
        try {
            ISequencia seq = new SequenciaDuplamenteLigada();
            System.out.println("--- Iniciando Teste Geral (Vetor + Lista) ---");

            // ==========================================
            // PARTE 1: INSERÇÕES MISTAS (VETOR + LISTA)
            // ==========================================
            System.out.println("\n[1] Testando Inserções...");
            
            // Usando métodos de Vetor (Ranks)
            seq.insertAtRank(0, "Meio");         // Estado: [Meio]
            seq.insertAtRank(0, "Inicio");       // Estado: [Inicio, Meio]
            
            // Usando métodos herdados de Lista (Mãe)
            seq.insertLast("Fim");               // Estado: [Inicio, Meio, Fim]
            seq.insertFirst("Primeiro_De_Todos");// Estado: [Primeiro_De_Todos, Inicio, Meio, Fim]
            
            // Voltando para Vetor no meio da lista
            seq.insertAtRank(2, "Novo_Rank2");   // Estado: [Primeiro_De_Todos, Inicio, Novo_Rank2, Meio, Fim]
            
            System.out.println("Tamanho atual (deve ser 5): " + seq.size());
            imprimir(seq);

            // ==========================================
            // PARTE 2: BUSCA E VIZINHANÇA (MÉTODOS PONTE + LISTA)
            // ==========================================
            System.out.println("\n[2] Testando Navegação por Nós...");
            
            // Pega o nó do meio pelo Rank (Método Ponte)
            No noAlvo = seq.atRank(3); // Deve recuperar o "Meio"
            System.out.println("Nó recuperado no rank 3: " + noAlvo.getElemento());

            // AJUSTE AQUI: Adicionado o Cast (No) para adaptar ao retorno da sua classe mãe
            No noAnterior = (No) seq.before(noAlvo);
            No noProximo  = (No) seq.after(noAlvo);
            
            System.out.println("Via before() (esperado 'Novo_Rank2'): " + noAnterior.getElemento());
            System.out.println("Via after() (esperado 'Fim'): " + noProximo.getElemento());
            
            // Testando o inverso: descobrir o Rank a partir do Nó (Método Ponte)
            System.out.println("Rank do nó 'Novo_Rank2': " + seq.rankOf(noAnterior));

            // ==========================================
            // PARTE 3: ALTERAÇÕES E SWAP (MÉTODOS DE LISTA)
            // ==========================================
            System.out.println("\n[3] Testando Alterações e Trocas...");
            
            // Substituição por Rank e por Nó
            seq.replaceAtRank(0, "MUDOU_ANTERIOR");
            seq.replaceElement(noAlvo, "MEIO_MUDADO"); // Herdados da mãe
            
            System.out.print("Estado antes do Swap: ");
            imprimir(seq);

            // Testando o Swap da classe mãe
            System.out.println("Executando swapElements entre o Rank 1 e o Rank 3...");
            No nodo1 = seq.atRank(1);
            No nodo3 = seq.atRank(3);
            seq.swapElements(nodo1, nodo3);
            
            System.out.print("Estado após o Swap: ");
            imprimir(seq);

            // ==========================================
            // PARTE 4: REMOÇÃO SISTEMÁTICA
            // ==========================================
            System.out.println("\n[4] Esvaziando a Sequência...");
            
            // Removendo um nó específico (Método de lista)
            No noParaRemover = seq.atRank(2);
            System.out.println("Removendo nó do meio via remove(No) (esperado 'Novo_Rank2'): " + seq.remove(noParaRemover));
            imprimir(seq);

            // Limpando o resto com método de Vetor
            System.out.println("\nLimpando o resto com removeAtRank(0)...");
            while (!seq.isEmpty()) {
                Object removido = seq.removeAtRank(0);
                System.out.println("Removido: " + removido + " | Sobrou tam: " + seq.size());
            }

            System.out.println("\nLista final está vazia? " + seq.isEmpty());

        } catch (Exception e) {
            System.err.println("\n--- FALHA NO TESTE ---");
            System.err.println("Mensagem de erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void imprimir(ISequencia s) {
        System.out.print("Lista atual: ");
        for (int i = 0; i < s.size(); i++) {
            System.out.print("[" + s.elemAtRank(i) + "] ");
        }
        System.out.println();
    }
}