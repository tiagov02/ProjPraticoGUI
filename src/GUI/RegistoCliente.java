package GUI;

import Entidades.*;
import Entidades.UserCliente;
import Exceptions.JaExisteUserEcxeption;
import MetodosLogicos.AnonimoMetodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegistoCliente extends JFrame{
    //private JFrame frame;
    private JPanel regClientePanel;
    private JTextField tb_morada;
    private JTextField tb_localidade;
    private JTextField tb_codPostal;
    private JTextField tb_telefone;
    private JTextField tb_numCC;
    private JTextField tb_nome;
    private JPasswordField tb_passwd;
    private JTextField tb_username;
    private JLabel lb_morada;
    private JLabel lb_localidade;
    private JLabel lb_codPostal;
    private JLabel lb_telefone;
    private JLabel lb_numCC;
    private JLabel lb_nome;
    private JLabel lb_passwd;
    private JLabel lb_username;
    private JButton okButton;
    private JButton limparButton;
    private JTextField tb_nif;
    private JButton backButton;
    private AnonimoMetodos metodos;

    public RegistoCliente(JFrame frame){
        frame = new JFrame("Registo de Clientes");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        metodos=new AnonimoMetodos();

        frame.add(regClientePanel);
        frame.pack();
        frame.setVisible(true);
        registarCliente(frame);
        limparDados();
        voltarParaTras(frame);
    }

    public void registarCliente(JFrame frame){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=tb_username.getText();
                String passwd=tb_passwd.getText();
                String nome=tb_nome.getText();
                int numCC=Integer.parseInt(tb_numCC.getText());
                int telefone= Integer.parseInt(tb_telefone.getText());
                String morada=tb_morada.getText();
                String localidade=tb_localidade.getText();
                int cPostal= Integer.parseInt(tb_codPostal.getText());
                int nif=Integer.parseInt(tb_nif.getText());
                UserCliente user= new UserCliente(username,passwd,nome,numCC,nif,telefone,morada,localidade);
                try {
                    metodos.addUser(user);
                    JOptionPane.showMessageDialog(null,"Adicionou um cliente com sucesso!!");
                    regClientePanel.setVisible(false);
                    new Login(frame);
                }
                catch (JaExisteUserEcxeption ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public void limparDados(){
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tb_codPostal.setText(null);
                tb_localidade.setText(null);
                tb_username.setText(null);
                tb_morada.setText(null);
                tb_nome.setText(null);
                tb_nif.setText(null);
                tb_numCC.setText(null);
                tb_telefone.setText(null);
                tb_passwd.setText(null);
            }
        });
    }

    public void voltarParaTras(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regClientePanel.setVisible(false);
                new RegistoAnonimo(frame);
            }
        });
    }

}
