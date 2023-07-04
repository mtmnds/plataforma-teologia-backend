package br.facens.plataformateologia.domain.model.mapper;

import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestCapituloDTO;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestDTO;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestEstudoDTO;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestParagrafoDTO;
import br.facens.plataformateologia.domain.model.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CadastrarMaterialMapper {

    public MaterialEntity map(CadastrarMaterialRequestDTO requestDTO) {
        MaterialEntity material = new MaterialEntity();
        material.setTitulo(requestDTO.getTitulo());
        material.setDescricao(requestDTO.getDescricao());
        material.setUrlImagem(requestDTO.getUrlImagem());
        material.setDataPublicacao(requestDTO.getDataPublicacao());

        CodigoMaterialEntity codigoMaterial = new CodigoMaterialEntity();
        codigoMaterial.setDescricao(requestDTO.getCodigoMaterial().getDescricao());
        codigoMaterial.setValor(requestDTO.getCodigoMaterial().getValor());
        material.setCodigoMaterial(codigoMaterial);

        material.setCapitulos(new ArrayList<>());
        for (CadastrarMaterialRequestCapituloDTO capituloRequest : requestDTO.getCapitulos()) {
            CapituloEntity capitulo = new CapituloEntity();
            capitulo.setMaterial(material);
            capitulo.setTitulo(capituloRequest.getTitulo());
            capitulo.setDescricao(capituloRequest.getDescricao());
            capitulo.setSequencia(capituloRequest.getSequencia());

            capitulo.setParagrafos(new ArrayList<>());
            for (CadastrarMaterialRequestParagrafoDTO paragrafoRequest : capituloRequest.getParagrafos()) {
                ParagrafoEntity paragrafo = new ParagrafoEntity();
                paragrafo.setCapitulo(capitulo);
                paragrafo.setTitulo(paragrafoRequest.getTitulo());
                paragrafo.setConteudo(paragrafoRequest.getConteudo());
                paragrafo.setSequencia(paragrafoRequest.getSequencia());

                capitulo.getParagrafos().add(paragrafo);
            }

            material.getCapitulos().add(capitulo);
        }

        return material;
    }

    public List<EstudoEntity> map(List<CadastrarMaterialRequestEstudoDTO> estudosDtos) {
        List<EstudoEntity> estudos = new ArrayList<>();

        for (CadastrarMaterialRequestEstudoDTO estudoDto : estudosDtos) {
            EstudoEntity estudo = new EstudoEntity();
            estudo.setTitulo(estudoDto.getTitulo());
            estudo.setConteudo(estudoDto.getConteudo());
            estudo.setDataPublicacao(estudoDto.getDataPublicacao());
            estudo.setDataAprovacao(estudoDto.getDataAprovacao());
            estudo.setBlockchainId(estudoDto.getBlockchainId());
            estudo.setAprovado(estudoDto.isAprovado());
            estudo.setNomeDoAutor(estudoDto.getNomeDoAutor());
            estudos.add(estudo);
        }

        return estudos;
    }

}
