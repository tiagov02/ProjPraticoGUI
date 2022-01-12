package GUI;

import MetodosLogicos.AnonimoMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ClienteMarcaConsultaLocalidade {
    private JPanel panel;
    private JScrollPane scroll;
    private JTable table1;

    public ClienteMarcaConsultaLocalidade(JFrame frame){
        frame = new JFrame("Registo de Clientes");

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model=(DefaultTableModel) table1.getModel();
        model.addColumn("Nome da empresa");
        model.addColumn("Nif da Empresa ");
        model.addColumn("Telefone da empresa");
        model.addColumn("Localidade");

    }
}
