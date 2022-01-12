package GUI;

import Entidades.Animal;
import Entidades.Empresa;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteListaEmpresas {
    private JPanel panel;
    private JTable table1;
    private JScrollPane JScrollTable;
    private JButton buttonback;

    public ClienteListaEmpresas(JFrame frame){
         frame.add(panel);
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
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new ClienteRegistado(frame);
            }
        });
    }
}
