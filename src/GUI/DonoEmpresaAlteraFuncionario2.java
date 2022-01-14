package GUI;

import Entidades.User;
import Entidades.UserFuncionario;
import Repositorio.Repositorio;
import Repositorio.RepositorioSerializable;

import javax.swing.*;

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

    public DonoEmpresaAlteraFuncionario2(JFrame frame, UserFuncionario f){
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
        for(User u: Repositorio.getInstance().getUsers()){
            if(u.getNIF()==f.getNIF()){
                //setters
                //fica atualizado!
            }
        }
    }
}
