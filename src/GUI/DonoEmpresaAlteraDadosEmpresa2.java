package GUI;

import Entidades.Empresa;
import Exceptions.AlteracaoDadosException;
import MetodosLogicos.DonoEmpresaMetodos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaAlteraDadosEmpresa2 {
    private JPanel panel1;
    private JPanel panel;
    private JButton buttonback;
    private JTextField textFieldTelefone;
    private JTextField textFieldNomeEmpresa;
    private JTextField textFieldNIFEmpresa;
    private JTextField textFieldNPorta;
    private JTextField textFieldLocalidade;
    private JButton alterarButton;
    private JButton buttonlimpar;

    public DonoEmpresaAlteraDadosEmpresa2(JFrame frame, Empresa empresa){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        textFieldTelefone.setText(String.valueOf(empresa.getTelefone()));
        textFieldNomeEmpresa.setText(empresa.getNomeEmpresa());
        textFieldNIFEmpresa.setText(String.valueOf(empresa.getNif()));
        textFieldNPorta.setText(String.valueOf(empresa.getnPorta()));
        textFieldLocalidade.setText(empresa.getLocalidade());

        voltarAtras(frame, empresa);
        LimparSENecessario();
        AlterarEmpresa(frame, empresa);
    }

    public void voltarAtras(JFrame frame, Empresa empresa){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaAlteraDadosEmpresa(frame, empresa);
            }
        });
    }

    public void LimparSENecessario(){
        buttonlimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldTelefone.setText(null);
                textFieldNomeEmpresa.setText(null);
                textFieldLocalidade.setText(null);
                textFieldNPorta.setText(null);
                textFieldNIFEmpresa.setText(null);
            }
        });
    }

    public void AlterarEmpresa(JFrame frame, Empresa empresa){
        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int telefone=0, nif=0, nporta=0;
               String nome = textFieldNomeEmpresa.getText();
               String localidade = textFieldLocalidade.getText();
               try{
                   telefone=Integer.parseInt(textFieldTelefone.getText());
               }
               catch (NumberFormatException ex){
                   JOptionPane.showMessageDialog(null, "Não pode introduzir letras num numTelefone!");
               }
                try{
                    nif=Integer.parseInt(textFieldNIFEmpresa.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Não pode introduzir letras num numTelefone!");
                }
                try{
                    nporta=Integer.parseInt(textFieldNPorta.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Não pode introduzir letras num numTelefone!");
                }
                empresa.setTelefone(telefone);
                empresa.setNomeEmpresa(nome);
                empresa.setNif(nif);
                empresa.setnPorta(nporta);
                empresa.setLocalidade(localidade);
                try {
                    DonoEmpresaMetodos.alterarDadosEmpresa(empresa);
                    JOptionPane.showMessageDialog(null,"SUCESSO!!");
                    panel.setVisible(false);
                    new DonoEmpresaRegistado(frame);
                }
                catch (AlteracaoDadosException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
}
