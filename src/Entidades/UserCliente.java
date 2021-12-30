package Entidades;
import java.util.Iterator;
import java.util.List;
import Exceptions.*;

public class UserCliente extends User {
    private int numCliente;
    private int cPostal;
    private int nCliente;

    public UserCliente(String username, String passwd, String nome, int numCC, int NIF, int telefone, String morada, String localidade, int numCliente, int cPostal, int nCliente) {
        super(username, passwd, nome, numCC, NIF, telefone, morada, localidade);
        this.numCliente = numCliente;
        this.cPostal = cPostal;
        this.nCliente = nCliente;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public int getcPostal() {
        return cPostal;
    }

    public void setcPostal(int cPostal) {
        this.cPostal = cPostal;
    }

    public int getnCliente() {
        return nCliente;
    }

    public void setnCliente(int nCliente) {
        this.nCliente = nCliente;
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