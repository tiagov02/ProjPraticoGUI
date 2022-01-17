package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioRegistado {
    private JButton btn_listConsultas;
    private JButton btn_alterarMarcacao;
    private JButton btn_DadosDiag;
    private JPanel panel;
    private JButton logoutButton;

    public FuncionarioRegistado(JFrame frame) {
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        ListaConsultasDia(frame);
        cancelaAlteraMarcacoes(frame);
        addDiag(frame);
        logout(frame);
    }

    public void ListaConsultasDia(JFrame frame){
       btn_listConsultas.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               panel.setVisible(false);
               new FuncionarioListaConsultasDia(frame);
           }
       });
    }

    public void cancelaAlteraMarcacoes(JFrame frame){
        btn_alterarMarcacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new FuncionarioAlteraConsulta(frame);
            }
        });
    }

    public void addDiag(JFrame frame){
        btn_DadosDiag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new FuncionarioAddDadosDiag(frame);
            }
        });
    }

    public void logout(JFrame frame){
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new Login(frame);
            }
        });
    }
}
