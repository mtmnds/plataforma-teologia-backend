package br.facens.plataformateologia.domain.service.impl;

import br.facens.plataformateologia.domain.model.builder.impl.EstudoBlockchainDtoBuilderImpl;
import br.facens.plataformateologia.domain.model.dto.EstudoBlockchainDTO;
import br.facens.plataformateologia.domain.model.entity.EstudoEntity;
import br.facens.plataformateologia.domain.model.entity.EstudoParagrafoEntity;
import br.facens.plataformateologia.domain.repository.EstudoParagrafoRepository;
import br.facens.plataformateologia.domain.repository.EstudoRepository;
import br.facens.plataformateologia.domain.service.BlockchainService;
import br.facens.plataformateologia.domain.service.EstudoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EstudoServiceImpl implements EstudoService {

    private EstudoRepository estudoRepository;
    private EstudoParagrafoRepository estudoParagrafoRepository;
    private BlockchainService blockchainService;

    @Autowired
    public EstudoServiceImpl(
            EstudoRepository estudoRepository,
            EstudoParagrafoRepository estudoParagrafoRepository,
            BlockchainService blockchainService
    ) {
        this.estudoRepository = estudoRepository;
        this.estudoParagrafoRepository = estudoParagrafoRepository;
        this.blockchainService = blockchainService;
    }

    @Override
    public List<EstudoEntity> salvarEstudos(List<EstudoEntity> estudos) {
        return this.estudoRepository.saveAll(estudos);
    }

    @Override
    public List<EstudoParagrafoEntity> salvarEstudosParagrafo(List<EstudoParagrafoEntity> estudosParagrafo) {
        return this.estudoParagrafoRepository.saveAll(estudosParagrafo);
    }

    @Override
    @Transactional
    public void aprovarEstudo(String estudoId) throws NoSuchAlgorithmException, JsonProcessingException {
        EstudoEntity estudoEntity = this.estudoRepository
                .findById(UUID.fromString(estudoId))
                .orElseThrow();

        EstudoBlockchainDTO estudoBlockchainDTO = new EstudoBlockchainDtoBuilderImpl()
                .id(estudoEntity.getId().toString())
                .titulo(estudoEntity.getTitulo())
                .conteudo(estudoEntity.getConteudo())
                .dataPublicacao(estudoEntity.getDataPublicacao())
                .build();

        String blockId = this.blockchainService.addBlock(estudoBlockchainDTO);
        estudoEntity.setBlockchainId(blockId);
        estudoEntity.setAprovado(true);
        estudoEntity.setDataAprovacao(new Date());
        this.estudoRepository.save(estudoEntity);
    }
}
