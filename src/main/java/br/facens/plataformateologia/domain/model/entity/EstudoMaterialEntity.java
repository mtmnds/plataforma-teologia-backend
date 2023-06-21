package br.facens.plataformateologia.domain.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "estudo_material")
public class EstudoMaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private MaterialEntity material;

    @ManyToOne
    @JoinColumn(name = "estudo_id")
    private EstudoEntity estudo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    public EstudoEntity getEstudo() {
        return estudo;
    }

    public void setEstudo(EstudoEntity estudo) {
        this.estudo = estudo;
    }

}
