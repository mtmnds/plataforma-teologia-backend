package br.facens.plataformateologia.application.controller;

import br.facens.plataformateologia.domain.model.dto.CapituloDetalheDTO;
import br.facens.plataformateologia.domain.service.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("capitulo")
public class CapituloController {

    private CapituloService capituloService;

    @Autowired
    public CapituloController(
            CapituloService capituloService
    ) {
        this.capituloService = capituloService;
    }

    @RequestMapping(
            value = "/{capituloId}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<CapituloDetalheDTO> buscarDetalhesDoCapitulo(
            @PathVariable("capituloId") String capituloId
    ) {
        try {
            return ResponseEntity.ok(this.capituloService.buscarCapitulo(capituloId));
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
