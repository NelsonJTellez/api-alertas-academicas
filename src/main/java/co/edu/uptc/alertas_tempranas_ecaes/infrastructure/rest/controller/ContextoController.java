package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.controller;

import co.edu.uptc.alertas_tempranas_ecaes.application.service.ConsultaContextoService;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.*;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.mapper.ContextoDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar consultas y operaciones sobre el contexto académico.
 * Expone endpoints CRUD completos siguiendo la jerarquía: CREAD → Programa → Semestre → Asignatura → Actividad
 * También gestiona Estudiantes, Docentes y Alertas Tempranas.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contexto")
public class ContextoController {

    private final ConsultaContextoService consultaContextoService;
    private final ContextoDtoMapper mapper;

    // ========== CREAD ENDPOINTS ==========

    @GetMapping("/creads")
    public ResponseEntity<List<CreadDTO>> listarCreads() {
        return ResponseEntity.ok(
                mapper.toCreadDTOList(consultaContextoService.listarCread())
        );
    }

    @GetMapping("/creads/{id}")
    public ResponseEntity<CreadDTO> obtenerCreadPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerCreadPorId(id))
        );
    }

    @PostMapping("/creads")
    public ResponseEntity<CreadDTO> crearCread(@Valid @RequestBody CreadDTO creadDTO) {
        var cread = mapper.toDomain(creadDTO);
        var creado = consultaContextoService.crearCread(cread);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(creado));
    }

    @PutMapping("/creads/{id}")
    public ResponseEntity<CreadDTO> actualizarCread(
            @PathVariable Integer id,
            @Valid @RequestBody CreadDTO creadDTO) {
        var cread = mapper.toDomain(creadDTO);
        var actualizado = consultaContextoService.actualizarCread(id, cread);
        return ResponseEntity.ok(mapper.toDTO(actualizado));
    }

    @DeleteMapping("/creads/{id}")
    public ResponseEntity<Void> eliminarCread(@PathVariable Integer id) {
        consultaContextoService.eliminarCread(id);
        return ResponseEntity.noContent().build();
    }

    // ========== PROGRAMA ENDPOINTS ==========

    @GetMapping("/creads/{idCread}/programas")
    public ResponseEntity<List<ProgramaDTO>> listarProgramasPorCread(@PathVariable Integer idCread) {
        return ResponseEntity.ok(
                mapper.toProgramaDTOList(consultaContextoService.listarProgramasPorCread(idCread))
        );
    }

    @GetMapping("/programas/{id}")
    public ResponseEntity<ProgramaDTO> obtenerProgramaPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerProgramaPorId(id))
        );
    }

    @PostMapping("/programas")
    public ResponseEntity<ProgramaDTO> crearPrograma(@Valid @RequestBody ProgramaDTO programaDTO) {
        var programa = mapper.toDomain(programaDTO);
        var creado = consultaContextoService.crearPrograma(programa);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(creado));
    }

    @PutMapping("/programas/{id}")
    public ResponseEntity<ProgramaDTO> actualizarPrograma(
            @PathVariable Integer id,
            @Valid @RequestBody ProgramaDTO programaDTO) {
        var programa = mapper.toDomain(programaDTO);
        var actualizado = consultaContextoService.actualizarPrograma(id, programa);
        return ResponseEntity.ok(mapper.toDTO(actualizado));
    }



    // ========== SEMESTRE ENDPOINTS ==========

    @GetMapping("/programas/{idPrograma}/semestres")
    public ResponseEntity<List<SemestreDTO>> listarSemestresPorPrograma(@PathVariable Integer idPrograma) {
        return ResponseEntity.ok(
                mapper.toSemestreDTOList(consultaContextoService.listarSemestresPorPrograma(idPrograma))
        );
    }

    @GetMapping("/semestres/{id}")
    public ResponseEntity<SemestreDTO> obtenerSemestrePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerSemestrePorId(id))
        );
    }

    @PostMapping("/semestres")
    public ResponseEntity<SemestreDTO> crearSemestre(@Valid @RequestBody SemestreDTO semestreDTO) {
        var semestre = mapper.toDomain(semestreDTO);
        var creado = consultaContextoService.crearSemestre(semestre);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(creado));
    }

    @PutMapping("/semestres/{id}")
    public ResponseEntity<SemestreDTO> actualizarSemestre(
            @PathVariable Integer id,
            @Valid @RequestBody SemestreDTO semestreDTO) {
        var semestre = mapper.toDomain(semestreDTO);
        var actualizado = consultaContextoService.actualizarSemestre(id, semestre);
        return ResponseEntity.ok(mapper.toDTO(actualizado));
    }

    @DeleteMapping("/semestres/{id}")
    public ResponseEntity<Void> eliminarSemestre(@PathVariable Integer id) {
        consultaContextoService.eliminarSemestre(id);
        return ResponseEntity.noContent().build();
    }

    // ========== ASIGNATURA ENDPOINTS ==========

    @GetMapping("/semestres/{idSemestre}/asignaturas")
    public ResponseEntity<List<AsignaturaDTO>> listarAsignaturasPorSemestre(@PathVariable Integer idSemestre) {
        return ResponseEntity.ok(
                mapper.toAsignaturaDTOList(consultaContextoService.listarAsignaturasPorSemestre(idSemestre))
        );
    }

    @GetMapping("/asignaturas/{id}")
    public ResponseEntity<AsignaturaDTO> obtenerAsignaturaPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerAsignaturaPorId(id))
        );
    }

    @PostMapping("/asignaturas")
    public ResponseEntity<AsignaturaDTO> crearAsignatura(@Valid @RequestBody AsignaturaDTO asignaturaDTO) {
        var asignatura = mapper.toDomain(asignaturaDTO);
        var creado = consultaContextoService.crearAsignatura(asignatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(creado));
    }

    @PutMapping("/asignaturas/{id}")
    public ResponseEntity<AsignaturaDTO> actualizarAsignatura(
            @PathVariable Integer id,
            @Valid @RequestBody AsignaturaDTO asignaturaDTO) {
        var asignatura = mapper.toDomain(asignaturaDTO);
        var actualizado = consultaContextoService.actualizarAsignatura(id, asignatura);
        return ResponseEntity.ok(mapper.toDTO(actualizado));
    }

    @DeleteMapping("/asignaturas/{id}")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable Integer id) {
        consultaContextoService.eliminarAsignatura(id);
        return ResponseEntity.noContent().build();
    }

    // ========== ACTIVIDAD ENDPOINTS ==========

    @GetMapping("/asignaturas/{idAsignatura}/actividades")
    public ResponseEntity<List<ActividadDTO>> listarActividadesPorAsignatura(@PathVariable Integer idAsignatura) {
        return ResponseEntity.ok(
                mapper.toActividadDTOList(consultaContextoService.listarActividadesPorAsignatura(idAsignatura))
        );
    }

    @GetMapping("/actividades/{id}")
    public ResponseEntity<ActividadDTO> obtenerActividadPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerActividadPorId(id))
        );
    }

    @PostMapping("/actividades")
    public ResponseEntity<ActividadDTO> crearActividad(@Valid @RequestBody ActividadDTO actividadDTO) {
        var actividad = mapper.toDomain(actividadDTO);
        var creado = consultaContextoService.crearActividad(actividad);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(creado));
    }

    @PutMapping("/actividades/{id}")
    public ResponseEntity<ActividadDTO> actualizarActividad(
            @PathVariable Integer id,
            @Valid @RequestBody ActividadDTO actividadDTO) {
        var actividad = mapper.toDomain(actividadDTO);
        var actualizado = consultaContextoService.actualizarActividad(id, actividad);
        return ResponseEntity.ok(mapper.toDTO(actualizado));
    }

    @DeleteMapping("/actividades/{id}")
    public ResponseEntity<Void> eliminarActividad(@PathVariable Integer id) {
        consultaContextoService.eliminarActividad(id);
        return ResponseEntity.noContent().build();
    }

    // ========== ESTUDIANTE ENDPOINTS COMPLETOS ==========

    /**
     * Lista todos los estudiantes
     */
    @GetMapping("/estudiantes")
    public ResponseEntity<List<EstudianteDTO>> listarEstudiantes() {
        return ResponseEntity.ok(
                consultaContextoService.listarEstudiantes()
                        .stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    /**
     * Obtiene un estudiante por su ID
     */
    @GetMapping("/estudiantes/id/{id}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerEstudiantePorId(id))
        );
    }

    /**
     * Obtiene un estudiante por su código único
     */
    @GetMapping("/estudiantes/codigo/{codigo}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorCodigo(@PathVariable Integer codigo) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerEstudiantePorCodigo(codigo))
        );
    }

    /**
     * Crea un nuevo estudiante
     */
    @PostMapping("/estudiantes")
    public ResponseEntity<EstudianteDTO> crearEstudiante(@Valid @RequestBody EstudianteDTO estudianteDTO) {
        var estudiante = mapper.toDomain(estudianteDTO);
        var creado = consultaContextoService.crearEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(creado));
    }

    /**
     * Actualiza un estudiante existente
     */
    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(
            @PathVariable Integer id,
            @Valid @RequestBody EstudianteDTO estudianteDTO) {
        var estudiante = mapper.toDomain(estudianteDTO);
        var actualizado = consultaContextoService.actualizarEstudiante(id, estudiante);
        return ResponseEntity.ok(mapper.toDTO(actualizado));
    }

    /**
     * Elimina un estudiante
     */
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Integer id) {
        consultaContextoService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }

    // ========== DOCENTE ENDPOINTS COMPLETOS ==========

    /**
     * Lista todos los docentes
     */
    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTO>> listarDocentes() {
        return ResponseEntity.ok(
                consultaContextoService.listarDocentes()
                        .stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    /**
     * Obtiene un docente por su ID
     */
    @GetMapping("/docentes/id/{id}")
    public ResponseEntity<DocenteDTO> obtenerDocentePorId(@PathVariable Long id) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerDocentePorId(id))
        );
    }

    /**
     * Obtiene un docente por su cédula única
     */
    @GetMapping("/docentes/cedula/{cedula}")
    public ResponseEntity<DocenteDTO> obtenerDocentePorCedula(@PathVariable Long cedula) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerDocentePorCedula(cedula))
        );
    }

    /**
     * Crea un nuevo docente
     */
    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTO> crearDocente(@Valid @RequestBody DocenteDTO docenteDTO) {
        var docente = mapper.toDomain(docenteDTO);
        var creado = consultaContextoService.crearDocente(docente);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(creado));
    }

    /**
     * Actualiza un docente existente
     */
    @PutMapping("/docentes/{id}")
    public ResponseEntity<DocenteDTO> actualizarDocente(
            @PathVariable Long id,
            @Valid @RequestBody DocenteDTO docenteDTO) {
        var docente = mapper.toDomain(docenteDTO);
        var actualizado = consultaContextoService.actualizarDocente(id, docente);
        return ResponseEntity.ok(mapper.toDTO(actualizado));
    }

    /**
     * Elimina un docente
     */
    @DeleteMapping("/docentes/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable Long id) {
        consultaContextoService.eliminarDocente(id);
        return ResponseEntity.noContent().build();
    }

    // ========== ALERTA TEMPRANA ENDPOINTS COMPLETOS ==========

    /**
     * Lista todas las alertas tempranas
     */
    @GetMapping("/alertas")
    public ResponseEntity<List<AlertaTempranaDTO>> listarAlertasTempranas() {
        return ResponseEntity.ok(
                consultaContextoService.listarAlertasTempranas()
                        .stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    /**
     * Obtiene una alerta temprana por su ID
     */
    @GetMapping("/alertas/{id}")
    public ResponseEntity<AlertaTempranaDTO> obtenerAlertaTempranaPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(
                mapper.toDTO(consultaContextoService.obtenerAlertaTempranaPorId(id))
        );
    }

    /**
     * Lista todas las alertas de un estudiante específico
     */
    @GetMapping("/estudiantes/{idEstudiante}/alertas")
    public ResponseEntity<List<AlertaTempranaDTO>> listarAlertasPorEstudiante(@PathVariable Integer idEstudiante) {
        return ResponseEntity.ok(
                consultaContextoService.listarAlertasPorEstudiante(idEstudiante)
                        .stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    /**
     * Lista todas las alertas creadas por un docente específico
     */
    @GetMapping("/docentes/{idDocente}/alertas")
    public ResponseEntity<List<AlertaTempranaDTO>> listarAlertasPorDocente(@PathVariable Long idDocente) {
        return ResponseEntity.ok(
                consultaContextoService.listarAlertasPorDocente(idDocente)
                        .stream()
                        .map(mapper::toDTO)
                        .toList()
        );
    }

    /**
     * Crea una nueva alerta temprana
     */
    @PostMapping("/alertas")
    public ResponseEntity<AlertaTempranaDTO> crearAlertaTemprana(@Valid @RequestBody AlertaTempranaDTO alertaDTO) {
        var alerta = mapper.toDomain(alertaDTO);
        var creada = consultaContextoService.crearAlertaTemprana(alerta);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(creada));
    }

    /**
     * Actualiza una alerta temprana existente
     */
    @PutMapping("/alertas/{id}")
    public ResponseEntity<AlertaTempranaDTO> actualizarAlertaTemprana(
            @PathVariable Integer id,
            @Valid @RequestBody AlertaTempranaDTO alertaDTO) {
        var alerta = mapper.toDomain(alertaDTO);
        var actualizada = consultaContextoService.actualizarAlertaTemprana(id, alerta);
        return ResponseEntity.ok(mapper.toDTO(actualizada));
    }

    /**
     * Elimina una alerta temprana
     */
    @DeleteMapping("/alertas/{id}")
    public ResponseEntity<Void> eliminarAlertaTemprana(@PathVariable Integer id) {
        consultaContextoService.eliminarAlertaTemprana(id);
        return ResponseEntity.noContent().build();
    }
}
