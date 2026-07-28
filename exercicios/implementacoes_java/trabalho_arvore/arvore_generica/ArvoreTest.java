package arvore_generica;

import java.util.Iterator;

/**
 * Classe de testes para o TAD Árvore Genérica.
 * Cada método é testado com exemplos concretos e saídas reais registradas abaixo.
 *
 * Estrutura de árvore usada nos testes:
 *
 *              "raiz"
 *             /      \
 *          "A"        "B"
 *         /   \          \
 *       "C"   "D"        "E"
 *
 * Saída real obtida na execução:
 * ========================================
 *    TESTES DO TAD ÁRVORE GENÉRICA
 * ========================================
 * --- TESTE 1: root() ---
 * Raiz: raiz
 *
 * --- TESTE 2: parent() ---
 * Pai de 'A': raiz
 * Pai da raiz: null
 *
 * --- TESTE 3: children() ---
 * Filhos de 'A': C D
 *
 * --- TESTE 4: isInternal() ---
 * 'A' é interno? true
 * 'C' é interno? false
 *
 * --- TESTE 5: isExternal() ---
 * 'C' é externo (folha)? true
 * 'A' é externo (folha)? false
 *
 * --- TESTE 6: isRoot() ---
 * 'raiz' é raiz? true
 * 'A' é raiz?    false
 *
 * --- TESTE 7: size() ---
 * Tamanho da árvore: 6
 *
 * --- TESTE 8: isEmpty() ---
 * Árvore está vazia? false
 * Árvore com 1 nó está vazia? false
 *
 * --- TESTE 9: depth() ---
 * Profundidade de 'raiz': 0
 * Profundidade de 'A':    1
 * Profundidade de 'C':    2
 *
 * --- TESTE 10: height() ---
 * Altura da árvore (a partir da raiz): 2
 * Altura do nó 'A':                    1
 * Altura do nó 'C' (folha):            0
 *
 * --- TESTE 11: replace() ---
 * Valor antigo de 'C': C
 * Novo valor de 'C':   C_novo
 *
 * --- TESTE 12: swapElements() ---
 * Antes do swap — A: A | B: B
 * Após o swap  — A: B | B: A
 *
 * --- TESTE 13: preOrder() ---
 * Pré-ordem: raiz
 * A
 * C
 * D
 * B
 * E
 *
 * --- TESTE 14: postOrder() ---
 * Pós-ordem: C
 * D
 * A
 * E
 * B
 * raiz
 *
 * --- TESTE 15: elements() ---
 * Elementos: raiz A B C D E
 *
 * --- TESTE 16: Nos() ---
 * Nós: raiz A B C D E
 *
 * --- TESTE 17: addChild() ---
 * Tamanho antes de adicionar: 6
 * Tamanho após adicionar 'F' como filho de 'C': 7
 * 'C' agora é interno? true
 *
 * --- TESTE 18: remove() ---
 * Tamanho antes de remover: 7
 * Elemento removido: F
 * Tamanho após remoção: 6
 *
 * Tentando remover nó com filhos ('A'):
 * Exceção esperada: Nó inválido
 *
 * ========================================
 *    TESTES CONCLUÍDOS
 * ========================================
 */
public class ArvoreTest {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   TESTES DO TAD ÁRVORE GENÉRICA");
        System.out.println("========================================\n");

        // -------------------------------------------------------
        // MONTAGEM DA ÁRVORE
        // -------------------------------------------------------
        Arvore arvore = new Arvore("raiz");
        No raiz = arvore.root();

        arvore.addChild(raiz, "A");
        arvore.addChild(raiz, "B");

        // Pegar os filhos da raiz para adicionar netos
        Iterator<No> filhosRaiz = arvore.children(raiz);
        No noA = filhosRaiz.next(); // filho "A"
        No noB = filhosRaiz.next(); // filho "B"

        arvore.addChild(noA, "C");
        arvore.addChild(noA, "D");
        arvore.addChild(noB, "E");

        // -------------------------------------------------------
        // TESTE 1: root()
        // -------------------------------------------------------
        System.out.println("--- TESTE 1: root() ---");
        No r = arvore.root();
        System.out.println("Raiz: " + r.element());
        // Saída: Raiz: raiz
        System.out.println();

