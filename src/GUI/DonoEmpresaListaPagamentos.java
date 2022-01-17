package GUI;

import Entidades.Consulta;
import Estados.EstadoConsulta;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaListaPagamentos {
    private JPanel panel1;
    private JTable table1;
    private JScrollPane Scrollpane;
    private JButton backButton;
    private int nifEmpresa;

    public DonoEmpresaListaPagamentos(JFrame frame, int nifEmpresa) {
        this.nifEmpresa = nifEmpresa;
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Hora Pagamento");
        model.addColumn("Cliente");
        model.addColumn("Empresa");
        for (Consulta c : Repositorio.getInstance().getConsultas()) {
            if(c.getNifEmpresa()==nifEmpresa && c.getEstado().equals(EstadoConsulta.CONCLUIDA)){
                model.addRow(new Object[]{c.getDataHoraPagamento(),c.getUserCliente(),c.getNifEmpresa()});
            }
        }
        voltarAtras(frame);
    }

    public void voltarAtras(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }
}
