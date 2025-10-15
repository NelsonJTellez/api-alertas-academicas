package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.AlertaTemprana;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Docente;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Estudiante;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.AlertaTempranaEntity;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.DocenteEntity;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.EstudianteEntity;
import org.springframework.stereotype.Component;

@Component
public class AlertaTempranaMapper {

    public AlertaTemprana toDomain(AlertaTempranaEntity entity) {
        if (entity == null) return null;

        return AlertaTemprana.builder()
                .id(entity.getId())
                .descripcion(entity.getDescripcion())
                .fechaRegistro(entity.getFechaRegistro())
                .idActividadReportada(entity.getIdActividadReportada())
                .idSeguimiento(entity.getIdSeguimiento())
                .docente(new Docente(
                        entity.getDocente().getCedula(),
                        entity.getDocente().getNombre(),
                        entity.getDocente().getCorreo()
                ))
                .estudiante(new Estudiante(
                        entity.getEstudiante().getCodigo(),
                        entity.getEstudiante().getNombre(),
                        entity.getEstudiante().getCorreo(),
                        entity.getEstudiante().getCelular()
                ))
                .build();
    }

    public AlertaTempranaEntity toEntity(AlertaTemprana domain) {
        if (domain == null) return null;

        return AlertaTempranaEntity.builder()
                .id(domain.getId())
                .descripcion(domain.getDescripcion())
                .fechaRegistro(domain.getFechaRegistro())
                .idActividadReportada(domain.getIdActividadReportada())
                .idSeguimiento(domain.getIdSeguimiento())
                .docente(DocenteEntity.builder()
                        .cedula(domain.getDocente().getCedula())
                        .nombre(domain.getDocente().getNombre())
                        .correo(domain.getDocente().getCorreo())
                        .build())
                .estudiante(EstudianteEntity.builder()
                        .codigo(domain.getEstudiante().getCodigo())
                        .nombre(domain.getEstudiante().getNombre())
                        .correo(domain.getEstudiante().getCorreo())
                        .celular(domain.getEstudiante().getCelular())
                        .build())
                .build();
    }
}
