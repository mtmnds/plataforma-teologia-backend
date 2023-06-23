package br.facens.plataformateologia.domain.model.builder.impl;

import br.facens.plataformateologia.domain.model.dto.CapituloDetalheDTO;
import br.facens.plataformateologia.domain.model.entity.ParagrafoEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CapituloDetalheDtoBuilderImplTest {

    @Test
    void builder() {
        UUID uuid = UUID.randomUUID();

        List<ParagrafoEntity> paragrafos = new ArrayList<>();
        for (int p = 0; p < 10; p++) {
            ParagrafoEntity paragrafo = new ParagrafoEntity();
            paragrafo.setId(uuid);
            paragrafo.setTitulo(String.format("Titulo paragrafo teste %d", p));
            paragrafo.setConteudo("Linha 1<br>Linha 2<br>Linha 3");
            paragrafo.setSequencia(p);
            paragrafos.add(paragrafo);
        }

        CapituloDetalheDTO dto = new CapituloDetalheDtoBuilderImpl()
                .capituloId("Id capitulo teste")
                .materialId("Id material teste")
                .tituloMaterial("Titulo material teste")
                .tituloCapitulo("Titulo capitulo teste")
                .sequencia(7)
                .paragrafos(paragrafos)
                .build();

        assertNotNull(dto);
        assertEquals(dto.getCapituloId(), "Id capitulo teste");
        assertEquals(dto.getMaterialId(), "Id material teste");
        assertEquals(dto.getTituloMaterial(), "Titulo material teste");
        assertEquals(dto.getTituloCapitulo(), "Titulo capitulo teste");

        assertNotNull(dto.getParagrafos());
        assertEquals(dto.getParagrafos().size(), 10);
        assertEquals(dto.getParagrafos().get(7).getId(), uuid.toString());
        assertEquals(dto.getParagrafos().get(7).getTitulo(), "Titulo paragrafo teste 7");
        assertEquals(dto.getParagrafos().get(7).getSequencia(), 7);

        assertNotNull(dto.getParagrafos().get(7).getConteudo());
        assertEquals(dto.getParagrafos().get(7).getConteudo().size(), 3);
        assertEquals(dto.getParagrafos().get(7).getConteudo().get(0), "Linha 1");
        assertEquals(dto.getParagrafos().get(7).getConteudo().get(1), "Linha 2");
        assertEquals(dto.getParagrafos().get(7).getConteudo().get(2), "Linha 3");
    }
}