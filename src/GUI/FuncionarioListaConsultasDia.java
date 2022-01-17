package GUI;

import Entidades.Consulta;
import Entidades.UserFuncionario;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FuncionarioListaConsultasDia {
    private JPanel panel;
    private JTable table1;
    private JScrollPane scr;
    private JButton backButton;

    public FuncionarioListaConsultasDia(JFrame frame) {
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Data Consulta");
        model.addColumn("Estado");
        model.addColumn("Tipo Consulta");
        model.addColumn("Cliente");
        model.addColumn("Numero microship animal");
        for (Consulta c : Repositorio.getInstance().getConsultas()) {
            if (c.getDataMarcacao().equals(new Date()) && Repositorio.getInstance().getCurrentUser() instanceof UserFuncionario && c.getNifEmpresa()== ((UserFuncionario) Repositorio.getInstance().getCurrentUser()).getNifEmpresa()) {
                model.addRow(new Object[]{c.getDataHoraConsulta(), c.getEstado(), c.getTipoConsulta(), c.getUserCliente(), c.getnMicro()});
            }
        }
        clickBack(frame);
    }

    public void clickBack(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new FuncionarioRegistado(frame);
            }
        });
    }
}
