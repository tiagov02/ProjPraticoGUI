package Entidades;

import java.io.Serializable;

public class TipoConsulta implements Serializable {
    private String descricao;
    private float precoEsp;
    private int idTipo;

    public TipoConsulta(String descricao, float precoEsp,int idTipo) {
        this.idTipo=idTipo;
        this.descricao = descricao;
        this.precoEsp = precoEsp;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPrecoEsp() {
        return precoEsp;
    }

    public void setPrecoEsp(float precoEsp) {
        this.precoEsp = precoEsp;
    }

    public int getIdTipo() {
        return idTipo;
    }
}
