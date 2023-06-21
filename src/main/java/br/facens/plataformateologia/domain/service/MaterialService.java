package br.facens.plataformateologia.domain.service;

import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestDTO;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialResponseDTO;
import br.facens.plataformateologia.domain.model.dto.GenericMaterialListDTO;
import br.facens.plataformateologia.domain.model.dto.MaterialDetalheDTO;

import java.util.List;
import java.util.Objects;

public interface MaterialService {
    List<GenericMaterialListDTO> listarMateriaisParaAHomePage();
    List<GenericMaterialListDTO> listarMateriaisPaginacao(int numPagina, int qtdRegistros);
    MaterialDetalheDTO buscarDetalhesDoMaterial(String materialId);
    CadastrarMaterialResponseDTO cadastrar(CadastrarMaterialRequestDTO requestDto);
}
