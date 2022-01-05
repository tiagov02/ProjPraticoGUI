package GUI;

import MetodosLogicos.AnonimoMetodos;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RegistoFuncionario extends JFrame {
    private JTextField tb_numCC;
    private JTextField tb_nif;
    private JTextField tb_telefone;
    private JTextField tb_morada;
    private JTextField tb_username;
    private JPasswordField tb_password;
    private JTextField tb_localidade;
    private JTextField tb_salario;
    private JSpinner spn_minInicio;
    private JSpinner spn_horInicio;
    private JSpinner spn_horFim;
    private JSpinner spn_minFim;
    private JPanel panel;

    public RegistoFuncionario(JFrame frame){
        frame = new JFrame("Registo de Clientes");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));


        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        spn_horInicio.setModel(new SpinnerNumberModel(1,0,23,1));
        spn_minInicio.setModel(new SpinnerNumberModel(1,0,59,1));

        spn_horFim.setModel(new SpinnerNumberModel(1,0,23,1));
        spn_minFim.setModel(new SpinnerNumberModel(1,0,59,1));
    }
}
