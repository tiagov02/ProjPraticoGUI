package Entidades;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pagamento implements Serializable {
    private Date HoraPagamento;
    private UserCliente cliente;
    private Empresa empresa;

    public Pagamento(Date horaPagamento, UserCliente cliente, Empresa empresa) {
        HoraPagamento = horaPagamento;
        this.cliente = cliente;
        this.empresa = empresa;
    }

    public Date getHoraPagamento() {
        return HoraPagamento;
    }

    public void setHoraPagamento(Date horaPagamento) {
        HoraPagamento = horaPagamento;
    }

    public UserCliente getCliente() {
        return cliente;
    }

    public void setCliente(UserCliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
