package exercicios.trabalho_vetor.implementacao_array;

public class TesteIVetor {
    public static void main(String[] args) {
        IVetor vetor = new Vetor(10); 

        System.out.println("--- Testando Inserção ---");
        vetor.insertAtRank(0, "A"); // [A]
        vetor.insertAtRank(1, "C"); // [A, C]
        vetor.insertAtRank(1, "B"); // [A, B, C] (o B empurrou o C)
        
        System.out.println("Tamanho após inserções: " + vetor.size()); // Deve ser 3
        System.out.println("Elemento no rank 1: " + vetor.elemAtRank(1)); // Deve ser B

        System.out.println("\n--- Testando Substituição ---");
        Object antigo = vetor.replaceAtRank(2, "Z"); // Troca C por Z
        System.out.println("Era: " + antigo + " | Agora é: " + vetor.elemAtRank(2)); // Z

        System.out.println("\n--- Testando Remoção ---");
        Object removido = vetor.removeAtRank(0); // Remove A
        System.out.println("Removido: " + removido);
        System.out.println("Novo primeiro elemento (rank 0): " + vetor.elemAtRank(0)); // Deve ser B
        System.out.println("Tamanho final: " + vetor.size()); // Deve ser 2

        System.out.println("\n--- Testando Estado ---");
        System.out.println("Está vazio? " + vetor.isEmpty());
    }
}
