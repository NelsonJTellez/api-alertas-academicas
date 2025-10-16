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
@CrossOrigin(origins = "http://localhost:4200")
public class ContextoController {

    private final ConsultaContextoService contextoService;

    @GetMapping("/creads")
    public ResponseEntity<List<CreadDTO>> listarCreads() {
        return ResponseEntity.ok(contextoService.listarCreads());
    }

    @GetMapping("/creads/{idCread}")
    public ResponseEntity<CreadDTO> obtenerCread(@PathVariable Integer idCread) {
        return ResponseEntity.ok(contextoService.obtenerCreadPorId(idCread));
    }

    @GetMapping("/creads/{idCread}/programas")
    public ResponseEntity<List<ProgramaDTO>> listarProgramasPorCread(@PathVariable Integer idCread) {
        return ResponseEntity.ok(contextoService.listarProgramasPorCread(idCread));
    }

    @GetMapping("/programas/{idPrograma}")
    public ResponseEntity<ProgramaDTO> obtenerPrograma(@PathVariable Integer idPrograma) {
        return ResponseEntity.ok(contextoService.obtenerProgramaPorId(idPrograma));
    }

    @GetMapping("/creads/{idCread}/programas/{idPrograma}/semestres")
    public ResponseEntity<List<SemestreDTO>> listarSemestresPorCreadPrograma(
        @PathVariable Integer idCread,
        @PathVariable Integer idPrograma) {
        return ResponseEntity.ok(contextoService.listarSemestresPorCreadPrograma(idCread, idPrograma));
    }

    // NUEVO: Obtener un semestre específico bajo la jerarquía
    @GetMapping("/creads/{idCread}/programas/{idPrograma}/semestres/{idSemestre}")
    public ResponseEntity<SemestreDTO> obtenerSemestreJerarquico(
        @PathVariable Integer idCread,
        @PathVariable Integer idPrograma,
        @PathVariable Integer idSemestre) {
        return ResponseEntity.ok(contextoService.obtenerSemestreJerarquico(idCread, idPrograma, idSemestre));
    }

    @GetMapping("/creads/{idCread}/programas/{idPrograma}/semestres/{idSemestre}/asignaturas")
    public ResponseEntity<List<AsignaturaDTO>> listarAsignaturasPorCreadProgramaSemestre(
        @PathVariable Integer idCread,
        @PathVariable Integer idPrograma,
        @PathVariable Integer idSemestre) {
        return ResponseEntity.ok(contextoService.listarAsignaturasPorCreadProgramaSemestre(idCread, idPrograma, idSemestre));
    }

    // NUEVO: Obtener una asignatura específica bajo la jerarquía
    @GetMapping("/creads/{idCread}/programas/{idPrograma}/semestres/{idSemestre}/asignaturas/{codAsignatura}")
    public ResponseEntity<AsignaturaDTO> obtenerAsignaturaJerarquica(
        @PathVariable Integer idCread,
        @PathVariable Integer idPrograma,
        @PathVariable Integer idSemestre,
        @PathVariable Integer codAsignatura) {
        return ResponseEntity.ok(contextoService.obtenerAsignaturaJerarquica(idCread, idPrograma, idSemestre, codAsignatura));
    }

    @GetMapping("/creads/{idCread}/programas/{idPrograma}/semestres/{idSemestre}/asignaturas/actividades")
    public ResponseEntity<List<ActividadDTO>> listarActividadesPorCreadProgramaSemestre(
        @PathVariable Integer idCread,
        @PathVariable Integer idPrograma,
        @PathVariable Integer idSemestre) {
        return ResponseEntity.ok(contextoService.listarActividadesPorCreadProgramaSemestre(idCread, idPrograma, idSemestre));
    }

    @GetMapping("/creads/{idCread}/programas/{idPrograma}/semestres/{idSemestre}/asignaturas/{codAsignatura}/actividades")
    public ResponseEntity<List<ActividadDTO>> listarActividadesPorCreadProgramaSemestreAsignatura(
        @PathVariable Integer idCread,
        @PathVariable Integer idPrograma,
        @PathVariable Integer idSemestre,
        @PathVariable Integer codAsignatura) {
        return ResponseEntity.ok(contextoService.listarActividadesPorCreadProgramaSemestreAsignatura(idCread, idPrograma, idSemestre, codAsignatura));
    }

    @GetMapping("/creads/{idCread}/programas/{idPrograma}/semestres/{idSemestre}/asignaturas/{codAsignatura}/actividades/{idActividad}")
public ResponseEntity<ActividadDTO> obtenerActividadJerarquica(
    @PathVariable Integer idCread,
    @PathVariable Integer idPrograma,
    @PathVariable Integer idSemestre,
    @PathVariable Integer codAsignatura,
    @PathVariable Integer idActividad) {
    return ResponseEntity.ok(contextoService.obtenerActividadJerarquica(idCread, idPrograma, idSemestre, codAsignatura, idActividad));
}


}
