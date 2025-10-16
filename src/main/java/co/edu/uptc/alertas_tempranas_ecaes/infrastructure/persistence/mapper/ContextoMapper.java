package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.*;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.*;
import org.springframework.stereotype.Component;

@Component
public class ContextoMapper {

    public CreadDTO mapearCread(CreadEntity cread) {
        return CreadDTO.builder()
                .idCread(cread.getIdCread())
                .nombre(cread.getNombre())
                .direccion(cread.getDireccion())
                .build();
    }

    public ProgramaDTO mapearProgramaConCread(ProgramaEntity programa, CreadDTO creadDTO) {
        return ProgramaDTO.builder()
                .idPrograma(programa.getIdPrograma())
                .nombre(programa.getNombre())
                .descripcion(programa.getDescripcion())
                .cread(creadDTO)
                .build();
    }

    public SemestreDTO mapearSemestreConPrograma(SemestreEntity semestre, ProgramaDTO programaDTO) {
        return SemestreDTO.builder()
                .idSemestre(semestre.getIdSemestre())
                .descripcion(semestre.getDescripcion())
                .programa(programaDTO)
                .build();
    }

    public AsignaturaDTO mapearAsignaturaConSemestre(AsignaturaEntity asignatura, SemestreDTO semestreDTO) {
        return AsignaturaDTO.builder()
                .codAsignatura(asignatura.getCodAsignatura())
                .nombre(asignatura.getNombre())
                .creditos(asignatura.getCreditos())
                .semestre(semestreDTO)
                .build();
    }

    public ActividadDTO mapearActividadConAsignatura(ActividadEntity actividad, AsignaturaDTO asignaturaDTO) {
        return ActividadDTO.builder()
                .idActividad(actividad.getIdActividad())
                .nombre(actividad.getNombre())
                .asignatura(asignaturaDTO)
                .build();
    }
}
