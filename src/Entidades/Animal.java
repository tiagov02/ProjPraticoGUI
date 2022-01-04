package Entidades;
import java.io.Serializable;
import java.util.*;

public class Animal implements Serializable {
    private int nMicro;
    private String nome;
    private String especie;
    private String raca;
    private Date dataNasc;
    private String userDono;

    public Animal(int nMicro, String nome, String especie, String raca, Date dataNasc, String userDono) {
        this.nMicro = nMicro;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNasc = dataNasc;
        this.userDono=userDono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getnMicro() {
        return nMicro;
    }

    public void setnMicro(int nMicro) {
        this.nMicro = nMicro;
    }

    public String getUserDono() {
        return userDono;
    }

    public void setUserDono(String userDono) {
        this.userDono = userDono;
    }
}
