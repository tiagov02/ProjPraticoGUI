package GUI;

import javax.swing.*;

public class AdminRegistado {
    private JButton listarEmpresasButton;
    private JButton alterarEmpresasButton;
    private JButton pagamentosButton;
    private JPanel panel;

    public AdminRegistado(JFrame frame) {
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}