package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.controller;

import co.edu.uptc.alertas_tempranas_ecaes.application.service.ConsultaContextoService;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contexto")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContextoController {

    private final ConsultaContextoService contextoService;

    // ============ FLUJO EN CASCADA DEL FORMULARIO ============

    // Paso 1: Listar CREADs
    @GetMapping("/creads")
    public ResponseEntity<List<CreadDTO>> listarCreads() {
        return ResponseEntity.ok(contextoService.listarCreads());
    }

    // GET /api/contexto/creads/1
    @GetMapping("/creads/{id}")
    public ResponseEntity<CreadDTO> obtenerCread(@PathVariable Integer id) {
        return ResponseEntity.ok(contextoService.obtenerCreadPorId(id));
    }


    // Paso 2: Listar Programas (con CREAD incluido)
    @GetMapping("/programas")
    public ResponseEntity<List<ProgramaDTO>> listarProgramas() {
        return ResponseEntity.ok(contextoService.listarProgramas());
    }

    @GetMapping("/programas/{id}")
    public ResponseEntity<ProgramaDTO> obtenerPrograma(@PathVariable Integer id) {
        return ResponseEntity.ok(contextoService.obtenerProgramaPorId(id));
    }

    // Paso 3: Listar Semestres (con Programa y CREAD incluidos)
    @GetMapping("/semestres/programa/{idPrograma}")
    public ResponseEntity<List<SemestreDTO>> listarSemestresPorPrograma(@PathVariable Integer idPrograma) {
        return ResponseEntity.ok(contextoService.listarSemestresPorPrograma(idPrograma));
    }

    // Paso 4: Listar Asignaturas (con toda la ruta hasta CREAD)
    @GetMapping("/asignaturas/semestre/{idSemestre}")
    public ResponseEntity<List<AsignaturaDTO>> listarAsignaturasPorSemestre(@PathVariable Integer idSemestre) {
        return ResponseEntity.ok(contextoService.listarAsignaturasPorSemestre(idSemestre));
    }

    // Paso 5: Listar Actividades (con toda la jerarquía completa)
    @GetMapping("/actividades/asignatura/{codAsignatura}")
    public ResponseEntity<List<ActividadDTO>> listarActividadesPorAsignatura(@PathVariable Integer codAsignatura) {
        return ResponseEntity.ok(contextoService.listarActividadesPorAsignatura(codAsignatura));
    }

    // ============ ENDPOINT ESPECIAL: CONTEXTO COMPLETO ============

    // Obtener el contexto completo de una actividad seleccionada
    // Útil para validar antes de enviar el formulario
    @GetMapping("/completo/actividad/{idActividad}")
    public ResponseEntity<ContextoCompletoDTO> obtenerContextoCompleto(@PathVariable Integer idActividad) {
        return ResponseEntity.ok(contextoService.obtenerContextoCompleto(idActividad));
    }

}
