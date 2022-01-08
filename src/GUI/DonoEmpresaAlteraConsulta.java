package GUI;

import Entidades.Consulta;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonoEmpresaAlteraConsulta {
    private JPanel panel1;
    private JTable table1;
    private JTextField textFieldDtConsulta;
    private JTextField textFieldNomeCliente;
    private JButton buttonback;
    private JButton Alterar;
    private JButton buttonLimpar;

    public DonoEmpresaAlteraConsulta(JFrame frame){
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        DefaultTableModel model= (DefaultTableModel)table1.getModel();
        table1.setModel(model);
        model.addColumn("Data Consulta");
        model.addColumn("Estado");
        model.addColumn("Tipo Consulta");
        model.addColumn("Cliente");
        model.addColumn("Hora Pagamento");
        for (Consulta c : Repositorio.getInstance().getConsultas()){
            if (c.getNifEmpresa() == Repositorio.getInstance().getCurrentUser().getNIF()){
                model.addRow(new Object[] {c.getDataHoraConsulta(), c.getEstado(), c.getTipoConsulta(), c.getUserCliente(),c.getDataHoraPagamento()});
            }
        }
        voltaAtras(frame);
        LimpaDados();
    }

    public void voltaAtras(JFrame frame){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
                new DonoEmpresaRegistado(frame);
            }
        });
    }

    public void LimpaDados(){
        buttonLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldDtConsulta.setText(null);   //AQUI TEMOS QUE ADICIONAR DEPOIS AQUILO DOS DIAS
                textFieldNomeCliente.setText(null);
            }
        });
    }

    public void AlteraConsulta(JFrame frame){
        //AQUI SECALHAR METEMOS A RETORNAR PARA O INSERIR CONSULTA
        //FAZEMOS UM DELETE DA CONSULTA SE AS INFORMÇÕES QUE ELES TIVEREM FOREM IGUAIS A ALGUMA INFORMACAO QUE ESTEJA NA LISTA DE CONSULTAS
        //E DEPOIS SE FOR IGUAL METEMOS A FRAME.VISIVEL FALSE E PASSAMOS A FRAME DE INSERCAO DE CONSULTAS A TRUE
    }
}
