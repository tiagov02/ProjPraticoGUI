package GUI;

import Entidades.User;
import Entidades.UserFuncionario;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaAlteraFuncionario {
    private JPanel panel1;
    private JTable table1;
    private JTextField textFieldNumccFuncionario;
    private JTextField textFieldNIFFuncionario;
    private JButton buttonback;
    private JButton buttonlimpar;
    private JButton alterarButton;
    private UserFuncionario metodos;


    public DonoEmpresaAlteraFuncionario(JFrame frame){
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
        AlterarFuncionario(frame);
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
                textFieldNIFFuncionario.setText(null);
                textFieldNumccFuncionario.setText(null);
            }
        });
    }

    public void AlterarFuncionario(JFrame frame){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldNumccFuncionario.getText().equals(Repositorio.getInstance().getCurrentUser().getNumCC()) &&
                    textFieldNIFFuncionario.getText().equals(Repositorio.getInstance().getCurrentUser().getNIF())){
                    panel1.setVisible(false);
                    //LINHA ABAIXO ERRADA...AQUI TEMOS QUE APAGAR O FUNCIONÁRIO
                    Repositorio.getInstance().getUsers().remove(textFieldNIFFuncionario);
                    new RegistoFuncionario(frame);
                }
                else{
                    JOptionPane.showMessageDialog(null, "ERRO! Funcionário não existe");
                }
            }
        });
    }
}
