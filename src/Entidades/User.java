package Entidades;

public class User {
    private String username;
    private String passwd;
    private String nome;
    private int NumCC;
    private int NIF;
    private int telefone;
    private String morada;
    private String Localidade;


    public User(String username, String passwd, String nome, int numCC, int NIF, int telefone, String morada, String localidade) {
        this.username = username;
        this.passwd = passwd;
        this.nome = nome;
        NumCC = numCC;
        this.NIF = NIF;
        this.telefone = telefone;
        this.morada = morada;
        Localidade = localidade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumCC() {
        return NumCC;
    }

    public void setNumCC(int numCC) {
        NumCC = numCC;
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return Localidade;
    }

    public void setLocalidade(String localidade) {
        Localidade = localidade;
    }
}