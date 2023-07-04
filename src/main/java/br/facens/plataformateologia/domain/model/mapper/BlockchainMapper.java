package br.facens.plataformateologia.domain.model.mapper;

import br.facens.plataformateologia.domain.model.blockchain.GenericBlock;
import br.facens.plataformateologia.domain.model.entity.BlockchainEntity;
import org.springframework.stereotype.Component;

@Component
public class BlockchainMapper {

    public BlockchainEntity map(GenericBlock genericBlock) {
        BlockchainEntity blockchainEntity = new BlockchainEntity();
        blockchainEntity.setHash(genericBlock.getBlockDto().getHash());
        blockchainEntity.setPreviousHash(genericBlock.getBlockDto().getPreviousHash());
        blockchainEntity.setData(genericBlock.getBlockDto().getData());
        blockchainEntity.setTimestamp(genericBlock.getBlockDto().getTimestamp());
        blockchainEntity.setNonce(genericBlock.getBlockDto().getNonce());

        return blockchainEntity;
    }

}
