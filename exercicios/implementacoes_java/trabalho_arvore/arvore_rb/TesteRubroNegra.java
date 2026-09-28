import arvore_binaria.ArvoreExcecao;
import arvore_binaria.NoArvore;
import arvore_rb.RubroNegra;

public class TesteRubroNegra {
    public static void main(String[] args) {
        try {
            System.out.println("=== 1. Inicializando a Árvore Rubro-Negra ===");
            int valorRaizInicial = 10;
            RubroNegra arvore = new RubroNegra(valorRaizInicial);

            System.out.println("\n--- Estado Inicial (Raiz: 10) ---");
            arvore.imprimirArvore(); // Chama internamente o preencherMatriz()

            System.out.println("\n=== 2. Inserindo Elementos e Exibindo a Matriz ===");
            int[] elementos = {20, 30, 15, 25, 5, 1, 18, 27};

            for (int elemento : elementos) {
                System.out.println("\n-> Inserindo: " + elemento);
                arvore.insert(elemento, arvore.root());
                
                // Exibe a estrutura da matriz com os elementos e suas cores [Rubro] / [Negro]
                arvore.imprimirArvore();
            }

            System.out.println("\n=== 3. Executando preencherMatriz Manualmente ===");
            // Demonstração de chamada direta do algoritmo de preenchimento de matriz
            int altura = arvore.heigth(arvore.root(), arvore.root()); // Se a BST tiver método de altura
            int linhas = altura + 2;
            int colunas = (int) Math.pow(2, linhas) - 1;
            String[][] matriz = new String[linhas][colunas];

            // Preenche a matriz customizada com deslocamento inicial
            imprimirMatrizCustomizada(arvore, matriz, colunas);

            System.out.println("\n=== 4. Teste de Remoção com Atualização da Matriz ===");
            int valorParaRemover = 15;
            NoArvore noParaRemover = arvore.search(valorParaRemover, arvore.root());

            if (noParaRemover != null) {
                System.out.println("\n-> Removendo o nó: " + valorParaRemover);
                arvore.remove(noParaRemover);

                System.out.println("\nEstrutura visual da árvore após a remoção:");
                arvore.imprimirArvore();
            } else {
                System.out.println("Nó " + valorParaRemover + " não encontrado.");
            }

        } catch (ArvoreExcecao e) {
            System.err.println("Exceção da Árvore: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro durante a execução: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Exemplo de método utilitário para imprimir no console a matriz gerada
     * pelo preencherMatriz().
     */
    private static void imprimirMatrizCustomizada(RubroNegra arvore, String[][] matriz, int colunas) {
        int deslocamentoInicial = (colunas + 1) / 4;
        
        // Se preencherMatriz for protected e estiver no mesmo pacote de Main, 
        // pode ser chamado diretamente. Caso contrário, a chamada ocorre via imprimirArvore().
        // arvore.preencherMatriz(arvore.root(), matriz, 0, colunas / 2, deslocamentoInicial);

        System.out.println("Caminhamento Em-Ordem de validação:");
        arvore.inOrder(arvore.root());
        System.out.println();
    }
}