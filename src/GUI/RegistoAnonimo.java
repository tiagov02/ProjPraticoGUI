package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistoAnonimo extends JFrame{
    private JButton clienteButton;
    private JButton DonoButton;
    private JPanel RegAnonimoPanel;
    private JFrame RegAnonimo;

    public RegistoAnonimo() {
        RegAnonimo = new JFrame("Login Utilizador");
        RegAnonimo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        RegAnonimo.setPreferredSize(new Dimension(300, 300));
        //RegAnonimo.setResizable(false);

        RegAnonimo.add(RegAnonimoPanel);
        RegAnonimo.pack();
        RegAnonimo.setVisible(true);
        clickCliente();
        clickDonoEmpresa();
    }

    public void clickCliente(){
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegAnonimo.setVisible(false);
                new RegistoCliente();
            }
        });
    }

    public void clickDonoEmpresa(){
        DonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegAnonimo.setVisible(false);
                new RegistoDonoEmpresa();
            }
        });
    }
}
