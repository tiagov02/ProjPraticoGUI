package Entidades;
import java.util.Iterator;
import java.util.List;
import Exceptions.*;

public class UserCliente extends User {


    public UserCliente(String username, String passwd, String nome, int numCC, int NIF, int telefone, String morada, String localidade) {
        super(username, passwd, nome, numCC, NIF, telefone, morada, localidade);
    }


    public void addAnimal(Animal newAnimal, List<Animal> animais) throws JaExisteAnimalException {
        boolean found = false;
        Iterator var4 = animais.iterator();

        while(var4.hasNext()) {
            Animal a = (Animal)var4.next();
            if (newAnimal.getnMicro() == a.getnMicro()) {
                found = true;
                break;
            }
        }

        if (found) {
            throw new JaExisteAnimalException("Não pode adicionar animais com o mesmo n microship");
        } else {
            animais.add(newAnimal);
        }
    }
}