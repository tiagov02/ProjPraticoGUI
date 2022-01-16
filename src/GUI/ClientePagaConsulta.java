package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientePagaConsulta {
    private JPanel panel;
    private JTable table1;
    private JComboBox comboBox1;

    public ClientePagaConsulta(JFrame frame){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);
    }
}
