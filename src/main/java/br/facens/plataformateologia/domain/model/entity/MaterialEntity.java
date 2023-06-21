package br.facens.plataformateologia.domain.model.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "material")
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_codigo", referencedColumnName = "id")
    private CodigoMaterialEntity codigoMaterial;

    @Column(name = "descricao", nullable = false, length = 30000)
    private String descricao;

    @Column(name = "data_publicacao", nullable = false)
    private Date dataPublicacao;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<CapituloEntity> capitulos;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<EstudoMaterialEntity> estudos;

    @Column(name = "url_imagem", nullable = false)
    private String urlImagem;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public CodigoMaterialEntity getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(CodigoMaterialEntity codigoMaterial) {
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

    public List<CapituloEntity> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<CapituloEntity> capitulos) {
        this.capitulos = capitulos;
    }

    public List<EstudoMaterialEntity> getEstudos() {
        return estudos;
    }

    public void setEstudos(List<EstudoMaterialEntity> estudos) {
        this.estudos = estudos;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
