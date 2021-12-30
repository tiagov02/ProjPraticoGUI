package GUI;

import Entidades.User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login extends JFrame{
    private JTextField userTexto;
    private JPanel LoginUsers;
    private JPasswordField passwordTexto;
    private JButton Login;
    private JButton Limpar;
    private JButton Registo;
    private JFrame frame;
    //private User Usermetodos;
    //HashMap<String, String> logininfo = new HashMap<String, String>();




    public Login(){
        frame = new JFrame("Login Utilizador");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setResizable(false);

        frame.add(LoginUsers);
        frame.pack();
        frame.setVisible(true);
       LimpaDados();
    }

    public void ColocaCamposVazios(){
        userTexto.setText("");
        passwordTexto.setText("");
    }

    public void LimpaDados(){
        Limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColocaCamposVazios();
            }
        });
    }

/*
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==Limpar){
            userTexto.setText("");
            passwordTexto.setText("");
        }
        if (e.getSource() == Login){
            String UserID = userTexto.getText();
            String password = String.valueOf(userTexto.getPassword());
        }
        if (logininfo.containsKey(userTexto)) {
            if (logininfo.get(userTexto).equals(passwordTexto)){
                messageLabel.setForeground(Color.green);
                messageLabel.sexText("Login realizado com sucesso");
                Login login = new Login();
            }
        }
    }
 */

}
