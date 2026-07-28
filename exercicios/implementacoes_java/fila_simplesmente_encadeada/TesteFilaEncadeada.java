package exercicios.fila_simplesmente_encadeada;
public class TesteFilaEncadeada {
    public static void main(String[] args) throws Exception {

        // --- isEmpty em fila vazia ---
        FilaEncadeada fila = new FilaEncadeada();
        System.out.println(fila.isEmpty()); // true

        // --- enqueue e size ---
        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        System.out.println(fila.size());  // 3
        System.out.println(fila.isEmpty()); // false

        // --- first não remove ---
        System.out.println(fila.first()); // 1
        System.out.println(fila.size());  // 3 (first não removeu)

        // --- dequeue remove o primeiro (FIFO) ---
        System.out.println(fila.dequeue()); // 1
        System.out.println(fila.first());   // 2
        System.out.println(fila.size());    // 2

        // --- múltiplos dequeues em ordem ---
        System.out.println(fila.dequeue()); // 2
        System.out.println(fila.dequeue()); // 3
        System.out.println(fila.size());    // 0
        System.out.println(fila.isEmpty()); // true

        // --- enqueue após esvaziar (testa se head e tail foram zerados) ---
        fila.enqueue(10);
        fila.enqueue(20);
        System.out.println(fila.first()); // 10
        System.out.println(fila.size());  // 2

        // --- dequeue até sobrar um e checar estado ---
        fila.dequeue();
        System.out.println(fila.first()); // 20
        System.out.println(fila.size());  // 1
        System.out.println(fila.isEmpty()); // false

        // --- remover o último elemento zera a fila ---
        fila.dequeue();
        System.out.println(fila.isEmpty()); // true
        System.out.println(fila.size());    // 0

        // --- exceção no first com fila vazia ---
        try {
            fila.first();
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (FilaEncadeadaVaziaExcecao e) {
            System.out.println("Exceção first ok"); // Exceção first ok
        }

        // --- exceção no dequeue com fila vazia ---
        try {
            fila.dequeue();
            System.out.println("ERRO: deveria ter lançado exceção");
        } catch (FilaEncadeadaVaziaExcecao e) {
            System.out.println("Exceção dequeue ok"); // Exceção dequeue ok
        }

        // --- enqueue depois de exceção ainda funciona ---
        fila.enqueue(99);
        System.out.println(fila.first()); // 99
        System.out.println(fila.size());  // 1
    }
}