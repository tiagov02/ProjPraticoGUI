package Repositorio;
import java.io.*;
import java.util.*;
import Entidades.*;

import javax.swing.*;
//VERIFICAR
//https://www.devmedia.com.br/serializacao-de-objetos-em-java/23413

public class RepositorioSerializable {

    /**
                                LEITURA DE DE FICHEIROS
     */
    public static void writeBin() {
        writeEmpresas();
        writeProdutos();
        writeAnimais();
        writeUsers();
        writeEmpresasTipo();
        writeEmpresasLocalidade();
        writeConsultas();
        writeTiposConsultas();
        writeDadosDiag();
    }
    public static void writeUsers(){
        File file = new File("users.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getUsers());
            objOutput.close();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null,"Houve um erro: "+erro.getMessage());
        }
    }
    public static void writeEmpresas(){
        File file = new File("empresas.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getEmpresas());
            objOutput.close();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null,"Houve um erro: "+erro.getMessage());
        }
    }
    public static void writeProdutos(){
        File file = new File("produtos.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getProdutos());
            objOutput.close();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null,"Houve um erro: "+erro.getMessage());
        }
    }
    public static void writeAnimais(){
        File file = new File("animais.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getAnimais());
            objOutput.close();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null,"Houve um erro: "+erro.getMessage());
        }
    }

    public static void writeEmpresasLocalidade(){
        File file = new File("empresaslocalidade.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getEmpresasLocalidade());
            objOutput.close();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null,"Houve um erro: "+erro.getMessage());
        }
    }

    public static void writeEmpresasTipo(){
        File file = new File("empresastipo.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getEmpresasTipo());
            objOutput.close();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null,"Houve um erro: "+erro.getMessage());
        }
    }

    public static void writeConsultas(){
        File file = new File("consultas.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getConsultas());
            objOutput.close();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null,"Houve um erro: "+erro.getMessage());
        }
    }

    public static void writeTiposConsultas(){
        File file = new File("tipoconsultas.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getTiposConsultas());
            objOutput.close();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null,"Houve um erro: "+erro.getMessage());
        }
    }

    public static void writeDadosDiag(){
        File file = new File("dadosDiag.dat");
        try {
            file.delete();
            file.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
            objOutput.writeObject(Repositorio.getInstance().getDadosDiag());
            objOutput.close();

        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null,"Houve um erro: "+erro.getMessage());
        }
    }
    //---------------------------------------------------------------------------------------------------------

    public static void readBin(){
        readAnimais();
        readProdutos();
        readEmpresas();
        readUsers();
        readEmpresasLocalidade();
        readEmpresasTipo();
        readConsultas();
    }

    public static void readUsers() {
        List<User> users=new ArrayList<>();
        try {
            File file = new File("users.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                users = (List<User>)objInput.readObject();
                objInput.close();
            }
        }
        catch(ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null,"Erro: "+erro2.getMessage());
            return;
        }
        //
        catch(IOException erro) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro.getMessage());
            return;
        }
        Repositorio.getInstance().setUsers(users);
    }

    public static void readEmpresas() {
        List<Empresa> empresas=new ArrayList<>();
        try {
            File file = new File("empresas.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                empresas = (List<Empresa>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null,"Erro: "+erro2.getMessage());
        }
        Repositorio.getInstance().setEmpresas(empresas);
    }

    public static void readProdutos() {
        Map<Integer,ProdutoServico> produtos=new HashMap<>();
        try {
            File file = new File("produtos.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                produtos = (Map<Integer,ProdutoServico>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null,"Erro: "+erro2.getMessage());
        }
        Repositorio.getInstance().setProdutos(produtos);
    }

    public static void readAnimais() {
        List<Animal> animais=new ArrayList<>();
        try {
            File file = new File("animais.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                animais = (List<Animal>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null,"Erro: "+erro2.getMessage());
        }
        Repositorio.getInstance().setAnimais(animais);
    }
    public static void readEmpresasLocalidade() {
        Map<Empresa,String> empresasLocalidade=new HashMap<>();
        try {
            File file = new File("empresaslocalidade.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                empresasLocalidade = (Map<Empresa,String>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null,"Erro: "+erro2.getMessage());
        }
        Repositorio.getInstance().setEmpresasLocalidade(empresasLocalidade);
    }

    public static void readEmpresasTipo() {
        Map<Empresa,TipoConsulta> empresasTipo=new HashMap<>();
        try {
            File file = new File("empresastipo.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                empresasTipo = (Map<Empresa,TipoConsulta>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null,"Erro: "+erro2.getMessage());
        }
        Repositorio.getInstance().setEmpresasTipo(empresasTipo);
    }

    public static void readConsultas() {
        List<Consulta> consultas=new ArrayList<>();
        try {
            File file = new File("consultas.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                consultas = (List<Consulta>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null,"Erro: "+erro2.getMessage());
        }
        Repositorio.getInstance().setConsultas(consultas);
    }

    public static void readTiposConsulta() {
        List<TipoConsulta> tipo=new ArrayList<>();
        try {
            File file = new File("dadosDiag.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                tipo = (List<TipoConsulta>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null,"Erro: "+erro2.getMessage());
        }
        Repositorio.getInstance().setTiposConsultas(tipo);
    }

    public static void readDadosDiag() {
        List<DadosDiag> dadosDiag=new ArrayList<>();
        try {
            File file = new File("dadosDiag.dat");
            if (file.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
                dadosDiag = (List<DadosDiag>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException erro1) {
            JOptionPane.showMessageDialog(null,"Erro: "+ erro1.getMessage());
        } catch(ClassNotFoundException erro2) {
            JOptionPane.showMessageDialog(null,"Erro: "+erro2.getMessage());
        }
        Repositorio.getInstance().setDadosDiag(dadosDiag);
    }
}

