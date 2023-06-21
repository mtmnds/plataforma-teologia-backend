package br.facens.plataformateologia.domain.model.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "estudo")
public class EstudoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "conteudo", nullable = false)
    private String conteudo;

    @Column(name = "data_publicacao", nullable = false)
    private Date dataPublicacao;

    // TODO: Definir objeto para o autor
    // private Object autor;

    @Column(name = "data_aprovacao", nullable = false)
    private Date dataAprovacao;

    @Column(name = "blockchain_id", nullable = true)
    private String blockchainId;

    @Column(name = "aprovado", nullable = false)
    private boolean aprovado;

    @OneToMany(mappedBy = "estudo")
    private List<EstudoMaterialEntity> materiais;

    @OneToMany(mappedBy = "estudo")
    private List<EstudoCapituloEntity> capitulos;

    @OneToMany(mappedBy = "estudo")
    private List<EstudoParagrafoEntity> paragrafos;

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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getBlockchainId() {
        return blockchainId;
    }

    public void setBlockchainId(String blockchainId) {
        this.blockchainId = blockchainId;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public List<EstudoMaterialEntity> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<EstudoMaterialEntity> materiais) {
        this.materiais = materiais;
    }

    public List<EstudoCapituloEntity> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<EstudoCapituloEntity> capitulos) {
        this.capitulos = capitulos;
    }

    public List<EstudoParagrafoEntity> getParagrafos() {
        return paragrafos;
    }

    public void setParagrafos(List<EstudoParagrafoEntity> paragrafos) {
        this.paragrafos = paragrafos;
    }
}
