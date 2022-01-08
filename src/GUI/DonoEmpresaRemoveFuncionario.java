package GUI;

import Entidades.User;
import Entidades.UserFuncionario;
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

    public DonoEmpresaRemoveFuncionario(JFrame frame){
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
        for (User funcionario : Repositorio.getInstance().getUsers()){
            model.addRow(new Object[] {funcionario.getNome(), funcionario.getUsername(), funcionario.getNumCC(), funcionario.getNIF(), funcionario.getTelefone()});
        }
        voltaAtras(frame);
        LimpaDados();
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

    public void LimpaDados(){
        buttonlimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNumCC.setText(null);
                textFieldNIF.setText(null);
            }
        });
    }

    public void RemoveUser(){
        buttonremover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //REMOVER AINDA TENHO QUE VER TEMOS VÁRIAS OPÇÕES
            }
        });
    }

}