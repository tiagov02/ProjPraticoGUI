package GUI;

import Entidades.TipoConsulta;
import Exceptions.JaExisteTipoConsultaExcpetion;
import MetodosLogicos.AdminMetodos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminAdicionaTiposConsulta {
    private JTextField tb_tipoConsulta;
    private JButton limparButton;
    private JButton backButton;
    private JButton inserirButton;
    private JPanel panel1;
    private JTextField tb_preco;
    private List<TipoConsulta> tipos;

    public AdminAdicionaTiposConsulta(JFrame frame){
        this.tipos=tipos;
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        limparDados();
        backButton(frame);
        InserirTiposConsulta(frame, tipos);
    }

    public void InserirTiposConsulta(JFrame frame, List<TipoConsulta> tiposConsulta){
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoConsulta = tb_tipoConsulta.getText();
                Float precoEspecialidade = Float.parseFloat(tb_preco.getText());
                TipoConsulta tipo = new TipoConsulta(tipoConsulta, precoEspecialidade);
                try{
                    AdminMetodos.addTipoConsulta(tiposConsulta, tipo);
                    JOptionPane.showMessageDialog(null, "Tipo de Consulta inserido com sucesso");
                    panel1.setVisible(false);
                    new AdminRegistado(frame);
                }
                catch (JaExisteTipoConsultaExcpetion ex){
                    JOptionPane.showMessageDialog(null, "ERRO! Dados inválidos");
                }
            }
        });
    }

    public void limparDados(){
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tb_tipoConsulta.setText(null);
                tb_preco.setText(null);
            }
        });
    }

    public void backButton(JFrame frame){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new AdminRegistado(frame);
            }
        });
    }
}
