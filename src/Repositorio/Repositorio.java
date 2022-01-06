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
    private Map<String,Empresa> empresasLocalidade;
    private Map<TipoConsulta,Empresa> empresasTipo;
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
    } //fazer igual para todo o resto

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

    public Map<String, Empresa> getEmpresasLocalidade() {
        return empresasLocalidade;
    }

    public void setEmpresasLocalidade(Map<String, Empresa> empresasLocalidade) {
        this.empresasLocalidade = empresasLocalidade;
    }

    public Map<TipoConsulta, Empresa> getEmpresasTipo() {
        return empresasTipo;
    }

    public void setEmpresasTipo(Map<TipoConsulta, Empresa> empresasTipo) {
        this.empresasTipo = empresasTipo;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
