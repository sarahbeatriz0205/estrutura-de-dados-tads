package arvore_binaria;

public class TesteTreeSort {

    public static void main(String[] args) {

       /*  Integer[] numeros = {
            50, 25, 75, 12, 37, 62, 87, 6, 18, 31, 43, 56, 68, 81, 93, 3, 9, 15, 21, 28, 
            34, 40, 46, 53, 59, 65, 71, 78, 84, 90, 96, 1, 4, 7, 10, 13, 16, 19, 22, 24, 
            27, 30, 33, 36, 39, 42, 45, 48, 52, 55, 58, 61, 64, 67, 70, 73, 77, 80, 83, 86, 
            89, 92, 95, 98, 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 
            49, 51, 54, 57, 60, 63, 66, 69, 72, 74, 76, 79, 82, 85, 88, 91, 94, 97, 99, 100
        };
        */
       
      Integer[] numeros = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
            61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 
            81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100
        };

        TreeSort treeSort = new TreeSort(numeros);
        try {
            long tempoInicio = System.nanoTime();

            treeSort.insert();
            treeSort.ordenar();
            Integer[] ordenado = treeSort.mostrarOrdenada();

            long tempoFinal = System.nanoTime();
            double duracaoMilissegundos = (tempoFinal - tempoInicio) / 1_000_000.0;

            System.out.println("Vetor original:");
            for (Integer n : numeros) {
                System.out.print(n + " ");
            }

            System.out.println("\n");

            System.out.println("Vetor ordenado:");
            for (Integer n : ordenado) {
                System.out.print(n + " ");
            }
            
            System.out.println("\n");
            System.out.printf("Tempo de execução em milissegundos: %.4f ms\n", duracaoMilissegundos);

        } catch (ArvoreExcecao e) {
            e.printStackTrace();
        }
    }    
}