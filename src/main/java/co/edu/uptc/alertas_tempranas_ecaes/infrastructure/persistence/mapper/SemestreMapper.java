package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Semestre;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.SemestreEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SemestreMapper implements GenericMapper<SemestreEntity, Semestre, Integer> {

    @Override
    public Semestre toDomain(SemestreEntity entity) {
        if (entity == null) return null;

        return Semestre.builder()
                .id(entity.getId())
                .idPrograma(entity.getIdPrograma())
                .numeroOrden(entity.getNumeroOrden())
                .descripcion(entity.getDescripcion())
                .build();
    }

    @Override
    public SemestreEntity toEntity(Semestre domain) {
        if (domain == null) return null;

        return SemestreEntity.builder()
                .id(domain.getId())
                .idPrograma(domain.getIdPrograma())
                .numeroOrden(domain.getNumeroOrden())
                .descripcion(domain.getDescripcion())
                .build();
    }

    @Override
    public List<Semestre> toDomainList(List<SemestreEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<SemestreEntity> toEntityList(List<Semestre> domainList) {
        if (domainList == null) return null;
        return domainList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
