package GUI;

import Entidades.Consulta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaRealizaConsulta2 {
    private JPanel panel;
    private JButton OKButton;
    private JButton backButton;
    private JTextField tb_dadosDiag;
    private Consulta c;

    public DonoEmpresaRealizaConsulta2(JFrame frame, Consulta c){
        this.c=c;
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void clickOK(){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dadosDiag=tb_dadosDiag.getText();
            }
        });
    }
}
