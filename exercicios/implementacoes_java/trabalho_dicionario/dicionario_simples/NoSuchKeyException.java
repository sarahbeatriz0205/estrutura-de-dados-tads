package dicionario_simples;

public class NoSuchKeyException extends RuntimeException{
    public NoSuchKeyException(String err){
        super(err);
    }
}
