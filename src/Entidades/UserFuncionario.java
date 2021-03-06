package Entidades;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.Scanner;
public class UserFuncionario extends User {
    private float salario;
    private Time horaIni;
    private Time horaFim;
    private int nifEmpresa;
    private static final long serialVersionsUID = 213321312321233L;


    public UserFuncionario(String username, String passwd, String nome, int numCC, int numFiscal, int telefone, String morada, String localidade, float salario, Time horaIni, Time horaFim, int nifEmpresa) {
        super(username, passwd, nome, numCC, numFiscal, telefone, morada, localidade);
        this.salario = salario;
        this.horaIni = horaIni;
        this.horaFim = horaFim;
        this.nifEmpresa=nifEmpresa;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Time getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(Time horaIni) {
        this.horaIni = horaIni;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public int getNifEmpresa() {
        return nifEmpresa;
    }
}