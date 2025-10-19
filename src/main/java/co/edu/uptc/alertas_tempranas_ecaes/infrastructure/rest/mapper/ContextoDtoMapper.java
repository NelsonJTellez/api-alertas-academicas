package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.mapper;


import co.edu.uptc.alertas_tempranas_ecaes.domain.model.*;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContextoDtoMapper {

    // CREAD
    public CreadDTO toDTO(Cread domain) {
        if (domain == null) return null;
        return CreadDTO.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .direccion(domain.getDireccion())
                .build();
    }

    public Cread toDomain(CreadDTO dto) {
        if (dto == null) return null;
        return Cread.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .direccion(dto.getDireccion())
                .build();
    }

    // PROGRAMA
    public ProgramaDTO toDTO(Programa domain) {
        if (domain == null) return null;
        return ProgramaDTO.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .descripcion(domain.getDescripcion())
                .build();
    }

    public Programa toDomain(ProgramaDTO dto) {
        if (dto == null) return null;
        return Programa.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();
    }

    // SEMESTRE
    public SemestreDTO toDTO(Semestre domain) {
        if (domain == null) return null;
        return SemestreDTO.builder()
                .id(domain.getId())
                .descripcion(domain.getDescripcion())
                .build();
    }

    public Semestre toDomain(SemestreDTO dto) {
        if (dto == null) return null;
        return Semestre.builder()
                .id(dto.getId())
                .descripcion(dto.getDescripcion())
                .build();
    }

    // ASIGNATURA
    public AsignaturaDTO toDTO(Asignatura domain) {
        if (domain == null) return null;
        return AsignaturaDTO.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .creditos(domain.getCreditos())
                .build();
    }

    public Asignatura toDomain(AsignaturaDTO dto) {
        if (dto == null) return null;
        return Asignatura.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .creditos(dto.getCreditos())
                .build();
    }

    // ACTIVIDAD
    public ActividadDTO toDTO(Actividad domain) {
        if (domain == null) return null;
        return ActividadDTO.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .build();
    }

    public Actividad toDomain(ActividadDTO dto) {
        if (dto == null) return null;
        return Actividad.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .build();
    }

    // ESTUDIANTE
    public EstudianteDTO toDTO(Estudiante domain) {
        if (domain == null) return null;
        return EstudianteDTO.builder()
                .id(domain.getCodigo())
                .nombre(domain.getNombre())
                .apellido(domain.getApellido())
                .codigo(domain.getCodigo())
                .build();
    }

    public Estudiante toDomain(EstudianteDTO dto) {
        if (dto == null) return null;
        return Estudiante.builder()
                .codigo(dto.getCodigo())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .build();
    }

    // DOCENTE
    public DocenteDTO toDTO(Docente domain) {
        if (domain == null) return null;
        return DocenteDTO.builder()
                .id(domain.getCedula())
                .nombre(domain.getNombre())
                .apellido(domain.getApellido())
                .build();
    }

    public Docente toDomain(DocenteDTO dto) {
        if (dto == null) return null;
        return Docente.builder()
                .cedula(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .cedula(dto.getCedula())
                .build();
    }

    // ALERTA TEMPRANA
    public AlertaTempranaDTO toDTO(AlertaTemprana domain) {
        if (domain == null) return null;
        return AlertaTempranaDTO.builder()
                .id(domain.getId())
                .descripcion(domain.getDescripcion())
                .idEstudiante(domain.getIdEstudiante())
                .idDocente(domain.getIdDocente())
                .build();
    }

    public AlertaTemprana toDomain(AlertaTempranaDTO dto) {
        if (dto == null) return null;
        return AlertaTemprana.builder()
                .id(dto.getId())
                .descripcion(dto.getDescripcion())
                .idEstudiante(dto.getIdEstudiante())
                .idDocente(dto.getIdDocente())
                .build();
    }

    // Métodos auxiliares para listas
    public List<CreadDTO> toCreadDTOList(List<Cread> domains) {
        return domains.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ProgramaDTO> toProgramaDTOList(List<Programa> domains) {
        return domains.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<SemestreDTO> toSemestreDTOList(List<Semestre> domains) {
        return domains.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AsignaturaDTO> toAsignaturaDTOList(List<Asignatura> domains) {
        return domains.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ActividadDTO> toActividadDTOList(List<Actividad> domains) {
        return domains.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
