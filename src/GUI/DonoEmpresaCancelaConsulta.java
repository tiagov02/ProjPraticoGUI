package GUI;

import Entidades.Consulta;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaCancelaConsulta {
    private JPanel panel1;
    private JTable table1;
    private JButton buttonback;
    private JTextField textFieldUserCliente;
    private JTextField textFielDataConsulta;
    private JButton buttonCancelar;
    private JButton buttonLimpar;

    public DonoEmpresaCancelaConsulta(JFrame frame){
        frame.add(panel1);
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
        LimpaDados();
    }


    public void voltaAtras(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }

    public void LimpaDados(){
        buttonLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFielDataConsulta.setText(null);   //AQUI TEMOS QUE ADICIONAR DEPOIS AQUILO DOS DIAS
                textFieldUserCliente.setText(null);
            }
        });
    }
}