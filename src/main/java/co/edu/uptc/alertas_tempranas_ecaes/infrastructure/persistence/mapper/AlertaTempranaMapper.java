package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.AlertaTemprana;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.AlertaTempranaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlertaTempranaMapper implements GenericMapper<AlertaTempranaEntity, AlertaTemprana, Integer> {

    @Override
    public AlertaTemprana toDomain(AlertaTempranaEntity entity) {
        if (entity == null) return null;

        return AlertaTemprana.builder()
                .id(entity.getId())
                .descripcion(entity.getDescripcion())
                .idEstudiante(entity.getIdEstudiante())
                .idDocente(entity.getIdDocente())
                .build();
    }

    @Override
    public AlertaTempranaEntity toEntity(AlertaTemprana domain) {
        if (domain == null) return null;

        return AlertaTempranaEntity.builder()
                .id(domain.getId())
                .descripcion(domain.getDescripcion())
                .idEstudiante(domain.getIdEstudiante())
                .idDocente(domain.getIdDocente())
                .build();
    }

    @Override
    public List<AlertaTemprana> toDomainList(List<AlertaTempranaEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlertaTempranaEntity> toEntityList(List<AlertaTemprana> domainList) {
        if (domainList == null) return null;
        return domainList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
