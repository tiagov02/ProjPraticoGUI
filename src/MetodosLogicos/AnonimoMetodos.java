package MetodosLogicos;
import java.util.*;
import Entidades.*;
import Exceptions.JaExisteUserEcxeption;
import Repositorio.*;

public class AnonimoMetodos {
    public void addUser(User newU) throws JaExisteUserEcxeption {
        boolean found=false;
        for(User u: Repositorio.getInstance().getUsers()){
            if(u.getUsername().equals(newU.getUsername())){
                found=true;
                break;
            }
        }
        if(!found){
            Repositorio.getInstance().getUsers().add(newU);
            RepositorioSerializable.writeUsers();
        }
        else
            throw new JaExisteUserEcxeption("Este user já existe não é possivel criar um com os mesmos dados!");
    }
}
