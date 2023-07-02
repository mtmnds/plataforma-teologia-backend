package br.facens.plataformateologia.domain.model.dto;

import java.util.List;

public class GenericParagrafoDTO {

    private String id;
    private String titulo;
    private List<String> conteudo;
    private List<GenericEstudoParagrafoDTO> estudos;
    private int sequencia;

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

    public List<String> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<String> conteudo) {
        this.conteudo = conteudo;
    }

    public List<GenericEstudoParagrafoDTO> getEstudos() {
        return estudos;
    }

    public void setEstudos(List<GenericEstudoParagrafoDTO> estudos) {
        this.estudos = estudos;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }
}
