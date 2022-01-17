package GUI;

import Entidades.Consulta;
import Entidades.DadosDiag;
import MetodosLogicos.DonoEmpresaMetodos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
        clickOK(frame);
    }

    public void clickOK(JFrame frame){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dadosDiag=tb_dadosDiag.getText();
                DadosDiag d=new DadosDiag(dadosDiag,new Date(),c.getnMicro());
                DonoEmpresaMetodos.escreverDadosDiag(d);
                DonoEmpresaMetodos.efetuaConsulta(c);
                JOptionPane.showMessageDialog(null,"Escreveu dados de Diagnóstico com sucesso!");
                panel.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }
}
