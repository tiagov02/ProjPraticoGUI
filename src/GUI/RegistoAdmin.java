package GUI;

import Entidades.UserAdmin;
import Entidades.UserCliente;
import Exceptions.JaExisteEmpresaException;
import Exceptions.JaExisteUserEcxeption;
import MetodosLogicos.AnonimoMetodos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistoAdmin {
    private JPanel panel;
    private JTextField tb_username;
    private JPasswordField tb_passwd;
    private JTextField tb_nome;
    private JTextField tb_numCC;
    private JTextField tb_nif;
    private JTextField tb_telefone;
    private JTextField tb_morada;
    private JTextField tb_localidade;
    private JButton OKButton;
    private JButton backButton;

    public RegistoAdmin(JFrame frame){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        voltar(frame);
        clickOK(frame);
    }

    public void clickOK(JFrame frame){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numCC=0,telefone=0, nif=0;
                String username=tb_username.getText();
                String passwd=tb_passwd.getText();
                String nome=tb_nome.getText();
                try{
                    numCC=Integer.parseInt(tb_numCC.getText());
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Não pode introduzir letras no numero de CC");
                }
                try{
                    telefone= Integer.parseInt(tb_telefone.getText());
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Não pode introduzir letras no telefone");
                }
                String morada=tb_morada.getText();
                String localidade=tb_localidade.getText();
                nif=Integer.parseInt(tb_nif.getText());
                try{
                    nif=Integer.parseInt(tb_nif.getText());
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Não pode introduzir letras no nif");
                }
                UserAdmin user= new UserAdmin(username,passwd,nome,numCC,nif,telefone,morada,localidade);
                try{
                    AnonimoMetodos.addUser(user);
                }
                catch (JaExisteUserEcxeption ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public void voltar(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new AdminRegistado(frame);
            }
        });
    }
}
