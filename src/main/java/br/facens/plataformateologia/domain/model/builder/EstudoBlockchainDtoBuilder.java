package br.facens.plataformateologia.domain.model.builder;

import br.facens.plataformateologia.domain.model.dto.EstudoBlockchainDTO;

import java.util.Date;

public interface EstudoBlockchainDtoBuilder {
    EstudoBlockchainDtoBuilder id(String id);
    EstudoBlockchainDtoBuilder titulo(String titulo);
    EstudoBlockchainDtoBuilder conteudo(String conteudo);
    EstudoBlockchainDtoBuilder dataPublicacao(Date dataPublicacao);
    EstudoBlockchainDTO build();
}
