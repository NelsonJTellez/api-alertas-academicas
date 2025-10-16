package co.edu.uptc.alertas_tempranas_ecaes.application.service;


import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.*;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.*;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.*;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.ContextoMapper;
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
    private final ContextoMapper contextoMapper;


    public List<CreadDTO> listarCreads() {
        return creadRepository.findAll().stream()
                .map(contextoMapper::mapearCread)
                .collect(Collectors.toList());
    }


    public CreadDTO obtenerCreadPorId(Integer id) {
        return creadRepository.findById(id)
                .map(contextoMapper::mapearCread)
                .orElseThrow(() -> new RuntimeException("CREAD no encontrado con ID: " + id));
    }


    public List<ProgramaDTO> listarProgramasPorCread(Integer idCread) {
        CreadDTO creadDTO = creadRepository.findById(idCread)
                .map(contextoMapper::mapearCread)
                .orElse(null);
        return programaRepository.findProgramasByCreadId(idCread).stream()
                .map(p -> contextoMapper.mapearProgramaConCread(p, creadDTO))
                .collect(Collectors.toList());
    }


    public ProgramaDTO obtenerProgramaPorId(Integer id) {
        ProgramaEntity programa = programaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + id));
        CreadEntity cread = programa.getCreads().stream().findFirst().orElse(null);
        CreadDTO creadDTO = (cread != null) ? contextoMapper.mapearCread(cread) : null;
        return contextoMapper.mapearProgramaConCread(programa, creadDTO);
    }


    public List<SemestreDTO> listarSemestresPorCreadPrograma(Integer idCread, Integer idPrograma) {
        ProgramaEntity programa = programaRepository.findById(idPrograma)
            .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + idPrograma));
        boolean perteneceAlCread = programa.getCreads().stream()
            .anyMatch(c -> c.getIdCread().equals(idCread));
        if (!perteneceAlCread) {
            throw new RuntimeException("El programa no pertenece al CREAD especificado");
        }
        CreadEntity cread = programa.getCreads().stream()
            .filter(c -> c.getIdCread().equals(idCread)).findFirst().orElse(null);
        CreadDTO creadDTO = (cread != null) ? contextoMapper.mapearCread(cread) : null;
        ProgramaDTO programaDTO = contextoMapper.mapearProgramaConCread(programa, creadDTO);

        return semestreRepository.findByIdPrograma(idPrograma).stream()
            .map(s -> contextoMapper.mapearSemestreConPrograma(s, programaDTO))
            .collect(Collectors.toList());
    }


    public SemestreDTO obtenerSemestreJerarquico(Integer idCread, Integer idPrograma, Integer idSemestre) {
        ProgramaEntity programa = programaRepository.findById(idPrograma)
            .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + idPrograma));
        boolean perteneceAlCread = programa.getCreads().stream()
            .anyMatch(c -> c.getIdCread().equals(idCread));
        if (!perteneceAlCread) {
            throw new RuntimeException("El programa no pertenece al CREAD especificado");
        }
        SemestreEntity semestre = semestreRepository.findById(idSemestre)
            .orElseThrow(() -> new RuntimeException("Semestre no encontrado con ID: " + idSemestre));
        if (!semestre.getIdPrograma().equals(idPrograma)) {
            throw new RuntimeException("El semestre no pertenece al programa especificado");
        }
        CreadEntity cread = programa.getCreads().stream()
            .filter(c -> c.getIdCread().equals(idCread)).findFirst().orElse(null);
        CreadDTO creadDTO = (cread != null) ? contextoMapper.mapearCread(cread) : null;
        ProgramaDTO programaDTO = contextoMapper.mapearProgramaConCread(programa, creadDTO);
        return contextoMapper.mapearSemestreConPrograma(semestre, programaDTO);
    }


    public List<AsignaturaDTO> listarAsignaturasPorCreadProgramaSemestre(Integer idCread, Integer idPrograma, Integer idSemestre) {
        ProgramaEntity programa = programaRepository.findById(idPrograma)
            .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + idPrograma));
        boolean perteneceAlCread = programa.getCreads().stream()
            .anyMatch(c -> c.getIdCread().equals(idCread));
        if (!perteneceAlCread) {
            throw new RuntimeException("El programa no pertenece al CREAD especificado");
        }


        SemestreEntity semestre = semestreRepository.findById(idSemestre)
            .orElseThrow(() -> new RuntimeException("Semestre no encontrado con ID: " + idSemestre));
        if (!semestre.getIdPrograma().equals(idPrograma)) {
            throw new RuntimeException("El semestre no pertenece al programa especificado");
        }


        CreadEntity cread = programa.getCreads().stream()
            .filter(c -> c.getIdCread().equals(idCread)).findFirst().orElse(null);
        CreadDTO creadDTO = (cread != null) ? contextoMapper.mapearCread(cread) : null;
        ProgramaDTO programaDTO = contextoMapper.mapearProgramaConCread(programa, creadDTO);
        SemestreDTO semestreDTO = contextoMapper.mapearSemestreConPrograma(semestre, programaDTO);


        return asignaturaRepository.findByIdSemestre(idSemestre).stream()
            .map(a -> contextoMapper.mapearAsignaturaConSemestre(a, semestreDTO))
            .collect(Collectors.toList());
    }


    public AsignaturaDTO obtenerAsignaturaJerarquica(Integer idCread, Integer idPrograma, Integer idSemestre, Integer codAsignatura) {
        ProgramaEntity programa = programaRepository.findById(idPrograma)
            .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + idPrograma));
        boolean perteneceAlCread = programa.getCreads().stream()
            .anyMatch(c -> c.getIdCread().equals(idCread));
        if (!perteneceAlCread) {
            throw new RuntimeException("El programa no pertenece al CREAD especificado");
        }


        SemestreEntity semestre = semestreRepository.findById(idSemestre)
            .orElseThrow(() -> new RuntimeException("Semestre no encontrado con ID: " + idSemestre));
        if (!semestre.getIdPrograma().equals(idPrograma)) {
            throw new RuntimeException("El semestre no pertenece al programa especificado");
        }


        AsignaturaEntity asignatura = asignaturaRepository.findById(codAsignatura)
            .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con ID: " + codAsignatura));
        if (!asignatura.getIdSemestre().equals(idSemestre)) {
            throw new RuntimeException("La asignatura no pertenece al semestre especificado");
        }


        CreadEntity cread = programa.getCreads().stream()
            .filter(c -> c.getIdCread().equals(idCread)).findFirst().orElse(null);
        CreadDTO creadDTO = (cread != null) ? contextoMapper.mapearCread(cread) : null;
        ProgramaDTO programaDTO = contextoMapper.mapearProgramaConCread(programa, creadDTO);
        SemestreDTO semestreDTO = contextoMapper.mapearSemestreConPrograma(semestre, programaDTO);


        return contextoMapper.mapearAsignaturaConSemestre(asignatura, semestreDTO);
    }


    public List<ActividadDTO> listarActividadesPorCreadProgramaSemestreAsignatura(
        Integer idCread, Integer idPrograma, Integer idSemestre, Integer codAsignatura) {


        ProgramaEntity programa = programaRepository.findById(idPrograma)
            .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + idPrograma));
        boolean perteneceAlCread = programa.getCreads().stream()
            .anyMatch(c -> c.getIdCread().equals(idCread));
        if (!perteneceAlCread) {
            throw new RuntimeException("El programa no pertenece al CREAD especificado");
        }


        SemestreEntity semestre = semestreRepository.findById(idSemestre)
            .orElseThrow(() -> new RuntimeException("Semestre no encontrado con ID: " + idSemestre));
        if (!semestre.getIdPrograma().equals(idPrograma)) {
            throw new RuntimeException("El semestre no pertenece al programa especificado");
        }


        AsignaturaEntity asignatura = asignaturaRepository.findById(codAsignatura)
            .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con ID: " + codAsignatura));
        if (!asignatura.getIdSemestre().equals(idSemestre)) {
            throw new RuntimeException("La asignatura no pertenece al semestre especificado");
        }


        SemestreDTO semestreDTO = contextoMapper.mapearSemestreConPrograma(semestre,
            contextoMapper.mapearProgramaConCread(programa,
                contextoMapper.mapearCread(
                    programa.getCreads().stream().filter(c -> c.getIdCread().equals(idCread)).findFirst().orElse(null)
                )
            )
        );
        AsignaturaDTO asignaturaDTO = contextoMapper.mapearAsignaturaConSemestre(asignatura, semestreDTO);


        return actividadRepository.findByCodAsignatura(codAsignatura).stream()
            .map(a -> contextoMapper.mapearActividadConAsignatura(a, asignaturaDTO))
            .collect(Collectors.toList());
    }


    public List<ActividadDTO> listarActividadesPorCreadProgramaSemestre(Integer idCread, Integer idPrograma, Integer idSemestre) {
        List<AsignaturaDTO> asignaturas = listarAsignaturasPorCreadProgramaSemestre(idCread, idPrograma, idSemestre);
        return asignaturas.stream()
            .flatMap(a -> actividadRepository.findByCodAsignatura(a.getCodAsignatura()).stream()
                .map(act -> contextoMapper.mapearActividadConAsignatura(act, a)))
            .collect(Collectors.toList());
    }


    public ActividadDTO obtenerActividadJerarquica(Integer idCread, Integer idPrograma, Integer idSemestre, Integer codAsignatura, Integer idActividad) {
        ProgramaEntity programa = programaRepository.findById(idPrograma)
            .orElseThrow(() -> new RuntimeException("Programa no encontrado con ID: " + idPrograma));
        boolean perteneceAlCread = programa.getCreads().stream()
            .anyMatch(c -> c.getIdCread().equals(idCread));
        if (!perteneceAlCread) {
            throw new RuntimeException("El programa no pertenece al CREAD especificado");
        }

        SemestreEntity semestre = semestreRepository.findById(idSemestre)
            .orElseThrow(() -> new RuntimeException("Semestre no encontrado con ID: " + idSemestre));
        if (!semestre.getIdPrograma().equals(idPrograma)) {
            throw new RuntimeException("El semestre no pertenece al programa especificado");
        }

        AsignaturaEntity asignatura = asignaturaRepository.findById(codAsignatura)
            .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con ID: " + codAsignatura));
        if (!asignatura.getIdSemestre().equals(idSemestre)) {
            throw new RuntimeException("La asignatura no pertenece al semestre especificado");
        }

        ActividadEntity actividad = actividadRepository.findById(idActividad)
            .orElseThrow(() -> new RuntimeException("Actividad no encontrada con ID: " + idActividad));
        if (!actividad.getCodAsignatura().equals(codAsignatura)) {
            throw new RuntimeException("La actividad no pertenece a la asignatura especificada");
        }

        SemestreDTO semestreDTO = contextoMapper.mapearSemestreConPrograma(semestre,
            contextoMapper.mapearProgramaConCread(programa,
                contextoMapper.mapearCread(
                    programa.getCreads().stream().filter(c -> c.getIdCread().equals(idCread)).findFirst().orElse(null)
                )
            )
        );
        AsignaturaDTO asignaturaDTO = contextoMapper.mapearAsignaturaConSemestre(asignatura, semestreDTO);

        return contextoMapper.mapearActividadConAsignatura(actividad, asignaturaDTO);
    }

}
