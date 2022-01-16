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
    }

    public void clickSim(JFrame frame){
        SIMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ClienteMarcaConsultaLocalidade(frame);
            }
        });
    }
}
