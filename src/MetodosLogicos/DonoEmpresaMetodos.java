package MetodosLogicos;
import java.util.List;
import java.util.Map;
import Entidades.*;
import Exceptions.*;
import Repositorio.*;

import javax.swing.*;

public  class DonoEmpresaMetodos {


    public static void removerEmpresa (Empresa empresa,List<Empresa> empresas) throws RemocaoException {
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


    public static void addEmpresa(List<Empresa> empresas,Map<Empresa,String> empresasLocalidade ,Empresa emp)
    throws JaExisteEmpresaException
    {
        for(Empresa e : empresas) {
            if (emp.getNif() == e.getNif() && emp.getNomeEmpresa().equals(e.getNomeEmpresa()) && empresasLocalidade.containsKey(emp)) {
                    throw new JaExisteEmpresaException("Não pode criar empresas com campos iguais");
            }
        }
        addEmpresaList(empresas,emp);
        addEmpresaMapLocalidade(empresasLocalidade,emp);
        addEmpresasMapTipo(Repositorio.getInstance().getEmpresasTipo(), emp);
        RepositorioSerializable.writeEmpresas();
        RepositorioSerializable.writeEmpresasLocalidade();
        RepositorioSerializable.writeEmpresasTipo();
    }

    public static void addEmpresaList(List<Empresa> empresas,Empresa emp){
        empresas.add(emp);
    }

    public static void addEmpresaMapLocalidade(Map<Empresa,String> empresasLocalidade,Empresa emp){
        empresasLocalidade.put(emp, emp.getLocalidade());
    }
    public static void addEmpresasMapTipo(Map<Empresa, TipoConsulta> empresasTipo,Empresa emp){
        empresasTipo.put(emp,emp.getTipo());
    }
    public static void removeFuncionario(int nif, int numCC) throws NaoExisteUserException{
        for(User u: Repositorio.getInstance().getUsers()){
            if(u instanceof UserFuncionario && u.getNIF()==nif && u.getNumCC()==numCC){
                Repositorio.getInstance().getUsers().remove(u);
                return;
            }
        }
        throw new NaoExisteUserException("O user que pretende remover não existe");
    }

    public static Empresa selectEmpresa(String nomeEmpresa) {
        for(Empresa e: Repositorio.getInstance().getEmpresas()){
            if(e.getNomeEmpresa().equals(nomeEmpresa)){
                return e;
            }
        }
        return null;
    }

    public static UserFuncionario selectFuncionarioNifEmpresa(int nif,Empresa e) {
        for(User u:Repositorio.getInstance().getUsers()){
            if(u instanceof UserFuncionario && ((UserFuncionario) u).getNifEmpresa()==e.getNif() && u.getNIF()==nif){
                return (UserFuncionario) u;
            }
        }
       return null;
    }

    public static Empresa selectEmpresaporNif(int nifEmpresa) {
        for(Empresa e: Repositorio.getInstance().getEmpresas()){
            if(e.getNif()==nifEmpresa){
                return e;
            }
        }
        return null;
    }

    public static void alterarDadosFuncionario(UserFuncionario f) throws AlteracaoDadosException{
        for(User u: Repositorio.getInstance().getUsers()){
            if(u instanceof UserFuncionario && u.getNIF()==f.getNIF()){
                u.setTelefone(f.getTelefone());
                u.setTelefone(f.getTelefone());
                u.setNumCC(f.getNumCC());
                ((UserFuncionario) u).setSalario(f.getSalario());
                u.setUsername(f.getUsername());
                u.setPasswd(f.getPasswd());
                u.setNome(f.getNome());
                u.setMorada(f.getMorada());
                u.setLocalidade(f.getLocalidade());
                ((UserFuncionario) u).setHoraIni(f.getHoraIni());
                ((UserFuncionario) u).setHoraFim(f.getHoraFim());
                RepositorioSerializable.writeUsers();
                return;
            }
        }
        throw new AlteracaoDadosException("Não pode alterar o nif do funcionário!! para isso tem de introduzir um funcionario novo");
    }
}
