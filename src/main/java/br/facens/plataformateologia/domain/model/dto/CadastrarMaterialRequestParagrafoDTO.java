package br.facens.plataformateologia.domain.model.dto;

import br.facens.plataformateologia.domain.model.entity.EstudoParagrafoEntity;

import java.util.List;

public class CadastrarMaterialRequestParagrafoDTO {
    private String titulo;
    private String conteudo;
    private List<CadastrarMaterialRequestEstudoDTO> estudos;
    private int sequencia;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
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
