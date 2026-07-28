package dicionario_simples;

public class TesteDicionarioHash {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Testes: Tabela Hash (Endereçamento Aberto) ---");
        
        
        int tamanhoTabela = 5;
        IDicionario dic = new Dicionario(tamanhoTabela); 

        Item item1 = new Item(10, "Valor A (Chave 10)");
        Item item2 = new Item(15, "Valor B (Chave 15 - Colisão 1)");
        Item item3 = new Item(20, "Valor C (Chave 20 - Colisão 2)");
        Item item4 = new Item(33, "Valor D (Chave 33)");
        Item item5 = new Item(44, "Valor E (Chave 44)");

        System.out.println("\n--- Testando Inserções (Forçando Colisões) ---");
        try {
            dic.insertElement(item1);
            System.out.println("Inserido: Chave 10");
            
            dic.insertElement(item2); 
            System.out.println("Inserido: Chave 15 (Tratou colisão)");
            
            dic.insertElement(item3); 
            System.out.println("Inserido: Chave 20 (Tratou segunda colisão)");
            
            dic.insertElement(item4);
            dic.insertElement(item5);
            System.out.println("Tabela cheia! Tamanho atual: " + dic.size()); 
            
        } catch (Exception e) {
            System.out.println("ERRO na inserção: " + e.getMessage());
            e.printStackTrace();
        }

        
        System.out.println("\n--- Testando Buscas em Itens Colididos ---");
        System.out.println("Busca Chave 15: " + dic.findElement(item2)); 
        System.out.println("Busca Chave 20: " + dic.findElement(item3)); 

        System.out.println("\n--- Testando Limite de Capacidade (Tentando Inserir o 6º Item) ---");
        Item itemExtra = new Item(99, "Tentativa Extra");
        try {
            dic.insertElement(itemExtra);
            System.out.println("Aviso: A tabela aceitou mais elementos do que o tamanho inicial (pode ter redimensionado).");
            System.out.println("Novo tamanho: " + dic.size());
        } catch (Exception e) {
            System.out.println("Comportamento esperado para tabela cheia: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        
        System.out.println("\n--- Testando Remoção e Busca Pós-Remoção ---");
        Object removido = dic.removeElement(item2); 
        System.out.println("Removido Chave 15: " + removido);
        
        System.out.println("Busca Chave 20 após remover Chave 15: " + dic.findElement(item3)); 

        System.out.println("\n--- Fim dos Testes ---");
    }
}