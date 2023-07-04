package br.facens.plataformateologia.domain.service.impl;

import br.facens.plataformateologia.domain.model.blockchain.GenericBlock;
import br.facens.plataformateologia.domain.model.builder.impl.GenericBlockchainBlockDtoBuilderImpl;
import br.facens.plataformateologia.domain.model.dto.EstudoBlockchainDTO;
import br.facens.plataformateologia.domain.model.dto.GenericBlockchainBlockDTO;
import br.facens.plataformateologia.domain.model.entity.BlockchainEntity;
import br.facens.plataformateologia.domain.model.entity.EstudoEntity;
import br.facens.plataformateologia.domain.model.mapper.BlockchainMapper;
import br.facens.plataformateologia.domain.repository.BlockchainRepository;
import br.facens.plataformateologia.domain.service.BlockchainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Date;

@Service
public class SimpleBlockchainServiceImpl implements BlockchainService {

    private BlockchainRepository blockchainRepository;
    private BlockchainMapper blockchainMapper;

    @Autowired
    public SimpleBlockchainServiceImpl(
            BlockchainRepository blockchainRepository,
            BlockchainMapper blockchainMapper
    ) {
        this.blockchainRepository = blockchainRepository;
        this.blockchainMapper = blockchainMapper;
    }

    public String addBlock(EstudoBlockchainDTO estudoBlockchainDTO) throws JsonProcessingException, NoSuchAlgorithmException {
        String blockData = new ObjectMapper().writeValueAsString(estudoBlockchainDTO);

        BlockchainEntity lastBlock = this.blockchainRepository
                .findAll()
                .stream()
                .min(new Comparator<BlockchainEntity>() {
                    @Override
                    public int compare(BlockchainEntity o1, BlockchainEntity o2) {
                        long dif = o2.getTimestamp() - o1.getTimestamp();
                        return (int) dif;
                    }
                })
                .orElse(null);

        GenericBlockchainBlockDTO newBlockInfo = new GenericBlockchainBlockDtoBuilderImpl()
                .previousHash(lastBlock != null ? lastBlock.getHash() : null)
                .data(blockData)
                .timestamp(new Date().getTime())
                .nonce(0)
                .build();

        GenericBlock block = new GenericBlock(newBlockInfo);
        block.getBlockDto().setHash(block.calculateHash());
        block.mineBlock(1);
        BlockchainEntity blockEntity = blockchainMapper.map(block);
        blockchainRepository.save(blockEntity);
        return blockEntity.getId().toString();
    }

}
