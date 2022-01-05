
import Entidades.*;
import Estados.*;
import Exceptions.*;
import GUI.*;
//import Login.*;
import GUI.Login;
import MetodosLogicos.*;
import Repositorio.*;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //RegistoAnonimo newReg= new RegistoAnonimo();
        //newReg.setVisible(true);
        //new RegistoAnonimo();
        //new RegistoCliente();
        //new RegistoDonoEmpresa();


        Repositorio r = Repositorio.getInstance();
        JFrame frame= new JFrame();
        RepositorioSerializable.readBin();
        if(r.getUsers().isEmpty()){
            r.getUsers().add(new UserAdmin("admin","admin","Administrador PetBeauty",0,0,
                    0,"Viana do Castelo","IPVC_ESTG"));
            RepositorioSerializable.writeUsers();

        }
        /*for(User u: r.getUsers()){
            System.out.println("username: "+u.getUsername());
            System.out.println("Pwd: "+u.getPasswd());
        }*/
        //r.getUsers().add(new UserCliente("cliente", "cliente", "cliente", 123, 123, 123, "1223", "1223"));
        //r.getAnimais().add(new Animal(123, "animal", "cao", "cao", new Date(), "cliente"));

        frame = new JFrame("PetBeauty- Gestão de Marcações e Consultas de Animais de Estimação");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(true);
        new Login(frame);
    }
}


