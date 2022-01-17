package GUI;

import Entidades.Empresa;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEmpresaListaConsultas {
    private JPanel panel;
    private JTable table1;
    private JComboBox cb_nifEmpresa;
    private JButton btn_Back;
    private JButton btn_OK;

    public SelectEmpresaListaConsultas(JFrame frame){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        table1.setModel(model);
        model.addColumn("Nome empresa");
        model.addColumn("Dono Empresa");
        model.addColumn("Localidade");
        model.addColumn("NIF");
        model.addColumn("NPorta");
        model.addColumn("Telefone");
        for (Empresa empresa : Repositorio.getInstance().getEmpresas()){
            if(empresa.getUserDono().equals(Repositorio.getInstance().getCurrentUser().getUsername())){
                model.addRow(new Object[] {empresa.getNomeEmpresa(), empresa.getUserDono(),
                        empresa.getLocalidade(), empresa.getNif(), empresa.getnPorta(), empresa.getTelefone()});
                cb_nifEmpresa.addItem(empresa.getNif());
            }
        }
        clickOK(frame);
        Buttonback(frame);
    }

    public void clickOK(JFrame frame){
        btn_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nifEmpresa=(int) cb_nifEmpresa.getSelectedItem();
                panel.setVisible(false);
                new DonoEmpresaInformacoesConsulta(frame,nifEmpresa);
            }
        });
    }
    public void Buttonback(JFrame frame){
        btn_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }
}
