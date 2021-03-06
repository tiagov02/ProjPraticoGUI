package GUI;

import Entidades.Empresa;
import MetodosLogicos.DonoEmpresaMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaAlteraDadosEmpresa {
    private JPanel panel1;
    private JTable table1;
    private JButton backButton;
    private JTextField textFieldNIF;
    private JTextField textFieldLocalidade;
    private JButton limparButton;
    private JButton alterarButton;
    private JComboBox comboBoxNIF;

    public DonoEmpresaAlteraDadosEmpresa(JFrame frame){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model= (DefaultTableModel)table1.getModel();
        table1.setModel(model);
        model.addColumn("Nome empresa");
        model.addColumn("Dono Empresa");
        model.addColumn("Localidade");
        model.addColumn("NIF");
        model.addColumn("NPorta");
        model.addColumn("Telefone");
        for (Empresa empresa : Repositorio.getInstance().getEmpresas()) {
            if (empresa.getUserDono().equals(Repositorio.getInstance().getCurrentUser().getUsername())) {
                model.addRow(new Object[]{empresa.getNomeEmpresa(), empresa.getUserDono(),
                        empresa.getLocalidade(), empresa.getNif(), empresa.getnPorta(), empresa.getTelefone()});
                comboBoxNIF.addItem(empresa.getNif());
            }
        }
        voltaAtras(frame);
        AlterarEmpresa(frame);
    }

    public void voltaAtras(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }

    public void AlterarEmpresa(JFrame frame){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nifEmpresa=(int) comboBoxNIF.getSelectedItem();
                Empresa emp= DonoEmpresaMetodos.selectEmpresaporNif(nifEmpresa);
                panel1.setVisible(false);
                new DonoEmpresaAlteraDadosEmpresa2(frame,emp);
            }
        });
    }

}
