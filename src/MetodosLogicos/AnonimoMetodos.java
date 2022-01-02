package MetodosLogicos;
import java.util.*;
import Entidades.*;
import Exceptions.JaExisteUserEcxeption;

public class AnonimoMetodos {
    public void addUser(List <User> users, User newU) throws JaExisteUserEcxeption {
        boolean found=false;
        for(User u: users){
            if(u.getUsername().equals(newU.getUsername())){
                found=true;
                break;
            }
        }
        if(!found)
            users.add(newU);
        else
            throw new JaExisteUserEcxeption("Este user já existe não é possivel criar um com os mesmos dados!");
    }
}
