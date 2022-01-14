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
    private String userDono;
    private TipoConsulta tipo;

    public Empresa(int telefone, String nomeEmpresa, int nif, int nPorta, String localidade, String userDono) {
        this.telefone = telefone;
        this.nomeEmpresa = nomeEmpresa;
        this.nif = nif;
        this.nPorta = nPorta;
        this.localidade = localidade;
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

    public String getUserDono() {
        return userDono;
    }

    public void setUserDono(String userDono) {
        this.userDono = userDono;
    }

    public TipoConsulta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConsulta tipo) {
        this.tipo = tipo;
    }
}
