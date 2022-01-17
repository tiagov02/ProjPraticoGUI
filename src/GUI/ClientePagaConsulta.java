package GUI;

import Entidades.Consulta;
import Estados.EstadoConsulta;
import MetodosLogicos.ClienteMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientePagaConsulta {
    private JPanel panel;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton OKButton;
    private JButton backButton;

    public ClientePagaConsulta(JFrame frame){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Data Consulta");
        model.addColumn("Estado");
        model.addColumn("Tipo Consulta");
        model.addColumn("nº do microship doAnimal");
        for (Consulta c : Repositorio.getInstance().getConsultas()){
            if (c.getUserCliente().equals(Repositorio.getInstance().getCurrentUser()) && c.getEstado().equals(EstadoConsulta.EFEUADA)){
                model.addRow(new Object[] {c.getDataHoraConsulta(), c.getEstado(), c.getTipoConsulta(), c.getUserCliente()});
                comboBox1.addItem(c.getnMicro());
            }
        }
        clickBack(frame);
        clickOk(frame);
    }

    public void clickOk(JFrame frame){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nMicro=(int) comboBox1.getSelectedItem();
                Consulta c= ClienteMetodos.selectConsultaAPagar(nMicro);
                ClienteMetodos.pagaConsulta(c);
                JOptionPane.showMessageDialog(null,"Consulta paga com sucesso!!");
                panel.setVisible(false);
                new ClienteRegistado(frame);
            }
        });
    }

    public void clickBack(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new ClienteRegistado(frame);
            }
        });
    }
}
