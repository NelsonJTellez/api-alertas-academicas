package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Docente;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.DocenteEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocenteMapper implements GenericMapper<DocenteEntity, Docente, Long> {

    @Override
    public Docente toDomain(DocenteEntity entity) {
        if (entity == null) return null;

        return Docente.builder()
                .cedula(entity.getCedula())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .correo(entity.getCorreo())
                .build();
    }

    @Override
    public DocenteEntity toEntity(Docente domain) {
        if (domain == null) return null;

        return DocenteEntity.builder()
                .cedula(domain.getCedula())
                .nombre(domain.getNombre())
                .apellido(domain.getApellido())
                .correo(domain.getCorreo())
                .build();
    }

    @Override
    public List<Docente> toDomainList(List<DocenteEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocenteEntity> toEntityList(List<Docente> domainList) {
        if (domainList == null) return null;
        return domainList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
