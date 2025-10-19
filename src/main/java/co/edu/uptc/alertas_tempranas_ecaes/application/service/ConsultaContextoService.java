package co.edu.uptc.alertas_tempranas_ecaes.application.service;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.*;
import co.edu.uptc.alertas_tempranas_ecaes.domain.exception.NotFoundException;
import co.edu.uptc.alertas_tempranas_ecaes.domain.exception.ValidationException;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio para gestionar el contexto académico jerárquico.
 * Maneja operaciones CRUD y validaciones de negocio.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ConsultaContextoService {

    private final CreadPort creadPort;
    private final ProgramaPort programaPort;
    private final SemestrePort semestrePort;
    private final AsignaturaPort asignaturaPort;
    private final ActividadPort actividadPort;
    private final EstudiantePort estudiantePort;
    private final DocentePort docentePort;
    private final AlertaTempranaPort alertaTempranaPort; // ← AGREGAR ESTA LÍNEA

    // ========== CREAD - OPERACIONES ==========

    public List<Cread> listarCread() {
        return creadPort.findAll();
    }

    public Cread obtenerCreadPorId(Integer id) {
        return creadPort.findById(id)
                .orElseThrow(() -> new NotFoundException("CREAD no encontrado con ID: " + id));
    }

    public Cread crearCread(Cread cread) {
        if (cread.getId() != null) {
            throw new ValidationException("El ID debe ser nulo para crear un nuevo CREAD");
        }
        return creadPort.save(cread);
    }

    public Cread actualizarCread(Integer id, Cread cread) {
        obtenerCreadPorId(id);
        cread.setId(id);
        return creadPort.save(cread);
    }

    public void eliminarCread(Integer id) {
        if (!creadPort.existsById(id)) {
            throw new NotFoundException("CREAD no encontrado con ID: " + id);
        }
        creadPort.deleteById(id);
    }

    // ========== PROGRAMA - OPERACIONES ==========

    public List<Programa> listarProgramasPorCread(Integer idCread) {
        obtenerCreadPorId(idCread);
        return programaPort.findProgramasByCreadId(idCread);
    }

    public Programa obtenerProgramaPorId(Integer id) {
        return programaPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Programa no encontrado con ID: " + id));
    }

    public Programa crearPrograma(Programa programa) {
        if (programa.getId() != null) {
            throw new ValidationException("El ID debe ser nulo para crear un nuevo programa");
        }
        return programaPort.save(programa);
    }

    public Programa actualizarPrograma(Integer id, Programa programa) {
        obtenerProgramaPorId(id);
        programa.setId(id);
        return programaPort.save(programa);
    }

    public void eliminarPrograma(Integer id) {
        if (!programaPort.existsById(id)) {
            throw new NotFoundException("Programa no encontrado con ID: " + id);
        }
        programaPort.deleteById(id);
    }

    // ========== SEMESTRE - OPERACIONES ==========

    public List<Semestre> listarSemestresPorPrograma(Integer idPrograma) {
        obtenerProgramaPorId(idPrograma);
        return semestrePort.findByIdPrograma(idPrograma);
    }

    public Semestre obtenerSemestrePorId(Integer id) {
        return semestrePort.findById(id)
                .orElseThrow(() -> new NotFoundException("Semestre no encontrado con ID: " + id));
    }

    public Semestre crearSemestre(Semestre semestre) {
        if (semestre.getId() != null) {
            throw new ValidationException("El ID debe ser nulo para crear un nuevo semestre");
        }
        return semestrePort.save(semestre);
    }

    public Semestre actualizarSemestre(Integer id, Semestre semestre) {
        obtenerSemestrePorId(id);
        semestre.setId(id);
        return semestrePort.save(semestre);
    }

    public void eliminarSemestre(Integer id) {
        if (!semestrePort.existsById(id)) {
            throw new NotFoundException("Semestre no encontrado con ID: " + id);
        }
        semestrePort.deleteById(id);
    }

    // ========== ASIGNATURA - OPERACIONES ==========

    public List<Asignatura> listarAsignaturasPorSemestre(Integer idSemestre) {
        obtenerSemestrePorId(idSemestre);
        return asignaturaPort.findByIdSemestre(idSemestre);
    }

    public Asignatura obtenerAsignaturaPorId(Integer id) {
        return asignaturaPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Asignatura no encontrada con ID: " + id));
    }

    public Asignatura crearAsignatura(Asignatura asignatura) {
        if (asignatura.getId() != null) {
            throw new ValidationException("El ID debe ser nulo para crear una nueva asignatura");
        }
        return asignaturaPort.save(asignatura);
    }

    public Asignatura actualizarAsignatura(Integer id, Asignatura asignatura) {
        obtenerAsignaturaPorId(id);
        asignatura.setId(id);
        return asignaturaPort.save(asignatura);
    }

    public void eliminarAsignatura(Integer id) {
        if (!asignaturaPort.existsById(id)) {
            throw new NotFoundException("Asignatura no encontrada con ID: " + id);
        }
        asignaturaPort.deleteById(id);
    }

    // ========== ACTIVIDAD - OPERACIONES ==========

    public List<Actividad> listarActividadesPorAsignatura(Integer idAsignatura) {
        obtenerAsignaturaPorId(idAsignatura);
        return actividadPort.findByCodAsignatura(idAsignatura);
    }

    public Actividad obtenerActividadPorId(Integer id) {
        return actividadPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Actividad no encontrada con ID: " + id));
    }

    public Actividad crearActividad(Actividad actividad) {
        if (actividad.getId() != null) {
            throw new ValidationException("El ID debe ser nulo para crear una nueva actividad");
        }
        return actividadPort.save(actividad);
    }

    public Actividad actualizarActividad(Integer id, Actividad actividad) {
        obtenerActividadPorId(id);
        actividad.setId(id);
        return actividadPort.save(actividad);
    }

    public void eliminarActividad(Integer id) {
        if (!actividadPort.existsById(id)) {
            throw new NotFoundException("Actividad no encontrada con ID: " + id);
        }
        actividadPort.deleteById(id);
    }

    // ========== ESTUDIANTE - OPERACIONES COMPLETAS ==========

    public List<Estudiante> listarEstudiantes() {
        return estudiantePort.findAll();
    }

    public Estudiante obtenerEstudiantePorId(Integer id) {
        return estudiantePort.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con ID: " + id));
    }

    public Estudiante obtenerEstudiantePorCodigo(Integer codigo) {
        return estudiantePort.buscarPorCodigo(codigo)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con código: " + codigo));
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        if (estudiante.getCodigo() != null) {
            throw new ValidationException("El ID debe ser nulo para crear un nuevo estudiante");
        }

        // Validar que el código sea único
        estudiantePort.buscarPorCodigo(estudiante.getCodigo()).ifPresent(e -> {
            throw new ValidationException("Ya existe un estudiante con el código: " + estudiante.getCodigo());
        });

        return estudiantePort.save(estudiante);
    }

    public Estudiante actualizarEstudiante(Integer id, Estudiante estudiante) {
        obtenerEstudiantePorId(id);
        estudiante.getCodigo();
        return estudiantePort.save(estudiante);
    }

    public void eliminarEstudiante(Integer id) {
        if (!estudiantePort.existsById(id)) {
            throw new NotFoundException("Estudiante no encontrado con ID: " + id);
        }
        estudiantePort.deleteById(id);
    }

    // ========== DOCENTE - OPERACIONES COMPLETAS ==========

    public List<Docente> listarDocentes() {
        return docentePort.findAll();
    }

    public Docente obtenerDocentePorId(Long id) {
        return docentePort.findById(id)
                .orElseThrow(() -> new NotFoundException("Docente no encontrado con ID: " + id));
    }

    public Docente obtenerDocentePorCedula(Long cedula) {
        return docentePort.buscarPorCedula(cedula)
                .orElseThrow(() -> new NotFoundException("Docente no encontrado con cédula: " + cedula));
    }

    public Docente crearDocente(Docente docente) {
        if (docente.getCedula() != null) {
            throw new ValidationException("El ID debe ser nulo para crear un nuevo docente");
        }

        // Validar que la cédula sea única
        docentePort.buscarPorCedula(docente.getCedula()).ifPresent(d -> {
            throw new ValidationException("Ya existe un docente con la cédula: " + docente.getCedula());
        });

        return docentePort.save(docente);
    }

    public Docente actualizarDocente(Long id, Docente docente) {
        obtenerDocentePorId(id);
        docente.getCedula();
        return docentePort.save(docente);
    }

    public void eliminarDocente(Long id) {
        if (!docentePort.existsById(id)) {
            throw new NotFoundException("Docente no encontrado con ID: " + id);
        }
        docentePort.deleteById(id);
    }

    // ========== ALERTA TEMPRANA - OPERACIONES COMPLETAS ==========

    public List<AlertaTemprana> listarAlertasTempranas() {
        return alertaTempranaPort.findAll();
    }

    public AlertaTemprana obtenerAlertaTempranaPorId(Integer id) {
        return alertaTempranaPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Alerta temprana no encontrada con ID: " + id));
    }

    public List<AlertaTemprana> listarAlertasPorEstudiante(Integer idEstudiante) {
        obtenerEstudiantePorId(idEstudiante);
        return alertaTempranaPort.findByEstudiante(idEstudiante);
    }

    public List<AlertaTemprana> listarAlertasPorDocente(Long idDocente) {
        obtenerDocentePorId(idDocente);
        return alertaTempranaPort.findByIdDocente(idDocente);
    }

    public AlertaTemprana crearAlertaTemprana(AlertaTemprana alertaTemprana) {
        if (alertaTemprana.getId() != null) {
            throw new ValidationException("El ID debe ser nulo para crear una nueva alerta temprana");
        }

        // Validar que el estudiante existe
        obtenerEstudiantePorId(alertaTemprana.getIdEstudiante());

        // Validar que el docente existe
        obtenerDocentePorId(alertaTemprana.getIdDocente());

        return alertaTempranaPort.save(alertaTemprana);
    }

    public AlertaTemprana actualizarAlertaTemprana(Integer id, AlertaTemprana alertaTemprana) {
        obtenerAlertaTempranaPorId(id);

        // Validar que el estudiante existe
        obtenerEstudiantePorId(alertaTemprana.getIdEstudiante());

        // Validar que el docente existe
        obtenerDocentePorId(alertaTemprana.getIdDocente());

        alertaTemprana.setId(id);
        return alertaTempranaPort.save(alertaTemprana);
    }

    public void eliminarAlertaTemprana(Integer id) {
        if (!alertaTempranaPort.existsById(id)) {
            throw new NotFoundException("Alerta temprana no encontrada con ID: " + id);
        }
        alertaTempranaPort.deleteById(id);
    }
}