        // -------------------------------------------------------
        // TESTE 2: parent()
        // -------------------------------------------------------
        System.out.println("--- TESTE 2: parent() ---");
        No paiDeA = arvore.parent(noA);
        System.out.println("Pai de 'A': " + paiDeA.element());
        // Saída: Pai de 'A': raiz

        No paiDaRaiz = arvore.parent(raiz);
        System.out.println("Pai da raiz: " + paiDaRaiz);
        // Saída: Pai da raiz: null
        System.out.println();

        // -------------------------------------------------------
        // TESTE 3: children()
        // -------------------------------------------------------
        System.out.println("--- TESTE 3: children() ---");
        Iterator<No> filhos = arvore.children(noA);
        System.out.print("Filhos de 'A': ");
        while (filhos.hasNext()) {
            System.out.print(filhos.next().element() + " ");
        }
        System.out.println();
        // Saída: Filhos de 'A': C D
        System.out.println();

        // -------------------------------------------------------
        // TESTE 4: isInternal()
        // -------------------------------------------------------
        System.out.println("--- TESTE 4: isInternal() ---");
        System.out.println("'A' é interno? " + arvore.isInternal(noA));
        // Saída: true (tem filhos C e D)

        Iterator<No> filhosDeA = arvore.children(noA);
        No noC = filhosDeA.next(); // nó "C"
        System.out.println("'C' é interno? " + arvore.isInternal(noC));
        // Saída: false (não tem filhos)
        System.out.println();

        // -------------------------------------------------------
        // TESTE 5: isExternal()
        // -------------------------------------------------------
        System.out.println("--- TESTE 5: isExternal() ---");
        System.out.println("'C' é externo (folha)? " + arvore.isExternal(noC));
        // Saída: true

        System.out.println("'A' é externo (folha)? " + arvore.isExternal(noA));
        // Saída: false
        System.out.println();

        // -------------------------------------------------------
        // TESTE 6: isRoot()
        // -------------------------------------------------------
        System.out.println("--- TESTE 6: isRoot() ---");
        System.out.println("'raiz' é raiz? " + arvore.isRoot(raiz));
        // Saída: true

        System.out.println("'A' é raiz?    " + arvore.isRoot(noA));
        // Saída: false
        System.out.println();

        // -------------------------------------------------------
        // TESTE 7: size()
        // -------------------------------------------------------
        System.out.println("--- TESTE 7: size() ---");
        System.out.println("Tamanho da árvore: " + arvore.size());
        // Saída: 6 (raiz, A, B, C, D, E)
        System.out.println();

        // -------------------------------------------------------
        // TESTE 8: isEmpty()
        // -------------------------------------------------------
        System.out.println("--- TESTE 8: isEmpty() ---");
        System.out.println("Árvore está vazia? " + arvore.isEmpty());
        // Saída: false

        Arvore arvoreVazia = new Arvore("temp");
        System.out.println("Árvore com 1 nó está vazia? " + arvoreVazia.isEmpty());
        // Saída: false (tem 1 nó)
        System.out.println();

        // -------------------------------------------------------
        // TESTE 9: depth()
        // -------------------------------------------------------
        System.out.println("--- TESTE 9: depth() ---");
        System.out.println("Profundidade de 'raiz': " + arvore.depth(raiz));
        // Saída: 0

        System.out.println("Profundidade de 'A':    " + arvore.depth(noA));
        // Saída: 1

        System.out.println("Profundidade de 'C':    " + arvore.depth(noC));
        // Saída: 2
        System.out.println();

        // -------------------------------------------------------
        // TESTE 10: height()
        // -------------------------------------------------------
        System.out.println("--- TESTE 10: height() ---");
        System.out.println("Altura da árvore (a partir da raiz): " + arvore.height(raiz));
        // Saída: 2

        System.out.println("Altura do nó 'A':                    " + arvore.height(noA));
        // Saída: 1

        System.out.println("Altura do nó 'C' (folha):            " + arvore.height(noC));
        // Saída: 0
        System.out.println();

