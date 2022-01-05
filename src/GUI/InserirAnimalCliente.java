package GUI;

import Entidades.Animal;
import Entidades.User;
import Entidades.UserCliente;
import Exceptions.JaExisteAnimalException;
import MetodosLogicos.ClienteMetodos;
import Repositorio.Repositorio;
import Repositorio.RepositorioSerializable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class InserirAnimalCliente extends JFrame{
    private JTextField tb_nMicro;
    private JTextField tb_nome;
    private JTextField tb_especie;
    private JTextField tb_raca;
    private JButton BotaoLimpar;
    private JButton BotaoInserir;
    private JButton BotaoVoltar;
    private JSpinner spinner_dia;
    private JSpinner spinner_mes;
    private JSpinner spinner_ano;
    private JPanel panel;
    private ClienteMetodos metodos;


    public InserirAnimalCliente(JFrame frame, User login){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        Date data=new Date();
        int ano= data.getYear()+1900;
        spinner_ano.setModel(new SpinnerNumberModel(2000,1900,ano,1));
        spinner_dia.setModel(new SpinnerNumberModel(1,1,31,1));
        spinner_mes.setModel(new SpinnerNumberModel(1,1,12,1));
        clickInserir(frame, login, Repositorio.getInstance().getAnimais());
        voltarAtras(frame, login);
        LimparDados();
    }

    public void LimparDados(){
        BotaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tb_nMicro.setText(null);
                tb_nome.setText(null);
                tb_especie.setText(null);
                tb_raca.setText(null);
            }
        });
    }

    public void clickInserir(JFrame frame, List<Animal> animais){
        BotaoInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dia= (int) spinner_dia.getValue();
                int mes= (int) spinner_mes.getValue();
                int ano= (int) spinner_ano.getValue();
                Date dataNas=new Date(ano,mes, dia);
                System.out.println("Data Nascimento: "+dataNas);
                int nMicro=Integer.parseInt(tb_nMicro.getText());
                String nome= tb_nome.getText();
                String especie=tb_especie.getText();
                String raca=tb_raca.getText();
                Animal animal = new Animal(nMicro, nome, especie, raca, dataNas, Repositorio.getInstance().getCurrentUser().getUsername());
                try {
                    metodos.addAnimal(animal, animais);
                    RepositorioSerializable.writeAnimais();
                    JOptionPane.showMessageDialog(null, "Animal inserido com sucesso!");
                    panel.setVisible(false);
                    new ClienteRegistado(frame, );
                }
                catch (JaExisteAnimalException ex){
                    JOptionPane.showMessageDialog(null, "Dados inválidos!");
                }
            }
        });
    }
    public void ColocaCamposVazios(){
        tb_nMicro.setText(null);
        tb_nome.setText(null);
        tb_raca.setText(null);
        tb_especie.setText(null);
    }

    public void clickLimpar(){
        BotaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColocaCamposVazios();
            }
        });
    }

    public void voltarAtras(JFrame frame, User login){
        BotaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new ClienteRegistado(frame,login);
            }
        });
    }
}
