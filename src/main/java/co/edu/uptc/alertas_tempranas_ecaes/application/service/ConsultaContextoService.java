package co.edu.uptc.alertas_tempranas_ecaes.application.service;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.*;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.*;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultaContextoService {

    private final CreadJpaRepository creadRepository;
    private final ProgramaJpaRepository programaRepository;
    private final SemestreJpaRepository semestreRepository;
    private final AsignaturaJpaRepository asignaturaRepository;
    private final ActividadJpaRepository actividadRepository;

    // ============ CREADS (Nivel 1) ============
    public List<CreadDTO> listarCreads() {
        return creadRepository.findAll().stream()
                .map(this::mapearCread)
                .collect(Collectors.toList());
    }

    // Obtener un CREAD por ID
    public CreadDTO obtenerCreadPorId(Integer id) {
        return creadRepository.findById(id)
                .map(this::mapearCread)
                .orElseThrow(() -> new RuntimeException("CREAD no encontrado con ID: " + id));
    }


    // ============ PROGRAMAS (Nivel 2: incluye CREAD) ============
    public List<ProgramaDTO> listarProgramasPorCread(Integer idCread) {
        return programaRepository.findAll().stream()
                .filter(p -> p.getIdCread().equals(idCread))
                .map(p -> mapearProgramaConCread(p, idCread))
                .collect(Collectors.toList());
    }

    public List<ProgramaDTO> listarProgramas() {
        return programaRepository.findAll().stream()
                .map(p -> mapearProgramaConCread(p, p.getIdCread()))
                .collect(Collectors.toList());
    }

    public ProgramaDTO obtenerProgramaPorId(Integer id) {
        ProgramaEntity programa = programaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + id));
        return mapearProgramaConCread(programa, programa.getIdCread());
    }

    // ============ SEMESTRES (Nivel 3: incluye Programa → CREAD) ============
    public List<SemestreDTO> listarSemestresPorPrograma(Integer idPrograma) {
        return semestreRepository.findByIdPrograma(idPrograma).stream()
                .map(s -> mapearSemestreConPrograma(s, idPrograma))
                .collect(Collectors.toList());
    }

    // ============ ASIGNATURAS (Nivel 4: incluye Semestre → Programa → CREAD) ============
    public List<AsignaturaDTO> listarAsignaturasPorSemestre(Integer idSemestre) {
        return asignaturaRepository.findByIdSemestre(idSemestre).stream()
                .map(a -> mapearAsignaturaConSemestre(a, idSemestre))
                .collect(Collectors.toList());
    }

    // ============ ACTIVIDADES (Nivel 5: incluye toda la jerarquía) ============
    public List<ActividadDTO> listarActividadesPorAsignatura(Integer codAsignatura) {
        return actividadRepository.findByCodAsignatura(codAsignatura).stream()
                .map(a -> mapearActividadConAsignatura(a, codAsignatura))
                .collect(Collectors.toList());
    }

    // ============ CONTEXTO COMPLETO (Para cuando el usuario selecciona una actividad) ============
    public ContextoCompletoDTO obtenerContextoCompleto(Integer idActividad) {
        ActividadEntity actividad = actividadRepository.findById(idActividad)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada con ID: " + idActividad));

        // Reconstruir toda la ruta hacia arriba
        AsignaturaEntity asignatura = asignaturaRepository.findById(actividad.getCodAsignatura())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

        SemestreEntity semestre = semestreRepository.findById(asignatura.getIdSemestre())
                .orElseThrow(() -> new RuntimeException("Semestre no encontrado"));

        ProgramaEntity programa = programaRepository.findById(semestre.getIdPrograma())
                .orElseThrow(() -> new RuntimeException("Programa no encontrado"));

        CreadEntity cread = creadRepository.findById(programa.getIdCread())
                .orElseThrow(() -> new RuntimeException("CREAD no encontrado"));

        // Mapear toda la jerarquía
        CreadDTO creadDTO = mapearCread(cread);
        ProgramaDTO programaDTO = mapearProgramaConCread(programa, cread.getIdCread());
        SemestreDTO semestreDTO = mapearSemestreConPrograma(semestre, programa.getIdPrograma());
        AsignaturaDTO asignaturaDTO = mapearAsignaturaConSemestre(asignatura, semestre.getIdSemestre());
        ActividadDTO actividadDTO = mapearActividadConAsignatura(actividad, asignatura.getCodAsignatura());

        // Construir ruta legible
        String rutaCompleta = String.format("%s → %s → %s → %s → %s",
                cread.getNombre(),
                programa.getNombre(),
                semestre.getDescripcion(),
                asignatura.getNombre(),
                actividad.getNombre()
        );

        return ContextoCompletoDTO.builder()
                .cread(creadDTO)
                .programa(programaDTO)
                .semestre(semestreDTO)
                .asignatura(asignaturaDTO)
                .actividad(actividadDTO)
                .rutaCompleta(rutaCompleta)
                .build();
    }

    // ============ MÉTODOS AUXILIARES DE MAPEO ============

    private CreadDTO mapearCread(CreadEntity cread) {
        return CreadDTO.builder()
                .idCread(cread.getIdCread())
                .nombre(cread.getNombre())
                .direccion(cread.getDireccion())
                .build();
    }

    private ProgramaDTO mapearProgramaConCread(ProgramaEntity programa, Integer idCread) {
        CreadDTO creadDTO = creadRepository.findById(idCread)
                .map(this::mapearCread)
                .orElse(null);

        return ProgramaDTO.builder()
                .idPrograma(programa.getIdPrograma())
                .nombre(programa.getNombre())
                .descripcion(programa.getDescripcion())
                .cread(creadDTO)
                .build();
    }

    private SemestreDTO mapearSemestreConPrograma(SemestreEntity semestre, Integer idPrograma) {
        ProgramaDTO programaDTO = programaRepository.findById(idPrograma)
                .map(p -> mapearProgramaConCread(p, p.getIdCread()))
                .orElse(null);

        return SemestreDTO.builder()
                .idSemestre(semestre.getIdSemestre())
                .descripcion(semestre.getDescripcion())
                .programa(programaDTO)
                .build();
    }

    private AsignaturaDTO mapearAsignaturaConSemestre(AsignaturaEntity asignatura, Integer idSemestre) {
        SemestreDTO semestreDTO = semestreRepository.findById(idSemestre)
                .map(s -> mapearSemestreConPrograma(s, s.getIdPrograma()))
                .orElse(null);

        return AsignaturaDTO.builder()
                .codAsignatura(asignatura.getCodAsignatura())
                .nombre(asignatura.getNombre())
                .creditos(asignatura.getCreditos())
                .semestre(semestreDTO)
                .build();
    }

    private ActividadDTO mapearActividadConAsignatura(ActividadEntity actividad, Integer codAsignatura) {
        AsignaturaDTO asignaturaDTO = asignaturaRepository.findById(codAsignatura)
                .map(a -> mapearAsignaturaConSemestre(a, a.getIdSemestre()))
                .orElse(null);

        return ActividadDTO.builder()
                .idActividad(actividad.getIdActividad())
                .nombre(actividad.getNombre())
                .asignatura(asignaturaDTO)
                .build();
    }
}
