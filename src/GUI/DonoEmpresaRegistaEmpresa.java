package GUI;

import Entidades.Empresa;
import Entidades.User;
import MetodosLogicos.DonoEmpresaMetodos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DonoEmpresaRegistaEmpresa {
    private JButton buttonback;
    private JTextField textFieldTelefone;
    private JTextField textFieldNomeEmpresa;
    private JTextField textFieldNIFEmpresa;
    private JTextField textFieldNPorta;
    private JTextField textFieldLocalidade;
    private JTextField textFieldCodPostal;
    private JButton inserirButton;
    private JButton buttonlimpar;
    private JPanel panel;
    private DonoEmpresaMetodos metodos;

    public DonoEmpresaRegistaEmpresa(JFrame frame){
        metodos = new DonoEmpresaMetodos();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        LimparDados();
        voltarAtras(frame);
    }
    public void LimparDados(){
        buttonlimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldLocalidade.setText(null);
                textFieldTelefone.setText(null);
                textFieldNIFEmpresa.setText(null);
                textFieldNomeEmpresa.setText(null);
                textFieldCodPostal.setText(null);
                textFieldNPorta.setText(null);
            }
        });
    }

    public void voltarAtras(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }

    public void inserirEmpresa(JFrame frame, List<Empresa> empresas){
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
