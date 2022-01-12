package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaRegistado {
    private JPanel panel;
    private JButton buttonCancelaConsulta;
    private JButton buttonAlteraConsulta;
    private JButton buttonRegistaFuncionario;
    private JButton buttonAlteraFuncionario;
    private JButton ButtonListarInfoConsulta;
    private JButton buttonRealizaConsulta;
    private JButton buttonRegistaEmpresa;
    private JButton buttonAlterarDadosEmpresa;
    private JButton buttonListaPagamentos;
    private JButton buttonLogout;
    private JButton ButtonRemoveFuncionario;
    private JButton buttonAlteraPrecos;

    public DonoEmpresaRegistado(JFrame frame){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        clicklogout(frame);
        InsereFuncionario(frame);
        VerInformacoesConsulta(frame);
        CancelarConsulta(frame);
        AlteraConsulta(frame);
        AlteraFuncionario(frame);
        RemoveFuncionario(frame);
        RealizaConsulta(frame);
    }

    public void clicklogout(JFrame frame){
        buttonLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new Login(frame);
            }
        });
    }

    public void InsereFuncionario(JFrame frame){
        buttonRegistaFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new RegistoFuncionario(frame);
            }
        });}

    public void VerInformacoesConsulta(JFrame frame){
        ButtonListarInfoConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaInformacoesConsulta(frame);
            }
        });
    }

    public void CancelarConsulta(JFrame frame){
        buttonCancelaConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaCancelaConsulta(frame);
            }
        });
    }

    public void AlteraConsulta(JFrame frame){
        buttonAlteraConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaAlteraConsulta(frame);
            }
        });
    }

    public void AlteraFuncionario(JFrame frame){
        buttonAlteraFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaAlteraFuncionario(frame);
            }
        });
    }

    public void RemoveFuncionario(JFrame frame){
        ButtonRemoveFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaRemoveFuncionario(frame);
            }
        });
    }

    public void RealizaConsulta(JFrame frame){
        buttonRealizaConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaRealizaConsulta(frame);
            }
        });
    }
}
