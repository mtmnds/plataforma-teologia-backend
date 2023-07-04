package br.facens.plataformateologia.domain.service;

import br.facens.plataformateologia.domain.model.entity.EstudoEntity;
import br.facens.plataformateologia.domain.model.entity.EstudoParagrafoEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface EstudoService {
    List<EstudoEntity> salvarEstudos(List<EstudoEntity> estudos);
    List<EstudoParagrafoEntity> salvarEstudosParagrafo(List<EstudoParagrafoEntity> estudosParagrafo);
    void aprovarEstudo(String estudoId) throws NoSuchAlgorithmException, JsonProcessingException;
}
