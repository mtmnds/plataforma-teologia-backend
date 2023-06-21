package br.facens.plataformateologia.domain.model.dto;

import java.util.List;

public class MaterialDetalheDTO {

    private String id;
    private String titulo;
    private String urlImagem;
    private List<String> descricao;
    private List<GenericCapituloDTO> capitulos;

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

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public List<String> getDescricao() {
        return descricao;
    }

    public void setDescricao(List<String> descricao) {
        this.descricao = descricao;
    }

    public List<GenericCapituloDTO> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<GenericCapituloDTO> capitulos) {
        this.capitulos = capitulos;
    }

}
