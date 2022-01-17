package Entidades;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pagamento implements Serializable {
    private Date HoraPagamento;
    private String userCliente;
    private int nifEmpresa;

    public Pagamento(Date horaPagamento, String cliente, int empresa) {
        HoraPagamento = horaPagamento;
        this.userCliente = cliente;
        this.nifEmpresa = empresa;
    }

    public Date getHoraPagamento() {
        return HoraPagamento;
    }

    public void setHoraPagamento(Date horaPagamento) {
        HoraPagamento = horaPagamento;
    }

    public String getUserCliente() {
        return userCliente;
    }

    public void setUserCliente(String userCliente) {
        this.userCliente = userCliente;
    }

    public int getNifEmpresa() {
        return nifEmpresa;
    }

    public void setNifEmpresa(int nifEmpresa) {
        this.nifEmpresa = nifEmpresa;
    }
}

