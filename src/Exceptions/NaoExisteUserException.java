package Exceptions;
public class NaoExisteUserException extends Exception {
    public NaoExisteUserException(String mensagem){
        super(mensagem);
    }

}
