package GUI;

import Entidades.Empresa;
import Entidades.Pagamento;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DonoEmpresaListaPagamentos {
    private JPanel panel1;
    private JTable table1;
    private JScrollPane Scrollpane;


    public DonoEmpresaListaPagamentos(JFrame frame){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Hora Pagamento");
        model.addColumn("Cliente");
        model.addColumn("Empresa");//
    }
}
