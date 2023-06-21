package br.facens.plataformateologia.domain.service.impl;

import br.facens.plataformateologia.domain.model.builder.CadastrarMaterialResponseBuilder;
import br.facens.plataformateologia.domain.model.builder.MaterialDetalheDtoBuilder;
import br.facens.plataformateologia.domain.model.builder.impl.CadastrarMaterialResponseBuilderImpl;
import br.facens.plataformateologia.domain.model.builder.impl.GenericMaterialListDtoBuilderImpl;
import br.facens.plataformateologia.domain.model.builder.impl.MaterialDetalheDtoBuilderImpl;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestDTO;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialResponseDTO;
import br.facens.plataformateologia.domain.model.dto.GenericMaterialListDTO;
import br.facens.plataformateologia.domain.model.dto.MaterialDetalheDTO;
import br.facens.plataformateologia.domain.model.entity.MaterialEntity;
import br.facens.plataformateologia.domain.model.mapper.CadastrarMaterialMapper;
import br.facens.plataformateologia.domain.repository.MaterialRepository;
import br.facens.plataformateologia.domain.service.MaterialService;
import br.facens.plataformateologia.domain.service.StringUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MaterialServiceImpl implements MaterialService {

    private MaterialRepository materialRepository;
    private StringUtilsService stringUtilsService;
    private CadastrarMaterialMapper cadastrarMaterialMapper;

    @Autowired
    public MaterialServiceImpl(
            MaterialRepository materialRepository,
            StringUtilsService stringUtilsService,
            CadastrarMaterialMapper cadastrarMaterialMapper
    ) {
        this.materialRepository = materialRepository;
        this.stringUtilsService = stringUtilsService;
        this.cadastrarMaterialMapper = cadastrarMaterialMapper;
    }

    public List<GenericMaterialListDTO> listarMateriaisParaAHomePage() {
        List<MaterialEntity> materiais = materialRepository.findAllByOrderByDataPublicacaoDesc();
        materiais = materiais.subList(0, Math.min(6, materiais.size()));
        return materiais
                .stream()
                .map(item -> new GenericMaterialListDtoBuilderImpl()
                            .id(item.getId().toString())
                            .titulo(item.getTitulo())
                            .descricao(stringUtilsService.limitStringTo100char(item.getDescricao()))
                            .urlImagem(item.getUrlImagem())
                            .numPagina(1)
                            .qtdRegistros(6)
                            .build()
                )
                .toList();
    }

    public List<GenericMaterialListDTO> listarMateriaisPaginacao(int numPagina, int qtdRegistros) {
        List<MaterialEntity> materiais = materialRepository.findAllByOrderByDataPublicacaoDesc();

        if (materiais.size() == 0) {
            return new ArrayList<>();
        }

        int inicio = (numPagina - 1) * qtdRegistros;
        int fim = inicio + qtdRegistros + 1;

        if (materiais.size() > inicio) {
            materiais = materiais.subList(inicio, Math.min(fim, materiais.size()));
        }
        else {
            throw new RuntimeException("Página não encontrada.");
        }

        return materiais
                .stream()
                .map(item -> new GenericMaterialListDtoBuilderImpl()
                        .id(item.getId().toString())
                        .titulo(item.getTitulo())
                        .descricao(stringUtilsService.limitStringTo100char(item.getDescricao()))
                        .urlImagem(item.getUrlImagem())
                        .numPagina(numPagina)
                        .qtdRegistros(qtdRegistros)
                        .build()
                )
                .toList();
    }

    @Override
    public MaterialDetalheDTO buscarDetalhesDoMaterial(String materialId) {
        MaterialEntity material = materialRepository
                .findById(UUID.fromString(materialId))
                .orElseThrow();

        return new MaterialDetalheDtoBuilderImpl()
                .id(material.getId().toString())
                .titulo(material.getTitulo())
                .urlImagem(material.getUrlImagem())
                .descricao(material.getDescricao())
                .capitulos(material.getCapitulos())
                .build();
    }

    @Override
    public CadastrarMaterialResponseDTO cadastrar(CadastrarMaterialRequestDTO requestDto) {
        MaterialEntity material = cadastrarMaterialMapper.map(requestDto);
        materialRepository.save(material);
        return new CadastrarMaterialResponseBuilderImpl()
                .id(material.getId().toString())
                .build();
    }
}
