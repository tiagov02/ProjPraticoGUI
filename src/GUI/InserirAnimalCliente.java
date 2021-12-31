package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class InserirAnimalCliente extends JFrame{
    private JTextField tb_nMicro;
    private JTextField tb_nome;
    private JTextField tb_especie;
    private JTextField tb_raca;
    private JLabel LabelNMicro;
    private JLabel nomeLabel;
    private JLabel especieLabel;
    private JLabel racaLabel;
    private JLabel dataDeNascimentoDdLabel;
    private JButton BotaoLimpar;
    private JButton BotaoInserir;
    private JButton BotaoVoltar;
    private JSpinner spinner_dia;
    private JSpinner spinner_mes;
    private JSpinner spinner_ano;
    private JPanel panel;


    public InserirAnimalCliente(JFrame frame){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        Date data=new Date();
        int ano= data.getYear()+1900;
        spinner_ano.setModel(new SpinnerNumberModel(2000,1900,ano,1));
        spinner_dia.setModel(new SpinnerNumberModel(1,1,31,1));
        spinner_mes.setModel(new SpinnerNumberModel(1,1,12,1));
        clickInserir();
    }

    public void clickInserir(){
        BotaoInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dia= (int) spinner_dia.getValue();
                int mes= (int) spinner_mes.getValue();
                int ano= (int) spinner_ano.getValue();
                int nMicro=Integer.parseInt(tb_nMicro.getText());
                String nome= tb_nome.getText();
                String especie=tb_especie.getText();
                String raca=tb_raca.getText();
            }
        });
    }
}
