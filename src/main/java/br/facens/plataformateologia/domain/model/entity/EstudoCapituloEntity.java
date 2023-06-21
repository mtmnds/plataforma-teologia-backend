package br.facens.plataformateologia.domain.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "estudo_capitulo")
public class EstudoCapituloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "capitulo_id")
    private CapituloEntity capitulo;

    @ManyToOne
    @JoinColumn(name = "estudo_id")
    private EstudoEntity estudo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CapituloEntity getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(CapituloEntity capitulo) {
        this.capitulo = capitulo;
    }

    public EstudoEntity getEstudo() {
        return estudo;
    }

    public void setEstudo(EstudoEntity estudo) {
        this.estudo = estudo;
    }
}
