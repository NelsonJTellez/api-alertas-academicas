package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.controller;
import co.edu.uptc.alertas_tempranas_ecaes.application.port.DocentePort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Docente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docente")
@RequiredArgsConstructor
@Tag(name = "Docentes", description = "Gestión de docentes")
public class DocenteController {

    private final DocentePort docentePort;

    @GetMapping
    @Operation(summary = "Listar todos los docentes")
    public ResponseEntity<List<Docente>> listarTodos() {
        return ResponseEntity.ok(docentePort.findAll());
    }

    @GetMapping("/{cedula}")
    @Operation(summary = "Buscar docente por cédula")
    public ResponseEntity<Docente> buscarPorCedula(@PathVariable Long cedula) {
        return docentePort.findById(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nuevo docente")
    public ResponseEntity<Docente> crear(@RequestBody Docente docente) {
        Docente docenteCreado = docentePort.save(docente);
        return ResponseEntity.status(HttpStatus.CREATED).body(docenteCreado);
    }

    @PutMapping("/{cedula}")
    @Operation(summary = "Actualizar docente existente")
    public ResponseEntity<Docente> actualizar(
            @PathVariable Long cedula,
            @RequestBody Docente docente) {

        if (!docentePort.existsById(cedula)) {
            return ResponseEntity.notFound().build();
        }

        docente.setCedula(cedula);
        Docente docenteActualizado = docentePort.save(docente);
        return ResponseEntity.ok(docenteActualizado);
    }

    @DeleteMapping("/{cedula}")
    @Operation(summary = "Eliminar docente por cédula")
    public ResponseEntity<Void> eliminar(@PathVariable Long cedula) {
        if (!docentePort.existsById(cedula)) {
            return ResponseEntity.notFound().build();
        }

        docentePort.deleteById(cedula);
        return ResponseEntity.noContent().build();
    }
}
