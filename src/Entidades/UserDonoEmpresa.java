package Entidades;
import java.io.IOException;
import java.util.*;

public class UserDonoEmpresa extends User {

    private static final long serialVersionsUID = 1231232134345L;


    public UserDonoEmpresa(String username, String passwd, String nome, int numCC, int NIF, int telefone, String morada, String localidade) {
        super(username, passwd, nome, numCC, NIF, telefone, morada, localidade);
    }

}

