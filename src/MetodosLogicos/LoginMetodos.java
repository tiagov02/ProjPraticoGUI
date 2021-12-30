package MetodosLogicos;
import java.util.*;
import Entidades.*;
import Estados.*;
import Exceptions.*;
import GUI.*;
import Repositorio.*;

public class LoginMetodos {

    public LoginMetodos(){}

    public void Login(String pass, String nomeUser) { //throws NaoExisteUserException
        User u = new User();
        boolean found = false;

        u.setUsername(nomeUser);
        u.setPasswd(pass);

        //Redirecionamento

    }
}
