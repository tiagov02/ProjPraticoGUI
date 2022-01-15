package GUI;

import Entidades.Empresa;
import Entidades.User;
import Entidades.UserFuncionario;
import Exceptions.AlteracaoDadosException;
import MetodosLogicos.DonoEmpresaMetodos;
import Repositorio.Repositorio;
import Repositorio.RepositorioSerializable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class DonoEmpresaAlteraFuncionario2 {
    private JPanel panel;
    private JTextField tb_username;
    private JTextField tb_numCC;
    private JTextField tb_nif;
    private JTextField tb_telefone;
    private JTextField tb_morada;
    private JPasswordField tb_password;
    private JTextField tb_localidade;
    private JTextField tb_salario;
    private JSpinner spn_minInicio;
    private JSpinner spn_horInicio;
    private JSpinner spn_horFim;
    private JSpinner spn_minFim;
    private JButton buttonback;
    private JButton buttonLimpar;
    private JButton buttonok;
    private JTextField tb_nome;

    public DonoEmpresaAlteraFuncionario2(JFrame frame, UserFuncionario f, Empresa empresa){
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        tb_username.setText(f.getUsername());
        tb_password.setText(null);
        tb_nome.setText(f.getNome());
        tb_numCC.setText(String.valueOf(f.getNumCC()));
        tb_nif.setText(String.valueOf(f.getNIF()));
        tb_telefone.setText(String.valueOf(f.getTelefone()));
        tb_morada.setText(f.getMorada());
        tb_localidade.setText(f.getLocalidade());
        tb_salario.setText(String.valueOf(f.getSalario()));
        spn_horInicio.setModel(new SpinnerNumberModel(f.getHoraIni().getHours(),0,23,1));
        spn_minInicio.setModel(new SpinnerNumberModel(f.getHoraIni().getMinutes(),0,59,1));
        spn_horFim.setModel(new SpinnerNumberModel(f.getHoraFim().getHours(),0,23,1));
        spn_minFim.setModel(new SpinnerNumberModel(f.getHoraFim().getMinutes(),0,59,1));
        clickOk(frame,f);
        voltarAtras(frame, empresa);
        LimparSENecessario();
    }

    public void clickOk(JFrame frame,UserFuncionario f){
        buttonok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nif=0,telefone=0,numCC=0;
                float salario=0;
                String username=tb_username.getText();
                String passwd=tb_password.getText();
                String nome=tb_nome.getText();
                String morada=tb_morada.getText();
                String localidade=tb_localidade.getText();
                int horaIni=(int) spn_horInicio.getValue();
                int minInicio=(int) spn_minInicio.getValue();
                int horaFim=(int) spn_horFim.getValue();
                int minFim=(int) spn_minFim.getValue();

                try{
                    nif=Integer.parseInt(tb_telefone.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Não pode introduzir letras no NIF!");
                }
                try{
                    telefone=Integer.parseInt(tb_telefone.getText());
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Não pode introduzir letras no telefone!!");
                }
                try{
                    numCC=Integer.parseInt(tb_numCC.getText());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Não pode introduzir letras no numero de CC!!");
                }
                try{
                    salario=Float.parseFloat(tb_salario.getText());
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Não pode introduzir letras no salário!!");
                }

                f.setNIF(nif);
                f.setTelefone(telefone);
                f.setNumCC(numCC);
                f.setSalario(salario);
                f.setUsername(username);
                f.setPasswd(passwd);
                f.setNome(nome);
                f.setMorada(morada);
                f.setLocalidade(localidade);
                f.setHoraIni(new Time(horaIni,minInicio,0));
                f.setHoraFim(new Time(horaFim,minFim,0));
                try{
                    DonoEmpresaMetodos.alterarDadosFuncionario(f);
                    JOptionPane.showMessageDialog(null,"SUCESSO!!");
                    panel.setVisible(false);
                    new DonoEmpresaRegistado(frame);
                }
                catch(AlteracaoDadosException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }
    public void voltarAtras(JFrame frame, Empresa empresa){
        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                new DonoEmpresaAlteraFuncionario(frame, empresa);
            }
        });
    }

    public void LimparSENecessario(){
        buttonLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tb_salario.setText(null);
                tb_localidade.setText(null);
                tb_morada.setText(null);
                tb_telefone.setText(null);
                tb_nif.setText(null);
                tb_password.setText(null);
                tb_nome.setText(null);
                tb_username.setText(null);
                tb_numCC.setText(null);
            }
        });
    }
}
