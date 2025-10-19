package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Cread;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.CreadEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreadMapper implements GenericMapper<CreadEntity, Cread, Integer> {

    @Override
    public Cread toDomain(CreadEntity entity) {
        if (entity == null) return null;

        return Cread.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    @Override
    public CreadEntity toEntity(Cread domain) {
        if (domain == null) return null;

        return CreadEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .build();
    }

    @Override
    public List<Cread> toDomainList(List<CreadEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreadEntity> toEntityList(List<Cread> domainList) {
        if (domainList == null) return null;
        return domainList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
