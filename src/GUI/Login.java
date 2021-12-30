package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import Entidades.*;
import Estados.*;
import Exceptions.*;
import GUI.*;
import MetodosLogicos.*;
import Repositorio.*;

public class Login extends JFrame{
    private JTextField userTexto;
    private JPanel LoginUsers;
    private JPasswordField passwordTexto;
    private JButton Login; //Button
    private JButton Limpar; //Button
    private JButton RegistoButton;
    //private JFrame frame;
    private LoginMetodos l;
    //private User Usermetodos;
    //HashMap<String, String> logininfo = new HashMap<String, String>();




    public Login(JFrame frame, List<User> users){
        l=new LoginMetodos();
        /*frame = new JFrame("Login Utilizador");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setResizable(false);

         */

        frame.add(LoginUsers);
        frame.pack();
        frame.setVisible(true);
        LimpaDados();
        BotaoLogin(frame,users);
        clickRegistar(frame);

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
    public void leDados(){
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leituraDados();
            }
        });
    }
     */
    public void BotaoLogin(JFrame frame,List<User> users){
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicarBotaoLogin(frame,users);
            }
        });
    }

    public void clicarBotaoLogin(JFrame frame,List<User> users){
        String user,pwd;
        user=userTexto.getText();
        pwd=passwordTexto.getText();
        try{
            User login = l.Login(user, pwd, users);
        }
        catch(NaoExisteUserException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        //Redirecionar para a nova panel
        //if(login instanceof UserCliente)
    }

    public void clickRegistar(JFrame frame){
        RegistoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUsers.setVisible(false);
                RegistoAnonimo registo1 = new RegistoAnonimo(frame);
                registo1.setVisible(true);
                //this.dispose();
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
