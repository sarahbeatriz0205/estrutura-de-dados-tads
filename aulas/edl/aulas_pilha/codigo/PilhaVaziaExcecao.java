package aulas_pilha.codigo;
// Classe de exceção personalizada para sinalizar quando a pilha está vazia
public class PilhaVaziaExcecao extends RuntimeException{
    // Construtor que recebe a mensagem de erro
    public PilhaVaziaExcecao(String error){
        // Chama o construtor da classe pai (RuntimeException) com a mensagem
        super(error);
    }
}

// public class PilhaVaziaExcecao extends RuntimeException: Declara uma classe pública que herda de RuntimeException
// Essa exceção é "unchecked" que não precisa ser declarada ou capturada obrigatoriamente