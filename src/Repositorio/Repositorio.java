package Repositorio;
import java.io.Serializable;
import java.util.*;
import Entidades.*;



public class Repositorio implements Serializable{
    private List<User> users;
    private List<Empresa> empresas;
    private Map<Integer,ProdutoServico> produtos;
    private List<Animal> animais;
    //private List<UserCliente> clientes;
    private Map<Empresa,String> empresasLocalidade;
    private Map<Empresa,TipoConsulta> empresasTipo;
    private List <Consulta> consultas;
    private static Repositorio singleinstance;
    private User currentUser;



    public Repositorio(){
        users=new ArrayList<>();
        empresas=new ArrayList<>();
        produtos= new HashMap<>();
        animais= new ArrayList<>();
        empresasLocalidade=new HashMap<>();
        empresasTipo= new HashMap<>();
        consultas= new ArrayList<>();
    }

    public static Repositorio getInstance(){
        if (singleinstance == null){
            singleinstance = new Repositorio();
        }
        return singleinstance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Map<Integer, ProdutoServico> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<Integer, ProdutoServico> produtos) {
        this.produtos = produtos;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public Map<Empresa, String> getEmpresasLocalidade() {
        return empresasLocalidade;
    }

    public void setEmpresasLocalidade(Map<Empresa, String> empresasLocalidade) {
        this.empresasLocalidade = empresasLocalidade;
    }

    public Map<Empresa, TipoConsulta> getEmpresasTipo() {
        return empresasTipo;
    }

    public void setEmpresasTipo(Map<Empresa, TipoConsulta> empresasTipo) {
        this.empresasTipo = empresasTipo;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
