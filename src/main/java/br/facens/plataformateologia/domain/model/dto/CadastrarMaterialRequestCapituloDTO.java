package br.facens.plataformateologia.domain.model.dto;

import br.facens.plataformateologia.domain.model.entity.EstudoCapituloEntity;
import br.facens.plataformateologia.domain.model.entity.ParagrafoEntity;

import java.util.List;

public class CadastrarMaterialRequestCapituloDTO {
    private String titulo;
    private String descricao;
    private List<CadastrarMaterialRequestParagrafoDTO> paragrafos;
    private List<CadastrarMaterialRequestEstudoDTO> estudos;
    private int sequencia;

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

    public List<CadastrarMaterialRequestParagrafoDTO> getParagrafos() {
        return paragrafos;
    }

    public void setParagrafos(List<CadastrarMaterialRequestParagrafoDTO> paragrafos) {
        this.paragrafos = paragrafos;
    }

    public List<CadastrarMaterialRequestEstudoDTO> getEstudos() {
        return estudos;
    }

    public void setEstudos(List<CadastrarMaterialRequestEstudoDTO> estudos) {
        this.estudos = estudos;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }
}
