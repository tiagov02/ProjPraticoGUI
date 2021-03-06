package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteMarcaConsulta {
    private JPanel panel;
    private JButton SIMButton;
    private JButton NAOButton;

    public ClienteMarcaConsulta(JFrame frame){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        clickSim(frame);
        clickNao(frame);
    }

    public void clickSim(JFrame frame){
        SIMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new ClienteMarcaConsultaLocalidade(frame);
            }
        });
    }

    public void clickNao(JFrame frame){
        NAOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new ClienteMarcaConsultaFora(frame);
            }
        });
    }
}
