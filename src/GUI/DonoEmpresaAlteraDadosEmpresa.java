package GUI;

import Entidades.Empresa;
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

    public DonoEmpresaAlteraDadosEmpresa(JFrame frame){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model= (DefaultTableModel)table1.getModel();
        table1.setModel(model);
        model.addColumn("Telefone");
        model.addColumn("Nome");
        model.addColumn("NIF");
        model.addColumn("Localidade");
        model.addColumn("Tipo");
        for (Empresa e : Repositorio.getInstance().getEmpresas()){
            if (e instanceof Empresa){
                model.addRow(new Object[] {e.getTelefone(), e.getNomeEmpresa(), e.getNif(), e.getLocalidade(), e.getTipo()});
            }
        }
        voltaAtras(frame);
        LimpaDados();
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

    public void LimpaDados(){
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNIF.setText(null);
                textFieldLocalidade.setText(null);
            }
        });
    }

    public void AlterarEmpresa(JFrame frame){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
