package exercicios.trabalho_fila;

public class TesteFilaArrayReverse {
    public static void main(String[] args) throws Exception {
        FilaArrayReverse fila = new FilaArrayReverse(4, 0);

        // isEmpty
        System.out.println(fila.isEmpty()); // true

        // enqueue + size
        fila.enqueue("A");
        fila.enqueue("B");
        fila.enqueue("C");
        System.out.println(fila.size()); // 3

        // first
        System.out.println(fila.first()); // A

        // dequeue
        System.out.println(fila.dequeue()); // A
        System.out.println(fila.dequeue()); // B
        System.out.println(fila.size());    // 1

        // reverse()
        fila.enqueue("D");
        fila.enqueue("E");
        fila.reverse();
        System.out.println(fila.dequeue()); // E
        System.out.println(fila.dequeue()); // D
        System.out.println(fila.dequeue()); // C

        // ----------------------------
        // reverse() duas vezes volta ao normal
        System.out.println("\n-- reverse() duas vezes --");
        FilaArrayReverse fila2 = new FilaArrayReverse(4, 0);
        fila2.enqueue("A");
        fila2.enqueue("B");
        fila2.enqueue("C");
        fila2.reverse();
        fila2.reverse();
        System.out.println(fila2.dequeue()); // A
        System.out.println(fila2.dequeue()); // B
        System.out.println(fila2.dequeue()); // C

        // ----------------------------
        // enqueue com reversed
        System.out.println("\n-- enqueue com reversed --");
        FilaArrayReverse fila3 = new FilaArrayReverse(4, 0);
        fila3.enqueue("A");
        fila3.enqueue("B");
        fila3.reverse()();
        fila3.enqueue("Z"); // entra no início
        fila3.reverse()();
        System.out.println(fila3.dequeue()); // Z
        System.out.println(fila3.dequeue()); // A
        System.out.println(fila3.dequeue()); // B

        // ----------------------------
        // redimensionamento — enqueue além do tamanho inicial
        System.out.println("\n-- redimensionamento --");
        FilaArrayReverse fila4 = new FilaArrayReverse(4, 0);
        fila4.enqueue("A");
        fila4.enqueue("B");
        fila4.enqueue("C");
        fila4.enqueue("D"); // força duplicação
        fila4.enqueue("E");
        System.out.println(fila4.size());    // 5
        System.out.println(fila4.dequeue()); // A
        System.out.println(fila4.dequeue()); // B
        System.out.println(fila4.dequeue()); // C
        System.out.println(fila4.dequeue()); // D
        System.out.println(fila4.dequeue()); // E

        // ----------------------------
        // first com reversed
        System.out.println("\n-- first com reversed --");
        FilaArrayReverse fila5 = new FilaArrayReverse(4, 0);
        fila5.enqueue("A");
        fila5.enqueue("B");
        fila5.enqueue("C");
        fila5.reverse()();
        System.out.println(fila5.first()); // C
        System.out.println(fila5.size());  // 3 — first nao remove

        // ----------------------------
        // dequeue em fila vazia
        System.out.println("\n-- dequeue em fila vazia --");
        FilaArrayReverse fila6 = new FilaArrayReverse(4, 0);
        try {
            fila6.dequeue();
        } catch (FilaVaziaExcecao e) {
            System.out.println(e.getMessage()); // A Fila está vazia
        }
    }
}