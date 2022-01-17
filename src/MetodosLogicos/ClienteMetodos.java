package MetodosLogicos;
import Entidades.*;
import Exceptions.*;
import Estados.*;
import Repositorio.*;

import java.util.*;

public class ClienteMetodos {
    //testar
    public static void RemoveAnimalnMicro(List<Animal> animais, int numMicro) throws RemocaoException {
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
    public static void addAnimal(Animal newAnimal, List<Animal> animais) throws JaExisteAnimalException {
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

    public static void marcarConsulta(Consulta novaConsulta)throws DataJaExisteException{
        boolean found= false;
        for(Consulta c: Repositorio.getInstance().getConsultas()){
            if(c.getNifEmpresa()==novaConsulta.getNifEmpresa()){
                if(c.getDataMarcacao().equals(novaConsulta.getDataMarcacao())){
                    found=true;
                    break;
                }
            }

        }
        if(found)
            throw new DataJaExisteException("Esta data já se encontra marcada pf selecione outra");
        else {
            Repositorio.getInstance().getConsultas().add(novaConsulta);
            RepositorioSerializable.writeConsultas();
        }
    }

    public static Consulta selectConsultaAPagar(int nMicro){
        for(Consulta c: Repositorio.getInstance().getConsultas()){
            if(c.getnMicro() == nMicro && c.getEstado().equals(EstadoConsulta.EFEUADA)){
                return c;
            }
        }
        return null;
    }

    public static void pagaConsulta(Consulta c){
        for(Consulta con: Repositorio.getInstance().getConsultas()){
           if(con.equals(c)) {
               con.setEstado(EstadoConsulta.CONCLUIDA);
               con.setDataHoraPagamento(new Date());
           }
        }
        Pagamento p= new Pagamento(new Date(),Repositorio.getInstance().getCurrentUser().getUsername(),c.getNifEmpresa());
        RepositorioSerializable.writeConsultas();
    }
}