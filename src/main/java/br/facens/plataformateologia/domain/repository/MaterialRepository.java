package br.facens.plataformateologia.domain.repository;

import br.facens.plataformateologia.domain.model.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, UUID> {
    List<MaterialEntity> findAllByOrderByDataPublicacaoDesc();
}
