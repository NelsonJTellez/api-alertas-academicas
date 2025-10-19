package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.controller;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.EstudiantePort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Estudiante;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
@RequiredArgsConstructor
@Tag(name = "Estudiantes", description = "Gestión de estudiantes")
public class EstudianteController {

    private final EstudiantePort estudiantePort;

    @GetMapping
    @Operation(summary = "Listar todos los estudiantes")
    public ResponseEntity<List<Estudiante>> listarTodos() {
        return ResponseEntity.ok(estudiantePort.findAll());
    }

    @GetMapping("/{codigo}")
    @Operation(summary = "Buscar estudiante por código")
    public ResponseEntity<Estudiante> buscarPorCodigo(@PathVariable Integer codigo) {
        return estudiantePort.findById(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nuevo estudiante")
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante) {
        Estudiante estudianteCreado = estudiantePort.save(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }

    @PutMapping("/{codigo}")
    @Operation(summary = "Actualizar estudiante existente")
    public ResponseEntity<Estudiante> actualizar(
            @PathVariable Integer codigo,
            @RequestBody Estudiante estudiante) {

        if (!estudiantePort.existsById(codigo)) {
            return ResponseEntity.notFound().build();
        }

        estudiante.setCodigo(codigo);
        Estudiante estudianteActualizado = estudiantePort.save(estudiante);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @DeleteMapping("/{codigo}")
    @Operation(summary = "Eliminar estudiante por código")
    public ResponseEntity<Void> eliminar(@PathVariable Integer codigo) {
        if (!estudiantePort.existsById(codigo)) {
            return ResponseEntity.notFound().build();
        }

        estudiantePort.deleteById(codigo);
        return ResponseEntity.noContent().build();
    }
}
