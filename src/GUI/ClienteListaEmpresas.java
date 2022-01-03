package GUI;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ClienteListaEmpresas {
    private JPanel panel;
    private JTable table1;
     public ClienteListaEmpresas(JFrame frame){
         frame.add(panel);
         frame.pack();
         frame.setVisible(true);
     }
}
