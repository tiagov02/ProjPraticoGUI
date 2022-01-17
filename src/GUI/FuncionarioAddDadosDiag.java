package GUI;

import Entidades.Consulta;
import Entidades.UserFuncionario;
import MetodosLogicos.DonoEmpresaMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioAddDadosDiag {
    private JPanel panel1;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton OKButton;
    private JButton backButton;

    public FuncionarioAddDadosDiag(JFrame frame){
        UserFuncionario current= (UserFuncionario) Repositorio.getInstance().getCurrentUser();
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
            if (c.getNifEmpresa() == current.getNifEmpresa()){
                model.addRow(new Object[] {c.getDataHoraConsulta(), c.getEstado(), c.getTipoConsulta(), c.getUserCliente(),c.getDataHoraPagamento()});
                comboBox1.addItem(c.getUserCliente());
            }
        }
        clickBack(frame);
        clickOK(frame);
    }

    public void clickOK(JFrame frame){
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userCliente= (String) comboBox1.getSelectedItem();
                Consulta c=DonoEmpresaMetodos.selectConsultaCliente(userCliente);
                panel1.setVisible(false);
                new FuncionarioAddDadosDiag2(frame,c);
            }
        });
    }

    public void clickBack(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new FuncionarioRegistado(frame);
            }
        });
    }
}
