package br.facens.plataformateologia.domain.model.dto;

public class CadastrarMaterialRequestCodigoDTO {
    private String descricao;
    private String valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
