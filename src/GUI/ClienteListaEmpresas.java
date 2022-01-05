package GUI;

import Entidades.Animal;
import Entidades.Empresa;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ClienteListaEmpresas {
    private JPanel panel;
    private JTable table1;
    private JScrollPane JScrollTable;

    public ClienteListaEmpresas(JFrame frame){
         frame.add(panel);
         frame.pack();
         frame.setVisible(true);
         DefaultTableModel model = (DefaultTableModel) table1.getModel();
         table1.setModel(model);
         model.addColumn("Nome empresa");
         model.addColumn("Dono Empresa");
         model.addColumn("CodPostal");
         model.addColumn("Localidade");
         model.addColumn("NIF");
         model.addColumn("NPorta");
         model.addColumn("Telefone");
         for (Empresa empresa : Repositorio.getInstance().getEmpresas()){
             model.addRow(new Object[] {empresa.getNomeEmpresa(), empresa.getUserDono(), empresa.getcPostal(),
                                        empresa.getLocalidade(), empresa.getNif(), empresa.getnPorta(), empresa.getTelefone()});
         }
     }
}
