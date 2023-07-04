package br.facens.plataformateologia.domain.repository;

import br.facens.plataformateologia.domain.model.entity.BlockchainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlockchainRepository extends JpaRepository<BlockchainEntity, UUID> {
}
