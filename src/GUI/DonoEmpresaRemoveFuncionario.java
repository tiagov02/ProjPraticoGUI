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
    private DonoEmpresaMetodos metodos;

    public DonoEmpresaRemoveFuncionario(JFrame frame){
        metodos=new DonoEmpresaMetodos();
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
            if(funcionario instanceof UserFuncionario){
                model.addRow(new Object[] {funcionario.getNome(), funcionario.getUsername(), funcionario.getNumCC(), funcionario.getNIF(), funcionario.getTelefone(),((UserFuncionario) funcionario).getSalario()});
            }
        }
        voltaAtras(frame);
        LimpaDados();
        RemoveUser();
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
            int nif=0;
            int numCC=0;
            boolean sucesso=false;
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    nif=Integer.parseInt(textFieldNIF.getText());
                    numCC=Integer.parseInt(textFieldNIF.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Não pode introduzir letras em nenhumm dos campos");
                }
                try {
                    metodos.removeFuncionario(nif,numCC);
                    JOptionPane.showMessageDialog(null,"Removeu o user com nif: "+nif+" NumCC: "+numCC);
                }
                catch (NaoExisteUserException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

}
