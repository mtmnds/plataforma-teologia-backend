package br.facens.plataformateologia.domain.model.dto;

public class GenericMaterialListDTO {

    private String id;
    private String titulo;
    private String descricao;
    private String urlImagem;
    private int numPagina;
    private int qtdRegistros;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public int getQtdRegistros() {
        return qtdRegistros;
    }

    public void setQtdRegistros(int qtdRegistros) {
        this.qtdRegistros = qtdRegistros;
    }
}
