package GUI;

import javax.swing.*;
import java.awt.*;

public class RegistoAnonimo extends JFrame{
    private JButton clienteButton;
    private JButton DonoButton;
    private JPanel RegAnonimoPanel;
    private JFrame RegAnonimo;

    public RegistoAnonimo(){
        RegAnonimo = new JFrame("Login Utilizador");
        RegAnonimo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        RegAnonimo.setPreferredSize(new Dimension(300, 300));
        //RegAnonimo.setResizable(false);

        RegAnonimo.add(RegAnonimoPanel);
        RegAnonimo.pack();
        RegAnonimo.setVisible(true);

        //CRiar listener
    }
}
