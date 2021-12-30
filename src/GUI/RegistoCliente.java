package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public RegistoCliente(JFrame frame){
        frame = new JFrame("Registo de Clientes");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        //RegAnonimo.setResizable(false);

        frame.add(regClientePanel);
        frame.pack();
        frame.setVisible(true);
        registarCliente();
        limparDados();
    }

    public void registarCliente(){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lerDadosTeclado();
            }
        });
    }
    public void lerDadosTeclado(){
        String username=tb_username.getText();
        String passwd=tb_passwd.getText();
        String nome=tb_nome.getText();
        int numCC=Integer.parseInt(tb_numCC.getText());
        int telefone= Integer.parseInt(tb_telefone.getText());
        String morada=tb_morada.getText();
        String localidade=tb_localidade.getText();
        int cPostal= Integer.parseInt(tb_codPostal.getText());
        //System.out.println(username+"\n"+passwd+"\n"+nome+"\n"+numCC+"\n"+telefone+"\n"+morada+"\n"+localidade+"\n"+cPostal);
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
                tb_numCC.setText(null);
                tb_telefone.setText(null);
                tb_passwd.setText(null);
            }
        });
    }

}
