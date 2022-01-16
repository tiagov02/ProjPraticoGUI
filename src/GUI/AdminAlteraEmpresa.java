package GUI;

import Entidades.Empresa;
import MetodosLogicos.AdminMetodos;
import Repositorio.Repositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAlteraEmpresa {
    private JPanel panel1;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton eliminarButton;
    private JButton backButton;
    private JButton alterarButton;
    private JComboBox comboBoxNIF;

  public AdminAlteraEmpresa(JFrame frame){
      frame.add(panel1);
      frame.pack();
      frame.setVisible(true);
      DefaultTableModel model = (DefaultTableModel) table1.getModel();
      table1.setModel(model);
      model.addColumn("Nome empresa");
      model.addColumn("Dono Empresa");
      model.addColumn("Localidade");
      model.addColumn("NIF");
      model.addColumn("NPorta");
      model.addColumn("Telefone");
      for (Empresa empresa : Repositorio.getInstance().getEmpresas()){
          model.addRow(new Object[] {empresa.getNomeEmpresa(), empresa.getUserDono(),
                  empresa.getLocalidade(), empresa.getNif(), empresa.getnPorta(), empresa.getTelefone()});
          comboBox1.addItem(empresa.getNif());
      }
      voltaratras(frame);
      alterarEmpresaAdmin(frame);
      adminRemoveEmpresa(frame);
  }

  public void voltaratras(JFrame frame){
      backButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              panel1.setVisible(false);
              new AdminRegistado(frame);
          }
      });
  }

  public void alterarEmpresaAdmin(JFrame frame){
      alterarButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              int nifempresa=(int) comboBox1.getSelectedItem();
              Empresa emp = AdminMetodos.AdminselectEmpresaporNif(nifempresa);
              panel1.setVisible(false);
              new AdminAlteraEmpresa2(frame, emp);
          }
      });
  }

  public void adminRemoveEmpresa(JFrame frame){
      eliminarButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              int nif  = (int) comboBox1.getSelectedItem();
              Empresa emp = AdminMetodos.selectEmpresaNIF(nif);
              AdminMetodos.removeEmpresa(emp);
              JOptionPane.showMessageDialog(null, "Empresa removida com sucesso!");
              panel1.setVisible(false);
              new AdminRegistado(frame);
          }
      });
  }


}
