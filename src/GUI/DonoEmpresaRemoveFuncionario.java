package GUI;

import Entidades.User;
import Entidades.UserFuncionario;
import Exceptions.NaoExisteUserException;
import MetodosLogicos.DonoEmpresaMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaRemoveFuncionario {
    private JPanel panel1;
    private JTable table1;
    private JTextField textFieldNumCC;
    private JTextField textFieldNIF;
    private JButton buttonback;
    private JButton buttonlimpar;
    private JButton buttonremover;
    private JComboBox cb_nifFuncionario;



    public DonoEmpresaRemoveFuncionario(JFrame frame,int nifEmpresa){
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
            if(funcionario instanceof UserFuncionario && ((UserFuncionario) funcionario).getNifEmpresa()==nifEmpresa){
                model.addRow(new Object[] {funcionario.getNome(), funcionario.getUsername(), funcionario.getNumCC(),
                        funcionario.getNIF(), funcionario.getTelefone(),((UserFuncionario) funcionario).getSalario()});
                cb_nifFuncionario.addItem(funcionario.getNIF());
            }
        }
        voltaAtras(frame);
        RemoveUser(frame);
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


    public void RemoveUser(JFrame frame){
        buttonremover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nifFuncionario=(int) cb_nifFuncionario.getSelectedItem();
                UserFuncionario f=DonoEmpresaMetodos.selectFuncionarioNif(nifFuncionario);
                DonoEmpresaMetodos.removeUser(f);
                JOptionPane.showMessageDialog(null,"Removido com sucesso!!");
                panel1.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }

}
