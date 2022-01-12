package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaRealizaConsulta {
    private JPanel panel1;
    private JButton backButton;
    private JTextField textFieldNomeCliente;
    private JTextField textFieldNomeAnimal;
    private JTextField textField3;
    private JButton okButton;
    private JButton buttonLimpar;

    public DonoEmpresaRealizaConsulta(JFrame frame){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        clickBack(frame);
    }
    public void clickBack(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }

    public void LimpaDados(){
        buttonLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNomeCliente.setText(null);
                textFieldNomeAnimal.setText(null);
            }
        });
    }
}
