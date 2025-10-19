package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Estudiante;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.EstudianteEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstudianteMapper implements GenericMapper<EstudianteEntity, Estudiante, Integer> {

    @Override
    public Estudiante toDomain(EstudianteEntity entity) {
        if (entity == null) return null;

        return Estudiante.builder()
                .codigo(entity.getCodigo())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .correo(entity.getCorreo())
                .celular(entity.getCelular())
                .idInscripcion(entity.getIdInscripcion())
                .build();
    }

    @Override
    public EstudianteEntity toEntity(Estudiante domain) {
        if (domain == null) return null;

        return EstudianteEntity.builder()
                .codigo(domain.getCodigo())
                .nombre(domain.getNombre())
                .apellido(domain.getApellido())
                .correo(domain.getCorreo())
                .celular(domain.getCelular())
                .idInscripcion(domain.getIdInscripcion())
                .build();
    }

    @Override
    public List<Estudiante> toDomainList(List<EstudianteEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<EstudianteEntity> toEntityList(List<Estudiante> domainList) {
        if (domainList == null) return null;
        return domainList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
