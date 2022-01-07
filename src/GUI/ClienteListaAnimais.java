package GUI;

import Entidades.Animal;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClienteListaAnimais extends javax.swing.JFrame{

    private JPanel panel1;
    private JTable table1;
    private JScrollPane ScrollPanel;
    private JButton buttonBack;

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
        for (Animal animal1 : Repositorio.getInstance().getAnimais()){
            if (animal1.getUserDono().equals(Repositorio.getInstance().getCurrentUser().getUsername())){
                model.addRow(new Object[] {animal1.getnMicro(),animal1.getNome(), animal1.getDataNasc(), animal1.getEspecie(), animal1.getRaca()});
            }
        }
        voltaAtras(frame);
    }

    public void voltaAtras(JFrame frame){
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new ClienteRegistado(frame);
            }
        });
    }

}


