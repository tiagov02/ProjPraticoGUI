package GUI;

import Entidades.Empresa;
import Entidades.User;
import Entidades.UserFuncionario;
import Exceptions.JaExisteUserEcxeption;
import MetodosLogicos.AnonimoMetodos;
import MetodosLogicos.DonoEmpresaMetodos;
import Repositorio.Repositorio;
import Repositorio.RepositorioSerializable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.*;
import java.util.Timer;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RegistoFuncionario extends JFrame {
    private JTextField tb_numCC;
    private JTextField tb_nif;
    private JTextField tb_telefone;
    private JTextField tb_morada;
    private JTextField tb_username;
    private JPasswordField tb_password;
    private JTextField tb_localidade;
    private JTextField tb_salario;
    private JSpinner spn_minInicio;
    private JSpinner spn_horInicio;
    private JSpinner spn_horFim;
    private JSpinner spn_minFim;
    private JPanel panel;
    private JButton buttonback;
    private JButton buttonLimpar;
    private JButton buttonok;
    private JTextField Nome_tb;
    private JComboBox comboBox1;
    private AnonimoMetodos metodos;

    public RegistoFuncionario(JFrame frame){
        metodos= new AnonimoMetodos();
        frame = new JFrame("Registo de Funcionario");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));


        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        spn_horInicio.setModel(new SpinnerNumberModel(1,0,23,1));
        spn_minInicio.setModel(new SpinnerNumberModel(1,0,59,1));

        spn_horFim.setModel(new SpinnerNumberModel(1,0,23,1));
        spn_minFim.setModel(new SpinnerNumberModel(1,0,59,1));
        for (Empresa e : Repositorio.getInstance().getEmpresas()) {
            if(e.getUserDono().equals(Repositorio.getInstance().getCurrentUser().getUsername())){
                comboBox1.addItem(e.getNomeEmpresa());
            }
        }

        LimparDados();
        VoltaAtras(frame);
        InsereFuncionario(frame);
    }

    public void LimparDados(){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tb_username.setText(null);
                tb_password.setText(null);
                Nome_tb.setText(null);
                tb_numCC.setText(null);
                tb_telefone.setText(null);
                tb_morada.setText(null);
                tb_localidade.setText(null);
                tb_salario.setText(null);
            }
        });
    }

    public void VoltaAtras(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }

    public void InsereFuncionario(JFrame frame){
        buttonok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tb_username.getText();
                String password = tb_password.getText();
                String nome = Nome_tb.getText();
                int numCC=Integer.parseInt(tb_numCC.getText());
                int NIF=Integer.parseInt(tb_nif.getText());
                int telefone=Integer.parseInt(tb_telefone.getText());
                String morada = tb_morada.getText();
                String localidade = tb_localidade.getText();
                float salario = Float.parseFloat(tb_salario.getText());
                int horainicio = (int) spn_horInicio.getValue();
                int horafim = (int) spn_horFim.getValue();
                int minini = (int) spn_minInicio.getValue();
                int minfim = (int) spn_minFim.getValue();
                String nomeEmpresa = (String)comboBox1.getSelectedItem();
                Empresa emp=DonoEmpresaMetodos.selectEmpresa(nomeEmpresa);
                UserFuncionario funcionario = new UserFuncionario(username, password, nome, numCC, NIF, telefone, morada, localidade, salario
                        ,new Time(horainicio,minini,0), new Time(horafim,minfim,0),emp.getNif());

                try {
                    metodos.addUser(funcionario);
                    JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso!");
                    panel.setVisible(false);
                    new DonoEmpresaRegistado(frame);
                }
                catch (JaExisteUserEcxeption ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
}

