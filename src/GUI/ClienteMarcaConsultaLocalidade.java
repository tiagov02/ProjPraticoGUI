package GUI;

import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entidades.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ClienteMarcaConsultaLocalidade {
    private JPanel panel;
    private JScrollPane scroll;
    private JTable table1;
    private JButton okButton;
    private JComboBox cb_nifEmpresa;
    private JComboBox cb_animal;
    private JSpinner spn_dia;
    private JSpinner spn_mes;
    private JSpinner spn_ano;
    private JSpinner spn_hora;
    private JSpinner spn_min;
    private JTextField tb_nif;

    public ClienteMarcaConsultaLocalidade(JFrame frame){
        Repositorio r=Repositorio.getInstance();
        frame = new JFrame("Registo de Clientes");

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model=(DefaultTableModel) table1.getModel();
        model.addColumn("Nome da empresa");
        model.addColumn("Nif da Empresa ");
        model.addColumn("Telefone da empresa");
        model.addColumn("Localidade");

        for(Empresa e:r.getEmpresasLocalidade().keySet()){
            if(r.getEmpresasLocalidade().get(e).equals(r.getCurrentUser().getLocalidade())){
                model.addRow(new Object[] {e.getNomeEmpresa(),e.getNif(),e.getTelefone(),e.getLocalidade()});
            }
        }
        clickOK();
    }

    public void clickOK(){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nif=0;
                try{
                    nif=Integer.parseInt(tb_nif.getText());
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Não pode introduzir letras no nif");
                }
            }
        });
    }
}
