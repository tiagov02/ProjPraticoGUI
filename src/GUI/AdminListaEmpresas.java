package GUI;

import Entidades.Empresa;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminListaEmpresas {
    private JPanel panel1;
    private JButton backButton;
    private JTable table1;


    public AdminListaEmpresas(JFrame frame){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Nome empresa");
        model.addColumn("Dono Empresa");
        model.addColumn("Localidade");
        model.addColumn("NIF");
        model.addColumn("NPorta");
        model.addColumn("Telefone");
        for (Empresa empresa : Repositorio.getInstance().getEmpresas()){
            model.addRow(new Object[] {empresa.getNomeEmpresa(), empresa.getUserDono(),
                    empresa.getLocalidade(), empresa.getNif(), empresa.getnPorta(), empresa.getTelefone()});
        }
        voltaAtras(frame);
    }
    public void voltaAtras(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new AdminRegistado(frame);
            }
        });
    }
}
