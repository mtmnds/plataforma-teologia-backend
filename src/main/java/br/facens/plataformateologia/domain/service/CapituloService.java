package br.facens.plataformateologia.domain.service;

import br.facens.plataformateologia.domain.model.dto.CapituloDetalheDTO;
import br.facens.plataformateologia.domain.model.entity.CapituloEntity;

public interface CapituloService {
    CapituloDetalheDTO buscarCapitulo(String capituloId);
}
