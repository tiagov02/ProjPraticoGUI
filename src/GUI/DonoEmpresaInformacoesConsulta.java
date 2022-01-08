package GUI;

import Entidades.Consulta;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaInformacoesConsulta {
    private JPanel panelListaConsulta;
    private JTable table1;
    private JButton buttonback;


    public DonoEmpresaInformacoesConsulta(JFrame frame){
        frame.add(panelListaConsulta);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model= (DefaultTableModel)table1.getModel();
        table1.setModel(model);
        model.addColumn("Data Consulta");
        model.addColumn("Estado");
        model.addColumn("Tipo Consulta");
        model.addColumn("Cliente");
        model.addColumn("Hora Pagamento");
        for (Consulta c : Repositorio.getInstance().getConsultas()){
            if (c.getNifEmpresa() == Repositorio.getInstance().getCurrentUser().getNIF()){
                model.addRow(new Object[] {c.getDataHoraConsulta(), c.getEstado(), c.getTipoConsulta(), c.getUserCliente(),c.getDataHoraPagamento()});
            }
        }
        voltaAtras(frame);
    }

    public void voltaAtras(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelListaConsulta.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }
}
