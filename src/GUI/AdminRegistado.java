package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRegistado {
    private JButton listarEmpresasButton;
    private JButton alterarEmpresasButton;
    private JButton pagamentosButton;
    private JPanel panel;
    private JButton adicionarTiposDeConsultaButton;
    private JButton alterarTiposDeConsultaButton;
    private JButton logoutButton;
    private JButton btn_addAcionistas;

    public AdminRegistado(JFrame frame) {
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        listarempresas(frame);
        logoutadmin(frame);
        alterarDadosEmpresa(frame);
        adicionarTiposConsulta(frame);
        AlterarTipoConsulta(frame);
        addAdmins(frame);
    }

    public void listarempresas(JFrame frame){
        listarEmpresasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new AdminListaEmpresas(frame);
            }
        });
    }

    public void logoutadmin(JFrame frame){
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new Login(frame);
            }
        });
    }
    public void alterarDadosEmpresa(JFrame frame){
        alterarEmpresasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new AdminAlteraEmpresa(frame);
            }
        });
    }

    public void adicionarTiposConsulta(JFrame frame){
        adicionarTiposDeConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new AdminAdicionaTiposConsulta(frame);
            }
        });
    }

    public void AlterarTipoConsulta(JFrame frame){
        alterarTiposDeConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new AdminAlteraTipoConsulta(frame);
            }
        });
    }

    public void addAdmins(JFrame frame){
        btn_addAcionistas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new RegistoAdmin(frame);
            }
        });
    }
}
