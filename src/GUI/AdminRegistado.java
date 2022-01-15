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

    public AdminRegistado(JFrame frame) {
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        listarempresas(frame);
        logoutadmin(frame);
        alterarDadosEmpresa(frame);
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
}
