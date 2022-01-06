package MetodosLogicos;
import Entidades.*;
import Exceptions.*;
import Estados.*;
import Repositorio.Repositorio;

import java.util.*;

public class ClienteMetodos {
    //testar
    public void RemoveAnimalnMicro(List<Animal> animais, int numMicro) throws RemocaoException {
        boolean found = false;
        Animal animalRemove;
        int j = 0;
        for (Animal a : animais) {
            j++;
            if (a.getnMicro() == numMicro) {
                found = true;
                animalRemove = a;
                break;
            }
        }

        if (found) {
            animais.remove(j);
        }
        else{
            throw new RemocaoException("Este animal não existe");
        }
    }
    //FUNCAO PARA ADICIONAR ANIMAL
    public void addAnimal(Animal newAnimal, List<Animal> animais) throws JaExisteAnimalException {
        boolean found = false;

        for (Animal a : animais) {
            if (newAnimal.getnMicro() == a.getnMicro()) {
                found = true;
                break;
            }
        }
        if (found)
            throw new JaExisteAnimalException("Não pode adicionar animais com o mesmo n microship");

        else
            animais.add(newAnimal);
    }

    public void MarcarConsulta(Date dataHoraMarcacao, Empresa empresa, Animal animal, Consulta newConsulta) throws DataJaExisteException {
        boolean found=false;
        for(Consulta c: Repositorio.getInstance().getConsultas()){
            if(c.getNifEmpresa() == empresa.getNif() && c.getDataMarcacao().equals(dataHoraMarcacao)){
                found=true;
                break;
            }
        }
        if(found){
            throw new DataJaExisteException("A data já existe terá de selecionar outra data");
        }
        else{
            newConsulta.setDataMarcacao(dataHoraMarcacao);
            newConsulta.setEstado(EstadoConsulta.MARCADA);
            Repositorio.getInstance().getConsultas().add(newConsulta);
            //verificar por causa do construtor
        }
    }
}
