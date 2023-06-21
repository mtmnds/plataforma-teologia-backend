package br.facens.plataformateologia.domain.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "paragrafo")
public class ParagrafoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    private CapituloEntity capitulo;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "conteudo", nullable = false)
    private String conteudo;

    @OneToMany(mappedBy = "paragrafo", cascade = CascadeType.ALL)
    private List<EstudoParagrafoEntity> estudos;

    @Column(name = "sequencia", nullable = false)
    private int sequencia;

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

    public List<EstudoParagrafoEntity> getEstudos() {
        return estudos;
    }

    public void setEstudos(List<EstudoParagrafoEntity> estudos) {
        this.estudos = estudos;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }
}
