package GUI;

import Entidades.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegistoAnonimo extends JFrame{
    private JButton clienteButton;
    private JButton DonoButton;
    private JPanel RegAnonimoPanel;
    private JButton BotaoVoltar;
    //private JFrame RegAnonimo;

    public RegistoAnonimo(JFrame frame, List<User> users) {
        frame = new JFrame("Login Utilizador");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        //RegAnonimo.setResizable(false);

        frame.add(RegAnonimoPanel);
        frame.pack();
        frame.setVisible(true);
        clickCliente(frame,users);
        clickDonoEmpresa(frame, users);
        clickvolarAtras(frame, users);
    }

    public void clickCliente(JFrame frame,List<User> users){
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegAnonimoPanel.setVisible(false);
                new RegistoCliente(frame,users);
            }
        });
    }

    public void clickDonoEmpresa(JFrame frame, List<User> users){
        DonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegAnonimoPanel.setVisible(false);
                new RegistoDonoEmpresa(frame, users);
            }
        });
    }

    public void clickvolarAtras(JFrame frame, List<User> users){
        BotaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegAnonimoPanel.setVisible(false);
                new Login(frame, users);
            }
        });
    }
}
