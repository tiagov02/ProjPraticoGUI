package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

import Entidades.*;
import Estados.*;
import Exceptions.*;
import GUI.*;
import MetodosLogicos.*;
import Repositorio.*;

public class ClienteRegistado extends JFrame{
    private JButton BotaoInsereAnimal;
    private JButton BotaoListarEmpresas;
    private JButton BotaoListaAnimais;
    private JButton BotaoMarcarConsulta;
    private JButton BotaoEditarConsulta;
    private JButton BotaoPagaConsulta;
    private JPanel PanelClienteRegistado;
    private JButton BotaoLogout;

    public ClienteRegistado(JFrame frame, User login){
        frame.add(PanelClienteRegistado);
        frame.pack();
        frame.setVisible(true);
    }

    public void IntroduzirAnimal(JFrame frame,UserCliente cliente){
        BotaoInsereAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelClienteRegistado.setVisible(false);
                new InserirAnimalCliente(frame);
            }
        });
    }
    public void clicaLogout(JFrame frame, List<User> users){
        BotaoLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelClienteRegistado.setVisible(false);
                new Login(frame, users);
            }
        });
    }
}
