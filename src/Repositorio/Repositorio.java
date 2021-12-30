package Repositorio;
import java.io.Serializable;
import java.util.*;
import Entidades.*;

//Classe serializavel para persistencia de dados?? DUVIDA

public class Repositorio implements Serializable{
    private List<User> users;
    private List<Empresa> empresas;
    private Map<Integer,ProdutoServico> produtos;
    private List<Animal> animais;
    private List<UserCliente> clientes;
    private Map<String,Empresa> empresasLocalidade;
    private Map<TipoConsulta,Empresa> empresasTipo;


    //Função para ler de ficheiro de texto e iniciar as listas com os devidos valores-- writeObject e readObject
    //Função para escrever em ficheiro de texto, a cada mudança--> Declarada na classe main ou serializar repositório??


    public Repositorio(){
        users=new ArrayList<>();
        empresas=new ArrayList<>();
        produtos= new HashMap<>();
        animais= new ArrayList<>();
        clientes = new ArrayList<>();
        empresasLocalidade=new HashMap<>();
        empresasTipo= new HashMap<>();
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

    public Map<String, Empresa> getEmpresasLocalidade() {
        return empresasLocalidade;
    }

    public void setEmpresasLocalidade(Map<String, Empresa> empresasLocalidade) {
        this.empresasLocalidade = empresasLocalidade;
    }

    public List<UserCliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<UserCliente> clientes) {
        this.clientes = clientes;
    }

    public Map<TipoConsulta, Empresa> getEmpresasTipo() {
        return empresasTipo;
    }

    public void setEmpresasTipo(Map<TipoConsulta, Empresa> empresasTipo) {
        this.empresasTipo = empresasTipo;
    }

    //para testes

    /*public void printUsers(){
        for(User u: this.users){
            System.out.println("nome: " + u.getUsername());
            System.out.println("password: "+u.getPasswd());
        }
    }*/
}
