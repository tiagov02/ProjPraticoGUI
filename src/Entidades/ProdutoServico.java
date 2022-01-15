package Entidades;

import java.io.Serializable;

public class ProdutoServico implements Serializable {
    private int id;
    private String descricao;
    private float preco;
    private int nifEmpresa;

    public ProdutoServico(String descricao, float preco,int nifEmpresa, int id) {
        this.id=id;
        this.nifEmpresa=nifEmpresa;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getNifEmpresa() {
        return nifEmpresa;
    }

    public void setNifEmpresa(int nifEmpresa) {
        this.nifEmpresa = nifEmpresa;
    }
}
