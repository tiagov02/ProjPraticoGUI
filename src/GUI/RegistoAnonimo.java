package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistoAnonimo extends JFrame{
    private JButton clienteButton;
    private JButton DonoButton;
    private JPanel RegAnonimoPanel;
    //private JFrame RegAnonimo;

    public RegistoAnonimo(JFrame frame) {
        frame = new JFrame("Login Utilizador");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 300));
        //RegAnonimo.setResizable(false);

        frame.add(RegAnonimoPanel);
        frame.pack();
        frame.setVisible(true);
        clickCliente(frame);
        clickDonoEmpresa(frame);
    }

    public void clickCliente(JFrame frame){
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegAnonimoPanel.setVisible(false);
                new RegistoCliente(frame);
            }
        });
    }

    public void clickDonoEmpresa(JFrame frame){
        DonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegAnonimoPanel.setVisible(false);
                new RegistoDonoEmpresa(frame);
            }
        });
    }
}
