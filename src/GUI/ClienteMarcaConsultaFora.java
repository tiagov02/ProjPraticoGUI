package GUI;

import Entidades.Animal;
import Entidades.Consulta;
import Entidades.Empresa;
import Estados.EstadoConsulta;
import Exceptions.DataJaExisteException;
import MetodosLogicos.ClienteMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ClienteMarcaConsultaFora {
    private JPanel panel;
    private JScrollPane scroll;
    private JTable table1;
    private JButton okButton;
    private JComboBox cb_nifEmpresa;
    private JComboBox cb_animal;
    private JSpinner spn_dia;
    private JSpinner spn_mes;
    private JSpinner spn_ano;
    private JSpinner spn_hora;
    private JSpinner spn_min;
    private JButton backButton;

    public ClienteMarcaConsultaFora(JFrame frame){
        Repositorio r=Repositorio.getInstance();
        frame = new JFrame("Marcacao Consultas");

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model=(DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Nome da empresa");
        model.addColumn("Nif da Empresa ");
        model.addColumn("Telefone da empresa");
        model.addColumn("Localidade");
        model.addColumn("Tipo de consulta");
        model.addColumn("Preço da consulta");
        Date data=new Date();
        spn_ano.setModel(new SpinnerNumberModel(data.getYear()+1900,data.getYear()+1900,data.getYear()+1901,1));
        spn_dia.setModel(new SpinnerNumberModel(1,1,12,1));
        spn_dia.setModel(new SpinnerNumberModel(1,1,31,1));
        spn_hora.setModel(new SpinnerNumberModel(9,9,21,1));
        spn_min.setModel(new SpinnerNumberModel(0,0,59,30));

        for(Empresa e:r.getEmpresas()){
                model.addRow(new Object[] {e.getNomeEmpresa(),e.getNif(),e.getTelefone(),e.getLocalidade(),e.getTipo().getDescricao(),e.getTipo().getPrecoEsp()});
                cb_nifEmpresa.addItem(e.getNif());
        }
        for(Animal a: Repositorio.getInstance().getAnimais()){
            if(a.getUserDono().equals(Repositorio.getInstance().getCurrentUser().getUsername())){
                String comboanimal=a.getNome()+"/"+a.getnMicro();
                cb_animal.addItem(comboanimal);
            }
        }
        clickOK(frame);
        clickBack(frame);
    }

    public void clickOK(JFrame frame){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animal=(String) cb_animal.getSelectedItem();
                String [] substr= animal.split("/");
                int nMicro=Integer.parseInt(substr[1]);
                int nifEmpresa=(int) cb_nifEmpresa.getSelectedItem();
                int dia= (int) spn_dia.getValue();
                int mes=(int) spn_mes.getValue();
                int ano=(int) spn_ano.getValue();
                int hora=(int) spn_hora.getValue();
                int min=(int) spn_min.getValue();
                Date dataHoraConsulta= new Date((ano-1900),mes,dia,hora,min);
                Consulta c=new Consulta(dataHoraConsulta, EstadoConsulta.EFEUADA,Repositorio.getInstance().getCurrentUser().getUsername(),nifEmpresa,nMicro);
                try{
                    ClienteMetodos.marcarConsulta(c);
                }
                catch(DataJaExisteException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
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
