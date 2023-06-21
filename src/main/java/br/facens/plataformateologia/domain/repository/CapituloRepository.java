package br.facens.plataformateologia.domain.repository;

import br.facens.plataformateologia.domain.model.entity.CapituloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CapituloRepository extends JpaRepository<CapituloEntity, UUID> {}
