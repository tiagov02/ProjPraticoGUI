package MetodosLogicos;
import java.util.List;
import java.util.Map;
import Entidades.*;
import Exceptions.*;

public class DonoEmpresaMetodos {
    public void removerEmpresa (Empresa empresa,List<Empresa> empresas) throws RemocaoException {
        boolean found= false;
        int j=0;
        for(Empresa e: empresas){
            j++;
            if(e.equals(empresa)){
                found= true;
                break;
            }
        }
        if(!found){
            throw new RemocaoException("Não foi encontrada a empresa a remover");
        }
        else {
            empresas.remove(empresa);
        }
    }


    public void addEmpresa(List<Empresa> empresas,Map<String,Empresa> empresasLocalidade ,Empresa emp)
    throws JaExisteEmpresaException
    {
        boolean found= false;
        for(Empresa e : empresas){
            if(emp.getNif()==e.getNif() && emp.getNomeEmpresa().equals(e.getNomeEmpresa())){
                found=true;
                break;
            }
        }
        if(!found){
            addEmpresaList(empresas,emp);
            addEmpresaMap(empresasLocalidade,emp);
        }
        else{
            throw new JaExisteEmpresaException("Não pode criar empresas com campos iguais");
        }
    }

    public void addEmpresaList(List<Empresa> empresas,Empresa emp){
        empresas.add(emp);
    }

    public void addEmpresaMap(Map<String,Empresa> empresasLocalidade,Empresa emp){
        empresasLocalidade.put(emp.getLocalidade(),emp);
    }

    public void listaConsultas(List<Consulta> consultas, UserDonoEmpresa Dono){
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
            System.out.println("De momento não existem consultas na empresa!");
        }
    }
}
