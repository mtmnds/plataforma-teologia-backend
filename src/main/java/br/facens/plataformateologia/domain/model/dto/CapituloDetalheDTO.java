package br.facens.plataformateologia.domain.model.dto;

import java.util.List;

public class CapituloDetalheDTO {

    private String capituloId;
    private String materialId;
    private String tituloMaterial;
    private String tituloCapitulo;
    private int sequencia;
    List<GenericParagrafoDTO> paragrafos;

    public String getCapituloId() {
        return capituloId;
    }

    public void setCapituloId(String capituloId) {
        this.capituloId = capituloId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getTituloMaterial() {
        return tituloMaterial;
    }

    public void setTituloMaterial(String tituloMaterial) {
        this.tituloMaterial = tituloMaterial;
    }

    public String getTituloCapitulo() {
        return tituloCapitulo;
    }

    public void setTituloCapitulo(String tituloCapitulo) {
        this.tituloCapitulo = tituloCapitulo;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public List<GenericParagrafoDTO> getParagrafos() {
        return paragrafos;
    }

    public void setParagrafos(List<GenericParagrafoDTO> paragrafos) {
        this.paragrafos = paragrafos;
    }
}