        // -------------------------------------------------------
        // TESTE 11: replace()
        // -------------------------------------------------------
        System.out.println("--- TESTE 11: replace() ---");
        Object antigoValor = arvore.replace(noC, "C_novo");
        System.out.println("Valor antigo de 'C': " + antigoValor);
        // Saída: C
        System.out.println("Novo valor de 'C':   " + noC.element());
        // Saída: C_novo
        arvore.replace(noC, "C"); // restaura
        System.out.println();

        // -------------------------------------------------------
        // TESTE 12: swapElements()
        // -------------------------------------------------------
        System.out.println("--- TESTE 12: swapElements() ---");
        System.out.println("Antes do swap — A: " + noA.element() + " | B: " + noB.element());
        // Saída: Antes do swap — A: A | B: B
        arvore.swapElements(noA, noB);
        System.out.println("Após o swap  — A: " + noA.element() + " | B: " + noB.element());
        // Saída: Após o swap  — A: B | B: A
        arvore.swapElements(noA, noB); // restaura
        System.out.println();

        // -------------------------------------------------------
        // TESTE 13: preOrder()
        // -------------------------------------------------------
        System.out.println("--- TESTE 13: preOrder() ---");
        System.out.print("Pré-ordem: ");
        arvore.preOrder(raiz);
        // Saída: raiz / A / C / D / B / E  (cada elemento em nova linha)
        System.out.println();

        // -------------------------------------------------------
        // TESTE 14: postOrder()
        // -------------------------------------------------------
        System.out.println("--- TESTE 14: postOrder() ---");
        System.out.print("Pós-ordem: ");
        arvore.postOrder(raiz);
        // Saída: C / D / A / E / B / raiz  (cada elemento em nova linha)
        System.out.println();

        // -------------------------------------------------------
        // TESTE 15: elements()
        // -------------------------------------------------------
        System.out.println("--- TESTE 15: elements() ---");
        Iterator<Object> elementos = arvore.elements();
        System.out.print("Elementos: ");
        while (elementos.hasNext()) {
            System.out.print(elementos.next() + " ");
        }
        System.out.println();
        // Saída: raiz A B C D E
        System.out.println();

        // -------------------------------------------------------
        // TESTE 16: Nos()
        // -------------------------------------------------------
        System.out.println("--- TESTE 16: Nos() ---");
        Iterator<No> nos = arvore.Nos();
        System.out.print("Nós: ");
        while (nos.hasNext()) {
            System.out.print(nos.next().element() + " ");
        }
        System.out.println();
        // Saída: raiz A B C D E
        System.out.println();

        // -------------------------------------------------------
        // TESTE 17: addChild()
        // -------------------------------------------------------
        System.out.println("--- TESTE 17: addChild() ---");
        System.out.println("Tamanho antes de adicionar: " + arvore.size());
        // Saída: 6
        arvore.addChild(noC, "F");
        System.out.println("Tamanho após adicionar 'F' como filho de 'C': " + arvore.size());
        // Saída: 7
        System.out.println("'C' agora é interno? " + arvore.isInternal(noC));
        // Saída: true
        System.out.println();

        // -------------------------------------------------------
        // TESTE 18: remove()
        // -------------------------------------------------------
        System.out.println("--- TESTE 18: remove() ---");
        System.out.println("Tamanho antes de remover: " + arvore.size());
        // Saída: 7
        try {
            Iterator<No> filhosDeC = arvore.children(noC);
            No noF = filhosDeC.next();

            Object removido = arvore.remove(noF);
            System.out.println("Elemento removido: " + removido);
            // Saída: F
            System.out.println("Tamanho após remoção: " + arvore.size());
            // Saída: 6
        } catch (ArvoreExcecao e) {
            System.out.println("Exceção ao remover: " + e.getMessage());
        }

        // Tentativa de remover nó com filhos (deve lançar ArvoreExcecao)
        System.out.println("\nTentando remover nó com filhos ('A'):");
        try {
            arvore.remove(noA);
            System.out.println("Removido (não deveria chegar aqui).");
        } catch (ArvoreExcecao e) {
            System.out.println("Exceção esperada: " + e.getMessage());
            // Saída: Exceção esperada: Nó inválido
        }

        System.out.println("\n========================================");
        System.out.println("   TESTES CONCLUÍDOS");
        System.out.println("========================================");
    }
}