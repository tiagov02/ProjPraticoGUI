package MetodosLogicos;
import Entidades.*;
import Exceptions.*;
import Estados.*;
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

    public void MarcarConsulta(Date dataHoraMarcacao, Empresa empresa) throws DataJaExisteException{
        boolean found=false;
        Consulta newConsulta= new Consulta();
        for(Consulta c: empresa.getConsultas()){
            if(c.getDataMarcacao().equals(dataHoraMarcacao)){
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
            empresa.getConsultas().add(newConsulta);
        }
    }

    public void listaConsultas(List<Consulta> consultas, String Cliente){
        int contador = 0;
        if (consultas.size() > 0){
            for (contador=0; contador < consultas.size(); contador++);
            System.out.println("Consulta: " + contador + 1 + ":");
            consultas.get(contador).getTipoConsulta();
            consultas.get(contador).getDataMarcacao();
            consultas.get(contador).getDataHoraConsulta();
            consultas.get(contador).getPrecoTotal();
            consultas.get(contador).getEstado();
            consultas.get(contador).getDataHoraPagamento();
        }
        else{
            System.out.println("Não existem consultas!");
        }
    }

    public void listaPagamentos(List<Pagamento> pagamentos, String Cliente){
        int contador = 0;
        if (pagamentos.size() > 0){
            for (contador=0; contador < pagamentos.size(); contador++);
            System.out.println("Pagamnetos: " + contador + 1 + ":");
            pagamentos.get(contador).getIdPagamento();
            pagamentos.get(contador).getNumCliente();
            pagamentos.get(contador).getHoraPagamento();
        }
        else{
            System.out.println("Como não existem consultas também não existem pagamentos!");
        }
    }



}
