package br.facens.plataformateologia.domain.model.dto;

import br.facens.plataformateologia.domain.model.entity.EstudoCapituloEntity;

import java.util.Date;
import java.util.List;

public class CadastrarMaterialRequestDTO {
    private String titulo;
    private CadastrarMaterialRequestCodigoDTO codigoMaterial;
    private String descricao;
    private Date dataPublicacao;
    private List<CadastrarMaterialRequestCapituloDTO> capitulos;
    private List<CadastrarMaterialRequestEstudoDTO> estudos;
    private String urlImagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public CadastrarMaterialRequestCodigoDTO getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(CadastrarMaterialRequestCodigoDTO codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<CadastrarMaterialRequestCapituloDTO> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<CadastrarMaterialRequestCapituloDTO> capitulos) {
        this.capitulos = capitulos;
    }

    public List<CadastrarMaterialRequestEstudoDTO> getEstudos() {
        return estudos;
    }

    public void setEstudos(List<CadastrarMaterialRequestEstudoDTO> estudos) {
        this.estudos = estudos;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
