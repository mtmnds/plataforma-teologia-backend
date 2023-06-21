package br.facens.plataformateologia.application.controller;

import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialRequestDTO;
import br.facens.plataformateologia.domain.model.dto.CadastrarMaterialResponseDTO;
import br.facens.plataformateologia.domain.model.dto.GenericMaterialListDTO;
import br.facens.plataformateologia.domain.model.dto.MaterialDetalheDTO;
import br.facens.plataformateologia.domain.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("material")
public class MaterialController {

    private MaterialService materialService;

    @Autowired
    public MaterialController(
            MaterialService materialService
    ) {
        this.materialService = materialService;
    }

    @RequestMapping(
            value = "/home",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<List<GenericMaterialListDTO>> listarMateriaisParaAHomePage() {
        try {
            return ResponseEntity.ok(this.materialService.listarMateriaisParaAHomePage());
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(
            value = {"", "/"},
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<List<GenericMaterialListDTO>> listarMateriaisPaginacao(
            @RequestParam int numPagina,
            @RequestParam int qtdRegistros
    ) {
        try {
            return ResponseEntity.ok(this.materialService.listarMateriaisPaginacao(numPagina, qtdRegistros));
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(
            value = "/{materialId}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<MaterialDetalheDTO> buscarDetalhesDoMaterial(
            @PathVariable("materialId") String materialId
    ) {
        try {
            return ResponseEntity.ok(this.materialService.buscarDetalhesDoMaterial(materialId));
        }
        catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(
            value = {"", "/"},
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<CadastrarMaterialResponseDTO> cadastrarMaterial(
            @RequestBody CadastrarMaterialRequestDTO requestDto
    ) {
        try {
            return ResponseEntity.ok(this.materialService.cadastrar(requestDto));
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
