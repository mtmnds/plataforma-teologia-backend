package br.facens.plataformateologia.domain.service;

import br.facens.plataformateologia.domain.model.entity.EstudoEntity;
import br.facens.plataformateologia.domain.model.entity.EstudoParagrafoEntity;

import java.util.List;

public interface EstudoService {
    List<EstudoEntity> salvarEstudos(List<EstudoEntity> estudos);

    List<EstudoParagrafoEntity> salvarEstudosParagrafo(List<EstudoParagrafoEntity> estudosParagrafo);
}
