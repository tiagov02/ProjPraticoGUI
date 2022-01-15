package MetodosLogicos;

import Entidades.Empresa;
import Exceptions.AlteracaoDadosException;
import Repositorio.Repositorio;
import Repositorio.*;

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
}
