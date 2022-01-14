package Entidades;
import java.io.Serializable;
import java.sql.Time;
import java.util.*;
import Estados.*;

public class Consulta implements Serializable {
    private Date dataHoraConsulta;
    private Date dataHoraPagamento;
    private Date dataMarcacao;
    private EstadoConsulta estado;
    private TipoConsulta tipoConsulta;
    private String userCliente;
    private int nifEmpresa;
    private List <LinhaConsulta> linhas;
    private int nMicro;

    //neste recoloquei sem paramentros, pq ao marcar a consulta não fica logo associado o restante
    //dos valores,como a data de pagamento
    //para mercar consulta vamos pelo setDataMarcacao


    public Consulta(Date dataMarcacao, EstadoConsulta estado, String userCliente, int nifEmpresa,int nMicro) {
        this.dataMarcacao = dataMarcacao;
        this.estado = estado;
        this.userCliente = userCliente;
        this.nifEmpresa = nifEmpresa;
        linhas= new ArrayList<>();
        this.nMicro=nMicro;
    }

    public Date getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Date dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public float getPrecoTotal() {
        int total=0;
        for(LinhaConsulta l: this.linhas){
            total+=getPrecoTotal();
        }
        total+=tipoConsulta.getPrecoEsp();
        return total;
    }

    public Date getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(Date dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }

    public Date getDataMarcacao() {
        return dataMarcacao;
    }

    public void setDataMarcacao(Date dataMarcacao) {
        this.dataMarcacao = dataMarcacao;
    }

    public EstadoConsulta getEstado() {
        return estado;
    }

    public void setEstado(EstadoConsulta estado) {
        this.estado = estado;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
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

    public int getnMicro() {
        return nMicro;
    }

    public void setnMicro(int nMicro) {
        this.nMicro = nMicro;
    }
}
