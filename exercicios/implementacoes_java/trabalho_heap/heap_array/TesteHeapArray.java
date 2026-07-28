package heap_array;

public class TesteHeapArray {
    public static void main(String[] args) {

        HeapArray heap = new HeapArray(10);

        // Inserindo elementos
        heap.insert(20);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        heap.insert(15);

        /*
         * Após as inserções, considerando um Min-Heap:
         *
         * Elementos inseridos: 20, 10, 30, 5, 15
         *
         * Estrutura esperada:
         *         5
         *       /   \
         *     10     30
         *    /  \
         *  20   15
         */

        System.out.println("Removendo o menor elemento:");
        System.out.println(heap.removeMin());

        /*
         * Saída esperada:
         * 5
         *
         * Após a remoção do menor elemento,
         * o heap deve ser reorganizado pelo downheap.
         *
         * Estrutura esperada:
         *         10
         *       /    \
         *     15      30
         *    /
         *  20
         */

        System.out.println(heap.removeMin());

        /*
         * Saída esperada:
         * 10
         *
         * Nova estrutura:
         *         15
         *       /    \
         *     20      30
         */

        System.out.println(heap.removeMin());

        /*
         * Saída esperada:
         * 15
         *
         * Nova estrutura:
         *       20
         *      /
         *    30
         */

        System.out.println(heap.removeMin());

        /*
         * Saída esperada:
         * 20
         *
         * Nova estrutura:
         * 30
         */

        System.out.println(heap.removeMin());

        /*
         * Saída esperada:
         * 30
         *
         * Heap vazio.
         */

    }
}