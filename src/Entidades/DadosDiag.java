package Entidades;
import java.io.Serializable;
import java.util.*;
public class DadosDiag implements Serializable {
    private String descricaoDiag;
    private Date dataHoraDiag;
    private int nMicro;

    public DadosDiag(String descricaoDiag, Date dataHoraDiag,int nMicro) {
        this.descricaoDiag = descricaoDiag;
        this.dataHoraDiag = dataHoraDiag;
        this.nMicro=nMicro;
    }

    public String getDescricaoDiag() {
        return descricaoDiag;
    }

    public void setDescricaoDiag(String descricaoDiag) {
        this.descricaoDiag = descricaoDiag;
    }

    public Date getDataHoraDiag() {
        return dataHoraDiag;
    }

    public void setDataHoraDiag(Date dataHoraDiag) {
        this.dataHoraDiag = dataHoraDiag;
    }

    public int getnMicro() {
        return nMicro;
    }
}
