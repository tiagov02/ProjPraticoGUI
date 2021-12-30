package Entidades;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.Scanner;
public class UserFuncionario extends User {
    private float salario;
    private Time horaIni;
    private Time horaFim;
    private int NumFuncionario;

    public UserFuncionario(String username, String passwd, String nome, int numCC, int numFiscal, int telefone, String morada, String localidade, float salario, Time horaIni, Time horaFim, int numFuncionario) {
        super(username, passwd, nome, numCC, numFiscal, telefone, morada, localidade);
        this.salario = salario;
        this.horaIni = horaIni;
        this.horaFim = horaFim;
        NumFuncionario = numFuncionario;
    }

    public int MenuFuncionario(int opcao){
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println("*                    MENU FUNCIONARIO                          *");
        System.out.println("****************************************************************");
        System.out.println("*                                                              *");
        System.out.println("* 1 - Consultar marcações                                      *");
        System.out.println("* 2 - Adicionar produtos ou serviços a uma consulta            *");
        System.out.println("* 3 - Adicionar Dados Diagnosticos referentes a uma consulta   *");
        System.out.println("* 0 - Sair                                                     *");
        System.out.println("*                                                              *");
        System.out.println("****************************************************************");
        return opcao;
    }
}