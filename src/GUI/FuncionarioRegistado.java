package GUI;

import javax.swing.*;

public class FuncionarioRegistado {
    private JButton btn_listConsultas;
    private JButton btn_alterarMarcacao;
    private JButton btn_DadosDiag;
    private JButton btn_criaConsulta;
    private JPanel panel;

    public FuncionarioRegistado(JFrame frame){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
