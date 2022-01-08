package MetodosLogicos;

import Entidades.*;
import Exceptions.*;
import Repositorio.Repositorio;

public class UserMetodos {
    public void RemoveUser(User user) throws RemocaoException{
        boolean sucesso= Repositorio.getInstance().getUsers().remove(user);
        if(!sucesso){
            throw new RemocaoException("O utilizador que pretende remover NÃO existe!!");
        }
        else
            return;
    }
}
