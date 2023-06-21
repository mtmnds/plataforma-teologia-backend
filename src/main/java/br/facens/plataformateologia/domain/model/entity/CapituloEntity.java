package br.facens.plataformateologia.domain.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "capitulo")
public class CapituloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    private MaterialEntity material;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "capitulo", cascade = CascadeType.ALL)
    private List<ParagrafoEntity> paragrafos;

    @OneToMany(mappedBy = "capitulo", cascade = CascadeType.ALL)
    private List<EstudoCapituloEntity> estudos;

    @Column(name = "sequencia", nullable = false)
    private int sequencia;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
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

    public List<ParagrafoEntity> getParagrafos() {
        return paragrafos;
    }

    public void setParagrafos(List<ParagrafoEntity> paragrafos) {
        this.paragrafos = paragrafos;
    }

    public List<EstudoCapituloEntity> getEstudos() {
        return estudos;
    }

    public void setEstudos(List<EstudoCapituloEntity> estudos) {
        this.estudos = estudos;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }
}
