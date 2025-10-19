package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Actividad;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ActividadEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActividadMapper implements GenericMapper<ActividadEntity, Actividad, Integer> {

    @Override
    public Actividad toDomain(ActividadEntity entity) {
        if (entity == null) return null;

        return Actividad.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public ActividadEntity toEntity(Actividad domain) {
        if (domain == null) return null;

        return ActividadEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .build();
    }

    @Override
    public List<Actividad> toDomainList(List<ActividadEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadEntity> toEntityList(List<Actividad> domainList) {
        if (domainList == null) return null;
        return domainList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
