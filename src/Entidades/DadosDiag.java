package Entidades;
import java.util.*;
public class DadosDiag {
    private String descricaoDiag;
    private Date dataHoraDiag;

    public DadosDiag(String descricaoDiag, Date dataHoraDiag) {
        this.descricaoDiag = descricaoDiag;
        this.dataHoraDiag = dataHoraDiag;
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
}
