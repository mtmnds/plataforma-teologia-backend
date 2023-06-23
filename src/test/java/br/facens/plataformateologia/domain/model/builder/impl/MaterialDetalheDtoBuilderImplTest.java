package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.MaterialDetalheDTO;
import br.facens.plataformateologia.domain.model.entity.CapituloEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MaterialDetalheDtoBuilderImplTest {

    @Test
    void builder() {
        UUID uuid = UUID.randomUUID();

        List<CapituloEntity> capitulos = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            CapituloEntity capitulo = new CapituloEntity();
            capitulo.setId(uuid);
            capitulo.setTitulo(String.format("Titulo teste %d", c));
            capitulo.setSequencia(c);
            capitulos.add(capitulo);
        }

        MaterialDetalheDTO dto = new MaterialDetalheDtoBuilderImpl()
                .id("ID Teste")
                .titulo("Titulo teste")
                .urlImagem("URL teste")
                .descricao("Linha 1<br>Linha 2<br>Linha 3")
                .capitulos(capitulos)
                .build();

        assertNotNull(dto);
        assertEquals(dto.getId(), "ID Teste");
        assertEquals(dto.getTitulo(), "Titulo teste");
        assertEquals(dto.getUrlImagem(), "URL teste");

        assertNotNull(dto.getDescricao());
        assertEquals(dto.getDescricao().size(), 3);
        assertEquals(dto.getDescricao().get(0), "Linha 1");
        assertEquals(dto.getDescricao().get(1), "Linha 2");
        assertEquals(dto.getDescricao().get(2), "Linha 3");

        assertNotNull(dto.getCapitulos());
        assertEquals(dto.getCapitulos().size(), 10);
        assertEquals(dto.getCapitulos().get(7).getId(), uuid.toString());
        assertEquals(dto.getCapitulos().get(7).getTitulo(), "Titulo teste 7");
        assertEquals(dto.getCapitulos().get(7).getSequencia(), 7);
    }

}