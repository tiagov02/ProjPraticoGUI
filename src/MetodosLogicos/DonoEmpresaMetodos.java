package MetodosLogicos;
import java.util.List;
import java.util.Map;
import Entidades.*;
import Exceptions.*;
import Repositorio.*;

public class DonoEmpresaMetodos {
    public DonoEmpresaMetodos(){}


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


    public void addEmpresa(List<Empresa> empresas,Map<Empresa,String> empresasLocalidade ,Empresa emp)
    throws JaExisteEmpresaException
    {

        for(Empresa e : empresas) {
            if (emp.getNif() == e.getNif() && emp.getNomeEmpresa().equals(e.getNomeEmpresa()) && empresasLocalidade.containsKey(emp)) {
                    throw new JaExisteEmpresaException("Não pode criar empresas com campos iguais");
            }
            else{
                addEmpresaList(empresas,emp);
                addEmpresaMapLocalidade(empresasLocalidade,emp);
                addEmpresasMapTipo(Repositorio.getInstance().getEmpresasTipo(), emp);
                RepositorioSerializable.writeEmpresas();
                RepositorioSerializable.writeEmpresasLocalidade();
                RepositorioSerializable.writeEmpresasTipo();
            }
        }
    }

    public void addEmpresaList(List<Empresa> empresas,Empresa emp){
        empresas.add(emp);
    }

    public void addEmpresaMapLocalidade(Map<Empresa,String> empresasLocalidade,Empresa emp){
        empresasLocalidade.put(emp, emp.getLocalidade());
    }
    public void addEmpresasMapTipo(Map<Empresa, TipoConsulta> empresasTipo,Empresa emp){
        empresasTipo.put(emp,emp.getTipo());
    }
}
