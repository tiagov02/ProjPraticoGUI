package Repositorio;
import java.io.*;
import java.util.*;
import Entidades.*;
//VERIFICAR
//https://www.devmedia.com.br/serializacao-de-objetos-em-java/23413

public class RepositorioSerializable {
    public static void gravarBin(Repositorio repo) {
        File arq = new File("DataPetBeauty.dat");
        try {
            //arq.delete();
            //arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(repo);
            objOutput.close();

        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }
}

