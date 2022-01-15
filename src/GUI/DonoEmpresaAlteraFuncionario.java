package GUI;

import Entidades.Empresa;
import Entidades.User;
import Entidades.UserFuncionario;
import MetodosLogicos.DonoEmpresaMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaAlteraFuncionario {
    private JPanel panel1;
    private JTable table1;
    private JButton buttonback;
    private JButton buttonlimpar;
    private JButton alterarButton;
    private JComboBox cb_nifFuncionario;
    private UserFuncionario metodos;
    private int nifEmp;


    public DonoEmpresaAlteraFuncionario(JFrame frame, int nifEmp){
        this.nifEmp=nifEmp;
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model= (DefaultTableModel)table1.getModel();
        table1.setModel(model);
        model.addColumn("Nome");
        model.addColumn("Username");
        model.addColumn("NumCC");
        model.addColumn("NIF");
        model.addColumn("Telefone");
        model.addColumn("Salário");
        for (User funcionario : Repositorio.getInstance().getUsers()){
            if(funcionario instanceof UserFuncionario && ((UserFuncionario) funcionario).getNifEmpresa()==nifEmp){
                model.addRow(new Object[] {funcionario.getNome(), funcionario.getUsername(), funcionario.getNumCC(), funcionario.getNIF(), funcionario.getTelefone(),((UserFuncionario) funcionario).getSalario()});
                cb_nifFuncionario.addItem(funcionario.getNIF());
            }
        }
        voltaAtras(frame);
        alterarFuncionario(frame);
    }


    public void voltaAtras(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new SelectEmpresaAlteraFuncionario(frame);
            }
        });
    }

    public void alterarFuncionario(JFrame frame){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nifFuncionario= (int) cb_nifFuncionario.getSelectedItem();
                UserFuncionario u=DonoEmpresaMetodos.selectFuncionarioNifEmpresa(nifFuncionario,nifEmp);
                panel1.setVisible(false);
                new DonoEmpresaAlteraFuncionario2(frame,u);
               //new DonoEmpresaAlteraFuncionario2(frame, u);
            }
        });
    }
}
