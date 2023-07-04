package br.facens.plataformateologia.domain.model.blockchain;

import br.facens.plataformateologia.domain.model.dto.GenericBlockchainBlockDTO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenericBlock {

    private GenericBlockchainBlockDTO blockDto;

    public GenericBlock(
            GenericBlockchainBlockDTO blockDto
    ) {
        this.blockDto = blockDto;
    }

    public String calculateHash() throws NoSuchAlgorithmException {
        String dataToHash = blockDto.getPreviousHash() +
                blockDto.getTimestamp() +
                blockDto.getNonce() +
                blockDto.getData();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));

        StringBuilder buffer = new StringBuilder();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }

        return buffer.toString();
    }


    public String mineBlock(int prefix) throws NoSuchAlgorithmException {
        String prefixString = new String(new char[prefix]).replace('\0', '0');

        while (!blockDto.getHash().substring(0, prefix).equals(prefixString)) {
            this.incrementNonce();
            blockDto.setHash(this.calculateHash());
        }

        return blockDto.getHash();
    }


    private void incrementNonce() {
        int nonce = blockDto.getNonce() + 1;
        blockDto.setNonce(nonce);
    }


    public GenericBlockchainBlockDTO getBlockDto() {
        return blockDto;
    }

    public void setBlockDto(GenericBlockchainBlockDTO blockDto) {
        this.blockDto = blockDto;
    }

}
