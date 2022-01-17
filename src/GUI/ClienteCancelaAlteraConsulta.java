package GUI;

import Entidades.Animal;
import Entidades.Consulta;
import Exceptions.DataJaExisteException;
import MetodosLogicos.ClienteMetodos;
import MetodosLogicos.DonoEmpresaMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ClienteCancelaAlteraConsulta {
    private JPanel panel1;
    private JTable table1;
    private JButton buttonback;
    private JButton Alterar;
    private JComboBox cb_cliente;
    private JButton cancelarConsultaButton;
    private JSpinner spn_dia;
    private JSpinner spn_mes;
    private JSpinner spn_ano;
    private JSpinner spn_hora;
    private JSpinner spn_min;

    public ClienteCancelaAlteraConsulta(JFrame frame){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        Date data=new Date();
        spn_ano.setModel(new SpinnerNumberModel(data.getYear()+1900,data.getYear()+1900,data.getYear()+1901,1));
        spn_dia.setModel(new SpinnerNumberModel(1,1,12,1));
        spn_mes.setModel(new SpinnerNumberModel(1,1,31,1));
        spn_hora.setModel(new SpinnerNumberModel(9,9,21,1));
        spn_min.setModel(new SpinnerNumberModel(0,0,59,30));
        DefaultTableModel model=(DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Numero do microship do animal");
        model.addColumn("Data da consulta");
        model.addColumn("Especialidade da consulta");
        model.addColumn("Preço da consulta");

        for(Consulta c: Repositorio.getInstance().getConsultas()){
            if(c.getUserCliente().equals(Repositorio.getInstance().getCurrentUser().getUsername())){
                model.addRow(new Object[]{c.getnMicro(),c.getDataMarcacao(),c.getTipoConsulta().getDescricao(),c.getTipoConsulta().getPrecoEsp()});
                cb_cliente.addItem(c.getnMicro());
            }
        }
        clickMudar(frame);
        clickCancelar(frame);
        clickBack(frame);
    }

    public void clickMudar(JFrame frame){
       Alterar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int nMicro=(int) cb_cliente.getSelectedItem();
               Consulta c=ClienteMetodos.selectConsultaAPagar(nMicro);
               int ano=(int) spn_ano.getValue();
               int dia= (int) spn_dia.getValue();
               int mes= (int) spn_mes.getValue();
               int hora=(int) spn_hora.getValue();
               int min=(int) spn_min.getValue();

               Date data=new Date((ano-1900),mes,dia,hora,min);
               try{
                   ClienteMetodos.mudarHoraConsulta(c,data);
                   JOptionPane.showMessageDialog(null,"Sucesso!!");
                   panel1.setVisible(false);
                   new ClienteRegistado(frame);
               }
               catch (DataJaExisteException ex){
                   JOptionPane.showMessageDialog(null,ex.getMessage());
               }
           }
       });
    }

    public void clickCancelar(JFrame frame){
        cancelarConsultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nMicro=(int) cb_cliente.getSelectedItem();
                Consulta c=ClienteMetodos.selectConsultaAPagar(nMicro);
                DonoEmpresaMetodos.eliminaConsulta(c);
                JOptionPane.showMessageDialog(null,"A consulta foi eliminada com sucesso!");
            }
        });
    }

    public void clickBack(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new ClienteRegistado(frame);
            }
        });
    }
}
