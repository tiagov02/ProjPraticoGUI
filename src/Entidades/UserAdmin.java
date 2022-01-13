package Entidades;
public class UserAdmin extends User {
    private static final long serialVersionsUID = 453245632234L;

    public UserAdmin(String username, String passwd, String nome, int numCC, int NIF, int telefone, String morada, String localidade) {
        super(username, passwd, nome, numCC, NIF, telefone, morada, localidade);
    }
}

