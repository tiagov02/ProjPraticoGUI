package Entidades;
import java.sql.Time;
import java.util.*;
import Estados.*;

public class Consulta {
    private Date dataHoraConsulta;
    private float precoTotal;
    private Date dataHoraPagamento;
    private Date dataMarcacao;
    private EstadoConsulta estado;
    private TipoConsulta tipoConsulta;

    //neste recoloquei sem paramentros, pq ao marcar a consulta não fica logo associado o restante
    //dos valores,como a data de pagamento
    //para mercar consulta vamos pelo setDataMarcacao
    public Consulta(){}

    public Date getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Date dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
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

}
