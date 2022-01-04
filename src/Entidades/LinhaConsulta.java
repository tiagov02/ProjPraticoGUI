package Entidades;

import java.io.Serializable;

public class LinhaConsulta implements Serializable {
    private float precoTotal;
    private int qtd;
    private ProdutoServico produto;

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public ProdutoServico getProduto() {
        return produto;
    }

    public void setProduto(ProdutoServico produto) {
        this.produto = produto;
    }

    public float getPrecoTotal(){
        return (this.qtd*this.produto.getPreco());
    }
}
