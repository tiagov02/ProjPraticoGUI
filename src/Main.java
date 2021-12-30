
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

public class Main {
    public static void main(String[] args) {
        //RegistoAnonimo newReg= new RegistoAnonimo();
        //newReg.setVisible(true);
        //new RegistoAnonimo();
        //new RegistoCliente();
        //new RegistoDonoEmpresa();
        Repositorio r=new Repositorio();
        JFrame frame= new JFrame();

        frame = new JFrame("PetBeauty- Registo de animais de estimação");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(350, 350));
        frame.setResizable(false);
        new Login(frame,r.getUsers());
    }
}


