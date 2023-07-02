package br.facens.plataformateologia.domain.service.impl;

import br.facens.plataformateologia.domain.model.entity.EstudoEntity;
import br.facens.plataformateologia.domain.model.entity.EstudoParagrafoEntity;
import br.facens.plataformateologia.domain.repository.EstudoParagrafoRepository;
import br.facens.plataformateologia.domain.repository.EstudoRepository;
import br.facens.plataformateologia.domain.service.EstudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstudoServiceImpl implements EstudoService {

    private EstudoRepository estudoRepository;
    private EstudoParagrafoRepository estudoParagrafoRepository;

    @Autowired
    public EstudoServiceImpl(
            EstudoRepository estudoRepository,
            EstudoParagrafoRepository estudoParagrafoRepository
    ) {
        this.estudoRepository = estudoRepository;
        this.estudoParagrafoRepository = estudoParagrafoRepository;
    }

    @Override
    public List<EstudoEntity> salvarEstudos(List<EstudoEntity> estudos) {
        return this.estudoRepository.saveAll(estudos);
    }

    @Override
    public List<EstudoParagrafoEntity> salvarEstudosParagrafo(List<EstudoParagrafoEntity> estudosParagrafo) {
        return this.estudoParagrafoRepository.saveAll(estudosParagrafo);
    }
}
