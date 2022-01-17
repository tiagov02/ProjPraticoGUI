package GUI;

import Entidades.TipoConsulta;
import Exceptions.AlteracaoDadosException;
import MetodosLogicos.AdminMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAlteraTipoConsulta {
    private JPanel panel1;
    private JTable table1;
    private JButton backButton;
    private JComboBox comboBoxDescricao;
    private JButton alterarButton;
    private JTextField tb_descricao;
    private JTextField tb_valor;
    private JButton limparButton;

    public AdminAlteraTipoConsulta(JFrame frame){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        table1.setModel(model);
        model.addColumn("ID");
        model.addColumn("Descrição");
        model.addColumn("Preço Especialidade");
        for (TipoConsulta tipo : Repositorio.getInstance().getTiposConsultas()){
            model.addRow(new Object[]{tipo.getIdTipo(),tipo.getDescricao(), tipo.getPrecoEsp()});
            comboBoxDescricao.addItem(tipo.getIdTipo());
        }
        voltaAtras(frame);
        alteraConsulta(frame);
        LimparDados();
    }

    public void voltaAtras(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new AdminRegistado(frame);
            }
        });
    }

    public void alteraConsulta(JFrame frame){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) comboBoxDescricao.getSelectedItem();
                TipoConsulta tipo = AdminMetodos.selecionarTiposConsulta(id);
                float valor=0;
                String descreve = tb_descricao.getText();
                try {
                    valor=Float.parseFloat(tb_valor.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor introduza valores no preço.");
                }
                tipo.setDescricao(descreve);
                tipo.setPrecoEsp(valor);
                try {
                    AdminMetodos.alterarDadosTipoConsulta(tipo);
                    JOptionPane.showMessageDialog(null, "SUCESSO!");
                    panel1.setVisible(false);
                    new AdminRegistado(frame);
                }
                catch (AlteracaoDadosException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public void LimparDados(){
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tb_descricao.setText(null);
                tb_valor.setText(null);
            }
        });
    }
}
