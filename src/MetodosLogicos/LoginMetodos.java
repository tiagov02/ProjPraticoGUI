package MetodosLogicos;
import java.util.*;
import Entidades.*;
import Estados.*;
import Exceptions.*;
import GUI.*;
import Repositorio.*;

public class LoginMetodos {

    public LoginMetodos(){}

    public User Login(String pass, String nomeUser,List<User> users) throws NaoExisteUserException{
        User newUser = new User();
        boolean found = false;

        newUser.setUsername(nomeUser);
        newUser.setPasswd(pass);

        for(User u: users){
            if(newUser.getUsername().equals(u.getUsername()) && newUser.getPasswd().equals(u.getPasswd())){
                found=true;
                return u;
            }
        }
        throw new NaoExisteUserException("A sua pass ou user estão errados! pf tente novamente");
    }
}
