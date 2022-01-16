package GUI;

import Entidades.Empresa;
import Exceptions.AlteracaoDadosException;
import MetodosLogicos.AdminMetodos;
import MetodosLogicos.DonoEmpresaMetodos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAlteraEmpresa2 {
    private JPanel panel1;
    private JButton backButton;
    private JTextField textFieldteelfone;
    private JTextField textFieldNIF;
    private JTextField textFieldnomeEmpresa;
    private JTextField textFieldlocalidade;
    private JTextField textFieldnporta;
    private JButton alterarButton;
    private JButton eliminarButton;
    private Empresa empresa;

    public AdminAlteraEmpresa2(JFrame frame, Empresa empresa){
        this.empresa = empresa;
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        voltar(frame);
        alterarEmpresa(frame, empresa);
    }

    public void voltar(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new AdminAlteraEmpresa(frame);
            }
        });
    }

    public void alterarEmpresa(JFrame frame, Empresa empresa){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int telefone=0, nif=0, nporta=0;
                String nome = textFieldnomeEmpresa.getText();
                String localidade = textFieldlocalidade.getText();
                try{
                    telefone=Integer.parseInt(textFieldteelfone.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Não pode introduzir letras num numTelefone!");
                }
                try{
                    nif=Integer.parseInt(textFieldNIF.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Não pode introduzir letras num NIF!");
                }
                try{
                    nporta=Integer.parseInt(textFieldnporta.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Não pode introduzir letras num numero de porta!");
                }
                empresa.setTelefone(telefone);
                empresa.setNomeEmpresa(nome);
                empresa.setNif(nif);
                empresa.setnPorta(nporta);
                empresa.setLocalidade(localidade);
                try{
                    AdminMetodos.alterarDadosEmpresa(empresa);
                    JOptionPane.showMessageDialog(null, "EMPRESA ALTERADA COM SUCESSO");
                    panel1.setVisible(false);
                    new AdminRegistado(frame);
                }
                catch (AlteracaoDadosException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }



}