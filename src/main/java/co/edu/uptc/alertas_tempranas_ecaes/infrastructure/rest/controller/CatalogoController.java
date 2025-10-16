package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.controller;


import co.edu.uptc.alertas_tempranas_ecaes.application.service.ConsultaCatalogoService;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.CatalogoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogoController {

    private final ConsultaCatalogoService catalogoService;

    @GetMapping("/situaciones")
    public ResponseEntity<List<CatalogoDTO>> listarSituaciones() {
        return ResponseEntity.ok(catalogoService.listarSituaciones());
    }

    @GetMapping("/acciones")
    public ResponseEntity<List<CatalogoDTO>> listarAcciones() {
        return ResponseEntity.ok(catalogoService.listarAcciones());
    }

    @GetMapping("/gestiones")
    public ResponseEntity<List<CatalogoDTO>> listarGestiones() {
        return ResponseEntity.ok(catalogoService.listarGestiones());
    }

    @GetMapping("/resultados")
    public ResponseEntity<List<CatalogoDTO>> listarResultados() {
        return ResponseEntity.ok(catalogoService.listarResultados());
    }

    @GetMapping("/seguimientos")
    public ResponseEntity<List<CatalogoDTO>> listarTiposSeguimiento() {
        return ResponseEntity.ok(catalogoService.listarTiposSeguimiento());
    }
}
