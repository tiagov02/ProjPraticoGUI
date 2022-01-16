package GUI;

import Entidades.Consulta;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaRealizaConsulta {
    private JPanel panel1;
    private JTable table1;
    private JComboBox cb_user;
    private JButton okButton;
    private JButton backButton;
    private JTextField textFieldNomeCliente;
    private JTextField textFieldNomeAnimal;
    private JButton buttonLimpar;

    public DonoEmpresaRealizaConsulta(JFrame frame) {
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model=(DefaultTableModel) table1.getModel();
        model.addColumn("Data Consulta");
        model.addColumn("Estado");
        model.addColumn("Tipo Consulta");
        model.addColumn("Cliente");
        model.addColumn("Hora Pagamento");
        for (Consulta c : Repositorio.getInstance().getConsultas()){
            if (c.getNifEmpresa() == Repositorio.getInstance().getCurrentUser().getNIF()){
                model.addRow(new Object[] {c.getDataHoraConsulta(), c.getEstado(), c.getTipoConsulta(), c.getUserCliente(),c.getDataHoraPagamento()});
                cb_user.addItem(c.getUserCliente());
            }
        }
    }

    public void clickOK(){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userCliente=(String) cb_user.getSelectedItem();
            }
        });
    }

}
