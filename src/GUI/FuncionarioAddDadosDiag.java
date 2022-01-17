package GUI;

import Entidades.Consulta;
import Entidades.UserFuncionario;
import MetodosLogicos.DonoEmpresaMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    }

    public void clickOK(JFrame frame){
        String userCliente= (String) comboBox1.getSelectedItem();
        Consulta c=DonoEmpresaMetodos.selectConsultaCliente(userCliente);
        panel1.setVisible(false);
        new FuncionarioAddDadosDiag2(frame,c);
    }

    public void clickBack(JFrame frame){
        panel1.setVisible(false);
        new FuncionarioRegistado(frame);
    }
}
