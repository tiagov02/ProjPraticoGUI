package Entidades;
import java.util.Iterator;
import java.util.List;
import Exceptions.*;

public class UserCliente extends User {


    public UserCliente(String username, String passwd, String nome, int numCC, int NIF, int telefone, String morada, String localidade) {
        super(username, passwd, nome, numCC, NIF, telefone, morada, localidade);
    }
}