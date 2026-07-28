package arvore_binaria;

public class TesteArvoreBinariaDePesquisa {

    public static void main(String[] args) {

        try {

            ArvoreBinariaDePesquisa arvore = new ArvoreBinariaDePesquisa(50);

            System.out.println("=== Árvore Inicial ===");
            arvore.imprimirArvore();

            System.out.println("\n=== Inserindo elementos ===");
            arvore.insert(30, arvore.root());
            arvore.insert(70, arvore.root());
            arvore.insert(20, arvore.root());
            arvore.insert(40, arvore.root());
            arvore.insert(60, arvore.root());
            arvore.insert(80, arvore.root());

            arvore.imprimirArvore();

            System.out.println("\nTamanho: " + arvore.size());

            System.out.println("\n=== Buscando elementos ===");

            NoArvore n1 = arvore.search(40, arvore.root());
            System.out.println("40 encontrado? " + (n1.getElemento() == 40));

            NoArvore n2 = arvore.search(100, arvore.root());
            System.out.println("100 encontrado? " + (n2.getElemento() == 100));

            System.out.println("\n=== Informações da raiz ===");
            System.out.println("É raiz? " + arvore.isRoot(arvore.root()));
            System.out.println("Tem filho esquerdo? " + arvore.hasLeft(arvore.root()));
            System.out.println("Tem filho direito? " + arvore.hasRight(arvore.root()));
            System.out.println("Profundidade da raiz: " + arvore.depht(arvore.root()));

            System.out.println("\n=== Removendo folha (20) ===");
            NoArvore no20 = arvore.search(20, arvore.root());

            if (no20 != null) {
                arvore.remove(no20);
            }

            arvore.imprimirArvore();

            System.out.println("\n=== Removendo nó com um ou mais filhos (70) ===");
            NoArvore no70 = arvore.search(70, arvore.root());

            if (no70 != null) {
                arvore.remove(no70);
            }

            arvore.imprimirArvore();

            System.out.println("\n=== Inserindo novos elementos ===");
            arvore.insert(75, arvore.root());
            arvore.insert(90, arvore.root());

            arvore.imprimirArvore();

            System.out.println("\n=== Percurso Em Ordem ===");
            arvore.inOrder(arvore.root());

            System.out.println("\n\n=== Tamanho Final ===");
            System.out.println(arvore.size());

        } catch (ArvoreExcecao e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}