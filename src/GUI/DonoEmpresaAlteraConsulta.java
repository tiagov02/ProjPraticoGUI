package GUI;

import Entidades.Consulta;
import Entidades.TipoConsulta;
import Estados.EstadoConsulta;
import MetodosLogicos.DonoEmpresaMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaAlteraConsulta {
    private JPanel panel1;
    private JTable table1;
    private JTextField textFieldDtConsulta;
    private JTextField textFieldNomeCliente;
    private JButton buttonback;
    private JButton Alterar;
    private JComboBox cb_cliente;
    private JComboBox cb_estadoConsulta;
    private JButton cancelarConsultaButton;

    public DonoEmpresaAlteraConsulta(JFrame frame,int nifEmpresa){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model= (DefaultTableModel)table1.getModel();
        table1.setModel(model);
        model.addColumn("Data Consulta");
        model.addColumn("Estado");
        model.addColumn("Tipo Consulta");
        model.addColumn("Cliente");
        for (Consulta c : Repositorio.getInstance().getConsultas()){
            if (c.getNifEmpresa() == nifEmpresa){
                model.addRow(new Object[] {c.getDataHoraConsulta(), c.getEstado(), c.getTipoConsulta(), c.getUserCliente()});
                cb_cliente.addItem(c.getUserCliente());
            }
        }
        cb_estadoConsulta.addItem("Marcado");
        cb_estadoConsulta.addItem("Confirmado");
        cb_estadoConsulta.addItem("Anulado");
        cb_estadoConsulta.addItem("Concluido");
        voltaAtras(frame);
        AlteraConsulta(frame,nifEmpresa);
        clickCancela(frame,nifEmpresa);
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

    public void AlteraConsulta(JFrame frame, int nifEmpresa){
        Alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String estadoConsulta=(String) cb_estadoConsulta.getSelectedItem();
                String userCliente=(String) cb_cliente.getSelectedItem();
                EstadoConsulta est=null;
                if(estadoConsulta.equals("Marcado"))
                    est=EstadoConsulta.MARCADA;
                else
                if(estadoConsulta.equals("Confirmado"))
                    est=EstadoConsulta.CONFIRMADA;
                else
                if(estadoConsulta.equals("Anulado"))
                    est=EstadoConsulta.ANULADA;
                else
                if(estadoConsulta.equals("Concluido"))
                    est=EstadoConsulta.CONCLUIDA;

                DonoEmpresaMetodos.alteraConsulta(est,userCliente);
                JOptionPane.showMessageDialog(null,"Alterou consulta com sucesso!");
                panel1.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }

    public void clickCancela(JFrame frame,int nifEmpresa){
        cancelarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userCliente=(String) cb_cliente.getSelectedItem();
                DonoEmpresaMetodos.CancelarConsulta(userCliente,nifEmpresa);
                JOptionPane.showMessageDialog(null,"Cancelou a consulta com sucesso!!");
            }
        });
    }
}
