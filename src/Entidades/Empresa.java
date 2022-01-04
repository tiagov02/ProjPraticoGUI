package Entidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa implements Serializable {
    private int telefone;
    private String nomeEmpresa;
    private int nif;
    private int nPorta;
    private String localidade;
    private int cPostal;
    private List<Consulta> consultas;
    private String userDono;

    public Empresa(int telefone, String nomeEmpresa, int nif, int nPorta, String localidade, int cPostal, String userDono) {
        this.telefone = telefone;
        this.nomeEmpresa = nomeEmpresa;
        this.nif = nif;
        this.nPorta = nPorta;
        this.localidade = localidade;
        this.cPostal = cPostal;
        consultas= new ArrayList<>();
        this.userDono=userDono;
    }


    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getnPorta() {
        return nPorta;
    }

    public void setnPorta(int nPorta) {
        this.nPorta = nPorta;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public int getcPostal() {
        return cPostal;
    }

    public void setcPostal(int cPostal) {
        this.cPostal = cPostal;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public String getUserDono() {
        return userDono;
    }

    public void setUserDono(String userDono) {
        this.userDono = userDono;
    }

    //testes

    /*public void printConsultas(){
        int j=0;
        for(Consulta c: this.consultas){
            j++;
            System.out.println("Consulta: "+ j);
            System.out.println("Data e hora"+ c.getDataMarcacao());
        }
    }*/

    /*public static class UserDonoEmpresa extends JaExisteAnimalException {
        private int opcao=0;

        //Verificar users--> mais atributos necessários

        public UserDonoEmpresa(String user, String passwd, int nif, String nome, int telefone) {
            super(user, passwd);
        }




    public static class UserAdmin extends JaExisteAnimalException.User {
        private int opcao;
        public UserAdmin(String user, String passwd){
            super(user,passwd);
        }



        public int MenuAdmin(int opcao){
            System.out.println();
            System.out.println("******************************************************");
            System.out.println("*                    MENU ADMIN                      *");
            System.out.println("******************************************************");
            System.out.println("*                                                    *");
            System.out.println("* 1 - Listar empresas do sistema                     *");
            System.out.println("* 2 - Alterar e eliminar empresas                    *");
            System.out.println("* 3 - Listar todos pagamentos                        *");
            System.out.println("* 0 - Sair                                           *");
            System.out.println("*                                                    *");
            System.out.println("******************************************************");
            return opcao;
        }
    }*/
}
