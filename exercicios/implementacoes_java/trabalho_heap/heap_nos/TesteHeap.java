package heap_nos;

public class TesteHeap {

    public static void main(String[] args) {

        HeapNos heap = new HeapNos(new Item(10, "A"));

        System.out.println("=== Estado inicial ===");
        System.out.println("Tamanho: " + heap.size());
        System.out.println("Min: " + heap.min().key());

        heap.insert(new Item(5, "B"));
        heap.insert(new Item(20, "C"));
        heap.insert(new Item(3, "D"));
        heap.insert(new Item(8, "E"));
        heap.insert(new Item(15, "F"));

        System.out.println("\n=== Após inserções ===");
        System.out.println("Tamanho: " + heap.size());
        System.out.println("Min: " + heap.min().key());

        System.out.println("\n=== Removendo em ordem ===");

        while (heap.size() > 1) {
            Item removido = heap.removeMin();

            System.out.println(
                "Removido: " + removido.key()
                + " | Novo min: " + heap.min().key()
                + " | Tamanho: " + heap.size()
            );
        }

        System.out.println("\n=== Último elemento ===");
        System.out.println("Min: " + heap.min().key());
        System.out.println("Tamanho: " + heap.size());

        HeapNos heap_teste = new HeapNos(new Item(50, "A"));

        heap_teste.insert(new Item(30, "B"));
        heap_teste.insert(new Item(70, "C"));
        heap_teste.insert(new Item(10, "D"));
        heap_teste.insert(new Item(40, "E"));
        heap_teste.insert(new Item(20, "F"));
        heap_teste.insert(new Item(60, "G"));
        heap_teste.insert(new Item(5, "H"));

        System.out.println("Min esperado: 5");
        System.out.println("Min obtido: " + heap_teste.min().key());

        System.out.println("\nOrdem de remoção esperada:");
        System.out.println("5 10 20 30 40 50 60 70");

        System.out.println("\nOrdem obtida:");

        while (heap_teste.size() > 1) {
            System.out.print(heap_teste.removeMin().key() + " ");
        }

        System.out.print(heap_teste.min().key());
    }
}