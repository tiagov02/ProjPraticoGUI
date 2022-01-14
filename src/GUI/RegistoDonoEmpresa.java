package GUI;

import Entidades.User;
import Entidades.UserDonoEmpresa;
import Exceptions.JaExisteUserEcxeption;
import MetodosLogicos.AnonimoMetodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RegistoDonoEmpresa extends Frame {
    private JPanel regDonoEmpresa;
    private JTextField tb_Morada;
    private JTextField tb_Localidade;
    private JTextField tb_numeroCC;
    private JTextField tb_Nome;
    private JTextField tb_user;
    private JTextField tb_NIF;
    private JPasswordField tb_password;
    private JLabel lb_morada;
    private JLabel lb_localidade;
    private JTextField tb_Telefone;
    private JLabel lb_telefone;
    private JLabel lb_numCC;
    private JLabel lb_nome;
    private JLabel lb_passwd;
    private JLabel lb_username;
    private JLabel lb_NIF;
    private JButton okButton;
    private JButton limparButton;
    private JButton botaoVoltar;
    private AnonimoMetodos metodos;

    public RegistoDonoEmpresa(JFrame frame){
        metodos=new AnonimoMetodos();
        frame = new JFrame("Registo Dono Empresa");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        //RegAnonimo.setResizable(false);

        frame.add(regDonoEmpresa);
        frame.pack();
        frame.setVisible(true);
        limparDados();
        VoltarAtras(frame);
        registarDonoEmpresa(frame);
    }

    public void registarDonoEmpresa(JFrame frame){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tb_user.getText();
                String passwd = tb_password.getText();
                String nome = tb_Nome.getText();
                int numCC = Integer.parseInt(tb_numeroCC.getText());
                int NIF = Integer.parseInt(tb_NIF.getText());
                int telefone = Integer.parseInt(tb_Telefone.getText());
                String morada = tb_Morada.getText();
                String localidade = tb_Localidade.getText();
                UserDonoEmpresa user = new UserDonoEmpresa(username, passwd, nome, numCC, NIF, telefone, morada, localidade);
                try {
                    metodos.addUser(user);
                    JOptionPane.showMessageDialog(null, "Dono de Empresa adicionado com sucesso");
                    regDonoEmpresa.setVisible(false);
                    new Login(frame);
                }
                catch (JaExisteUserEcxeption ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
            }
        });
    }

    public void limparDados(){
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tb_Localidade.setText(null);
                tb_user.setText(null);
                tb_Morada.setText(null);
                tb_Nome.setText(null);
                tb_NIF.setText(null);
                tb_numeroCC.setText(null);
                tb_Telefone.setText(null);
                tb_password.setText(null);
            }
        });
    }

    public void VoltarAtras(JFrame frame){
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regDonoEmpresa.setVisible(false);
                new RegistoAnonimo(frame);
            }
        });
    }
}
