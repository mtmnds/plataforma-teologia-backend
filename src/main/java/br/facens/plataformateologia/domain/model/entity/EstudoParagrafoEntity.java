package br.facens.plataformateologia.domain.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "estudo_paragrafo")
public class EstudoParagrafoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "paragrafo_id")
    private ParagrafoEntity paragrafo;

    @ManyToOne
    @JoinColumn(name = "estudo_id")
    private EstudoEntity estudo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ParagrafoEntity getParagrafo() {
        return paragrafo;
    }

    public void setParagrafo(ParagrafoEntity paragrafo) {
        this.paragrafo = paragrafo;
    }

    public EstudoEntity getEstudo() {
        return estudo;
    }

    public void setEstudo(EstudoEntity estudo) {
        this.estudo = estudo;
    }
}
