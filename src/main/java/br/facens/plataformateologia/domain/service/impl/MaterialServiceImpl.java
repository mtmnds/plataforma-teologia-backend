package br.facens.plataformateologia.domain.service.impl;

import br.facens.plataformateologia.domain.model.builder.CadastrarMaterialResponseBuilder;
import br.facens.plataformateologia.domain.model.builder.MaterialDetalheDtoBuilder;
import br.facens.plataformateologia.domain.model.builder.impl.CadastrarMaterialResponseBuilderImpl;
import br.facens.plataformateologia.domain.model.builder.impl.GenericMaterialListDtoBuilderImpl;
import br.facens.plataformateologia.domain.model.builder.impl.MaterialDetalheDtoBuilderImpl;
import br.facens.plataformateologia.domain.model.dto.*;
import br.facens.plataformateologia.domain.model.entity.*;
import br.facens.plataformateologia.domain.model.mapper.CadastrarMaterialMapper;
import br.facens.plataformateologia.domain.repository.MaterialRepository;
import br.facens.plataformateologia.domain.service.EstudoService;
import br.facens.plataformateologia.domain.service.MaterialService;
import br.facens.plataformateologia.domain.service.StringUtilsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MaterialServiceImpl implements MaterialService {

    private MaterialRepository materialRepository;
    private StringUtilsService stringUtilsService;
    private EstudoService estudoService;
    private CadastrarMaterialMapper cadastrarMaterialMapper;

    @Autowired
    public MaterialServiceImpl(
            MaterialRepository materialRepository,
            StringUtilsService stringUtilsService,
            EstudoService estudoService,
            CadastrarMaterialMapper cadastrarMaterialMapper
    ) {
        this.materialRepository = materialRepository;
        this.stringUtilsService = stringUtilsService;
        this.estudoService = estudoService;
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
    @Transactional
    public CadastrarMaterialResponseDTO cadastrar(CadastrarMaterialRequestDTO requestDto) {
        MaterialEntity material = cadastrarMaterialMapper.map(requestDto);
        materialRepository.save(material);

        Map<String, ParagrafoEntity> hashsParagrafos = new HashMap<>();
        for (CapituloEntity capitulo : material.getCapitulos()) {
            for (ParagrafoEntity paragrafo : capitulo.getParagrafos()) {
                String hash = stringUtilsService.createStringHash(
                        capitulo.getTitulo(),
                        capitulo.getDescricao(),
                        paragrafo.getTitulo(),
                        paragrafo.getConteudo()
                );
                hashsParagrafos.put(hash, paragrafo);
            }
        }

        for (CadastrarMaterialRequestCapituloDTO capituloDTO : requestDto.getCapitulos()) {
            for (CadastrarMaterialRequestParagrafoDTO paragrafoDTO : capituloDTO.getParagrafos()) {
                if (paragrafoDTO.getEstudos() != null && paragrafoDTO.getEstudos().size() > 0) {
                    String hash = stringUtilsService.createStringHash(
                            capituloDTO.getTitulo(),
                            capituloDTO.getDescricao(),
                            paragrafoDTO.getTitulo(),
                            paragrafoDTO.getConteudo()
                    );

                    ParagrafoEntity paragrafoEntity = hashsParagrafos.get(hash);

                    if (paragrafoEntity == null) {
                        continue;
                    }

                    List<CadastrarMaterialRequestEstudoDTO> estudosParagrafoCadastrar = paragrafoDTO.getEstudos();
                    List<EstudoEntity> estudosEntities = cadastrarMaterialMapper.map(estudosParagrafoCadastrar);
                    this.estudoService.salvarEstudos(estudosEntities);

                    List<EstudoParagrafoEntity> estudoParagrafoEntities = new ArrayList<>();
                    for (EstudoEntity estudoEntity : estudosEntities) {
                        EstudoParagrafoEntity estudoParagrafoEntity = new EstudoParagrafoEntity();
                        estudoParagrafoEntity.setEstudo(estudoEntity);
                        estudoParagrafoEntity.setParagrafo(paragrafoEntity);
                        estudoParagrafoEntities.add(estudoParagrafoEntity);
                    }

                    this.estudoService.salvarEstudosParagrafo(estudoParagrafoEntities);
                }
            }
        }

        return new CadastrarMaterialResponseBuilderImpl()
                .id(material.getId().toString())
                .build();
    }
}
