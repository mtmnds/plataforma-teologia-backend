package br.facens.plataformateologia.application.controller;

import br.facens.plataformateologia.domain.service.EstudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("estudo")
public class EstudoController {

    private EstudoService estudoService;

    @Autowired
    public EstudoController(
            EstudoService estudoService
    ) {
        this.estudoService = estudoService;
    }

    @RequestMapping(
            value = "/aprovar/{estudoId}",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<Void> aprovarEstudo(
            @PathVariable("estudoId") String estudoId
    ) {
        try {
            this.estudoService.aprovarEstudo(estudoId);
            return ResponseEntity.ok().build();
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
