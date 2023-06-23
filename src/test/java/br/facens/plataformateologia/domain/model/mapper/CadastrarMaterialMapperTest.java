package br.facens.plataformateologia.domain.model.mapper;

import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestCapituloDTO;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestCodigoDTO;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestDTO;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestParagrafoDTO;
import br.facens.plataformateologia.domain.model.entity.MaterialEntity;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CadastrarMaterialMapperTest {

    @Test
    void map() {
        Date dataTeste = new Date();

        CadastrarMaterialRequestDTO toMap = new CadastrarMaterialRequestDTO();
        toMap.setTitulo("Titulo teste");
        toMap.setDescricao("Descricao teste");
        toMap.setDataPublicacao(dataTeste);
        toMap.setUrlImagem("URL teste");

        CadastrarMaterialRequestCodigoDTO codigoMaterial = new CadastrarMaterialRequestCodigoDTO();
        codigoMaterial.setDescricao("Codigo teste");
        codigoMaterial.setValor("Valor teste");
        toMap.setCodigoMaterial(codigoMaterial);

        List<CadastrarMaterialRequestCapituloDTO> capitulos = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            CadastrarMaterialRequestCapituloDTO capitulo = new CadastrarMaterialRequestCapituloDTO();
            capitulo.setTitulo(String.format("Titulo capitulo teste %d", c));
            capitulo.setDescricao(String.format("Descricao capitulo teste %d", c));
            capitulo.setSequencia(c);

            List<CadastrarMaterialRequestParagrafoDTO> paragrafos = new ArrayList<>();
            for (int p = 0; p < 10; p++) {
                CadastrarMaterialRequestParagrafoDTO paragrafo = new CadastrarMaterialRequestParagrafoDTO();
                paragrafo.setTitulo(String.format("Titulo paragrafo teste %d", p));
                paragrafo.setConteudo(String.format("Descricao paragrafo teste %d", p));
                paragrafo.setSequencia(p);
                paragrafos.add(paragrafo);
            }

            capitulo.setParagrafos(paragrafos);
            capitulos.add(capitulo);
        }

        toMap.setCapitulos(capitulos);

        CadastrarMaterialMapper mapper = new CadastrarMaterialMapper();
        MaterialEntity mapped = mapper.map(toMap);

        assertEquals(toMap.getTitulo(), mapped.getTitulo());
        assertEquals(toMap.getDescricao(), mapped.getDescricao());
        assertEquals(toMap.getDataPublicacao(), mapped.getDataPublicacao());
        assertEquals(toMap.getUrlImagem(), mapped.getUrlImagem());

        assertNotNull(mapped.getCodigoMaterial());
        assertEquals(toMap.getCodigoMaterial().getDescricao(), mapped.getCodigoMaterial().getDescricao());
        assertEquals(toMap.getCodigoMaterial().getValor(), mapped.getCodigoMaterial().getValor());

        assertNotNull(mapped.getCapitulos());
        assertEquals(mapped.getCapitulos().size(), 10);
        assertEquals(mapped.getCapitulos().get(7).getTitulo(), "Titulo capitulo teste 7");
        assertEquals(mapped.getCapitulos().get(7).getDescricao(), "Descricao capitulo teste 7");
        assertEquals(mapped.getCapitulos().get(7).getSequencia(), 7);

        assertNotNull(mapped.getCapitulos().get(7).getParagrafos());
        assertEquals(mapped.getCapitulos().get(7).getParagrafos().size(), 10);
        assertEquals(mapped.getCapitulos().get(7).getParagrafos().get(5).getTitulo(), "Titulo paragrafo teste 5");
        assertEquals(mapped.getCapitulos().get(7).getParagrafos().get(5).getConteudo(), "Descricao paragrafo teste 5");
        assertEquals(mapped.getCapitulos().get(7).getParagrafos().get(5).getSequencia(), 5);
    }
}