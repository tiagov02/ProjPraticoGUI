package Entidades;
public class TipoConsulta {
    private String descricao;
    private float precoEsp;

    public TipoConsulta(String descricao, float precoEsp) {
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
}
