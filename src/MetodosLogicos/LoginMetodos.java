package MetodosLogicos;
import java.util.*;
import Entidades.*;
import Estados.*;
import Exceptions.*;
import GUI.*;
import Repositorio.*;

public class LoginMetodos {

    public LoginMetodos(){}

    public User Login( String nomeUser, String pass) throws NaoExisteUserException{
        User newUser = new User();
        //boolean found = false;

        newUser.setUsername(nomeUser);
        newUser.setPasswd(pass);

        for(User u: Repositorio.getInstance().getUsers()){
            if(newUser.getUsername().equals(u.getUsername()) && newUser.getPasswd().equals(u.getPasswd())){
                Repositorio.getInstance().setCurrentUser(u);
                return u;
            }
        }
        throw new NaoExisteUserException("Dados inválidos! Pf tente novamente");
    }
}
