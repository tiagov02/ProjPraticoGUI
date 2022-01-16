package MetodosLogicos;

import Entidades.Empresa;
import Entidades.TipoConsulta;
import Exceptions.AlteracaoDadosException;
import Exceptions.JaExisteTipoConsultaExcpetion;
import Repositorio.Repositorio;
import Repositorio.*;

import java.util.List;
import java.util.Map;

public class AdminMetodos {
    public static void alterarDadosEmpresa(Empresa empresa) throws AlteracaoDadosException {
        for (Empresa emp: Repositorio.getInstance().getEmpresas()){
            if (emp.getNif()==empresa.getNif()){
                emp.setTelefone(emp.getTelefone());
                emp.setNomeEmpresa(emp.getNomeEmpresa());
                emp.setNif(emp.getNif());
                emp.setnPorta(emp.getnPorta());
                emp.setLocalidade(emp.getLocalidade());
                RepositorioSerializable.writeEmpresas();
                RepositorioSerializable.writeEmpresasTipo();
                RepositorioSerializable.writeEmpresasLocalidade();
                return;
            }
        }
        throw new AlteracaoDadosException("Não é possivel alterar o NIF de uma empresa.");
    }

    public static Empresa AdminselectEmpresaporNif(int nifEmpresa) {
        for(Empresa e: Repositorio.getInstance().getEmpresas()){
                return e;
            }
        return null;
    }

    public static Empresa selectEmpresaNIF(int nif){
        for (Empresa emp: Repositorio.getInstance().getEmpresas()){
            if (emp.getNif() == nif){
                return emp;
            }
        }
        return null;
    }

    public static void removeEmpresa(Empresa emp){
        Repositorio.getInstance().getEmpresas().remove(emp);
    }

    public static void addTipoConsulta(TipoConsulta tipoconsulta) throws JaExisteTipoConsultaExcpetion {
        for (TipoConsulta t : Repositorio.getInstance().getTiposConsultas()){
            if (tipoconsulta.getDescricao().equals(t.getDescricao())){
                throw new JaExisteTipoConsultaExcpetion("Não pode inserir tipos de consulta com a mesma descricao");
            }
        }
        addTipoConsultaNaList(tipoconsulta);
    }
    public static void addTipoConsultaNaList(TipoConsulta tipo){
        Repositorio.getInstance().getTiposConsultas().add(tipo);
    }



    public static TipoConsulta selecionarTiposConsulta(int id){
        for (TipoConsulta tipo : Repositorio.getInstance().getTiposConsultas()){
            if (tipo.getIdTipo() == id){
                return tipo;
            }
        }
        return null;
    }

    public static void alterarDadosTipoConsulta(TipoConsulta tipoConsulta) throws AlteracaoDadosException{
        for(TipoConsulta tipo : Repositorio.getInstance().getTiposConsultas()){
            if (tipo.getDescricao().equals(tipoConsulta.getDescricao())){
                tipo.setDescricao(tipo.getDescricao());
                tipo.setPrecoEsp(tipo.getPrecoEsp());
                return;
            }
        }
    }
}
