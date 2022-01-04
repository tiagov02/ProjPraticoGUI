package Entidades;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pagamento implements Serializable {
    private int idPagamento;
    private Date HoraPagamento;
    private int numCliente;
    List<UserCliente> clientes;

    public Pagamento(int idPagamento, Date horaPagamento, int numCliente, List<UserCliente> clientes) {
        this.idPagamento = idPagamento;
        HoraPagamento = horaPagamento;
        this.numCliente = numCliente;
        this.clientes = clientes;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Date getHoraPagamento() {
        return HoraPagamento;
    }

    public void setHoraPagamento(Date horaPagamento) {
        HoraPagamento = horaPagamento;
    }

    public List<UserCliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<UserCliente> clientes) {
        this.clientes = clientes;
    }
}
