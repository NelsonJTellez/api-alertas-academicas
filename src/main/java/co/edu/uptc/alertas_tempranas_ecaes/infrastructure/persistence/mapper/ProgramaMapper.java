package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Programa;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ProgramaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProgramaMapper implements GenericMapper<ProgramaEntity, Programa, Integer> {

    @Override
    public Programa toDomain(ProgramaEntity entity) {
        if (entity == null) return null;

        return Programa.builder()
                .id(entity.getId())                   // ← Ambos usan "id"
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .build();
    }

    @Override
    public ProgramaEntity toEntity(Programa domain) {
        if (domain == null) return null;

        return ProgramaEntity.builder()
                .id(domain.getId())                   // ← Ambos usan "id"
                .nombre(domain.getNombre())
                .descripcion(domain.getDescripcion())
                .build();
    }

    @Override
    public List<Programa> toDomainList(List<ProgramaEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramaEntity> toEntityList(List<Programa> domainList) {
        if (domainList == null) return null;
        return domainList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
