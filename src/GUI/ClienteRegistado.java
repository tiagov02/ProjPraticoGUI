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

    public ClienteRegistado(JFrame frame){
        frame.add(PanelClienteRegistado);
        frame.pack();
        frame.setVisible(true);
        IntroduzirAnimal(frame);
        clicaLogout(frame);
        clickListaAnimais(frame);
        clickListaEmpresa(frame);
        clickClienteMarcaConsulta(frame);
        clickPagarConsulta(frame);

    }

    public void IntroduzirAnimal(JFrame frame){
        BotaoInsereAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelClienteRegistado.setVisible(false);
                new InserirAnimalCliente(frame, Repositorio.getInstance().getCurrentUser());
            }
        });
    }
    public void clicaLogout(JFrame frame){
        BotaoLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelClienteRegistado.setVisible(false);
                new Login(frame);
            }
        });
    }

    public void clickListaAnimais(JFrame frame){
        BotaoListaAnimais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelClienteRegistado.setVisible(false);
                new ClienteListaAnimais(frame);
            }
        });
    }

    public void clickListaEmpresa(JFrame frame){
        BotaoListarEmpresas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelClienteRegistado.setVisible(false);
                new ClienteListaEmpresas(frame);
            }
        });
    }
    public void clickClienteMarcaConsulta(JFrame frame){
        BotaoMarcarConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelClienteRegistado.setVisible(false);
                new ClienteMarcaConsulta(frame);
            }
        });
    }

    public void clickPagarConsulta(JFrame frame){
        BotaoPagaConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelClienteRegistado.setVisible(false);
                new ClientePagaConsulta(frame);
            }
        });
    }
}
