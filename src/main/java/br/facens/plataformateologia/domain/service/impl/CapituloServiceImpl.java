package br.facens.plataformateologia.domain.service.impl;

import br.facens.plataformateologia.domain.model.builder.impl.CapituloDetalheDtoBuilderImpl;
import br.facens.plataformateologia.domain.model.dto.CapituloDetalheDTO;
import br.facens.plataformateologia.domain.model.entity.CapituloEntity;
import br.facens.plataformateologia.domain.repository.CapituloRepository;
import br.facens.plataformateologia.domain.service.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CapituloServiceImpl implements CapituloService {

    private CapituloRepository capituloRepository;

    @Autowired
    public CapituloServiceImpl(
            CapituloRepository capituloRepository
    ) {
        this.capituloRepository = capituloRepository;
    }

    @Override
    public CapituloDetalheDTO buscarCapitulo(String capituloId) {
        CapituloEntity capitulo = this.capituloRepository
                .findById(UUID.fromString(capituloId))
                .orElseThrow();

        if (capitulo.getMaterial() == null) {
            throw new NoSuchElementException();
        }

        return new CapituloDetalheDtoBuilderImpl()
                .capituloId(capitulo.getId().toString())
                .materialId(capitulo.getMaterial().getId().toString())
                .tituloMaterial(capitulo.getMaterial().getTitulo())
                .tituloCapitulo(capitulo.getTitulo())
                .sequencia(capitulo.getSequencia())
                .paragrafos(capitulo.getParagrafos())
                .build();
    }

}
