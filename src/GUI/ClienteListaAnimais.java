package GUI;

import Entidades.Animal;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ClienteListaAnimais extends javax.swing.JFrame{

    private JPanel panel1;
    private JTable table1;
    private JScrollPane ScrollPanel;

    public ClienteListaAnimais(JFrame frame){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model= (DefaultTableModel)table1.getModel();
        table1.setModel(model);
        model.addColumn("Numero do microship");
        model.addColumn("Nome do animal");
        model.addColumn("Data Nascimento");
        model.addColumn("Espécie");
        model.addColumn("Raça");
        model.addColumn("Username do dono");
        for (Animal animal1 : Repositorio.getInstance().getAnimais()){
            if (animal1.getUserDono().equals(Repositorio.getInstance().getCurrentUser().getUsername())){
                model.addRow(new Object[] {animal1.getNome(),animal1.getDataNasc()});
            }
        }
    }

}


