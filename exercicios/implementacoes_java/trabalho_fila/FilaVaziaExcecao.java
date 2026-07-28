package exercicios.trabalho_fila;

public class FilaVaziaExcecao extends RuntimeException{
    public FilaVaziaExcecao(String err){
        super(err);
    }
}