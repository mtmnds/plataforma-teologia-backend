package br.facens.plataformateologia.domain.model.mapper;

import br.facens.plataformateologia.domain.model.blockchain.GenericBlock;
import br.facens.plataformateologia.domain.model.dto.GenericBlockchainBlockDTO;
import br.facens.plataformateologia.domain.model.entity.BlockchainEntity;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BlockchainMapperTest {

    @Test
    void map() throws NoSuchAlgorithmException {
        Date dataTeste = new Date();

        GenericBlockchainBlockDTO blockDtoToMap = new GenericBlockchainBlockDTO();
        blockDtoToMap.setHash("Hash Teste");
        blockDtoToMap.setPreviousHash("Previous hash teste");
        blockDtoToMap.setData("Conteudo teste");
        blockDtoToMap.setNonce(7);
        blockDtoToMap.setTimestamp(dataTeste.getTime());

        GenericBlock toMap = new GenericBlock(blockDtoToMap);
        toMap.getBlockDto().setHash(toMap.calculateHash());
        toMap.mineBlock(1);

        BlockchainMapper mapper = new BlockchainMapper();
        BlockchainEntity blockEntity = mapper.map(toMap);

        assertEquals(blockEntity.getHash(), toMap.getBlockDto().getHash());
        assertEquals(blockEntity.getPreviousHash(), toMap.getBlockDto().getPreviousHash());
        assertEquals(blockEntity.getData(), toMap.getBlockDto().getData());
        assertEquals(blockEntity.getNonce(), toMap.getBlockDto().getNonce());
        assertEquals(blockEntity.getTimestamp(), toMap.getBlockDto().getTimestamp());
    }

}