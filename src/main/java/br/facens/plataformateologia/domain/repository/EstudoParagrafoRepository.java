package br.facens.plataformateologia.domain.repository;

import br.facens.plataformateologia.domain.model.entity.EstudoParagrafoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstudoParagrafoRepository extends JpaRepository<EstudoParagrafoEntity, UUID> {
}
