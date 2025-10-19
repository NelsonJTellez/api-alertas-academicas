package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Asignatura;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.AsignaturaEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper para convertir entre AsignaturaEntity (JPA) y Asignatura (Domain).
 * Implementa la interfaz GenericMapper para mantener consistencia con otros mappers.
 */
@Component
public class AsignaturaMapper implements GenericMapper<AsignaturaEntity, Asignatura, Integer> {

    /**
     * Convierte una entidad JPA de Asignatura a modelo de dominio.
     *
     * @param entity AsignaturaEntity de la base de datos
     * @return Asignatura modelo de dominio, o null si entity es null
     */
    @Override
    public Asignatura toDomain(AsignaturaEntity entity) {
        if (entity == null) return null;

        return Asignatura.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .idSemestre(entity.getIdSemestre())
                .build();
    }

    /**
     * Convierte un modelo de dominio de Asignatura a entidad JPA.
     *
     * @param domain Asignatura modelo de dominio
     * @return AsignaturaEntity para persistir en BD, o null si domain es null
     */
    @Override
    public AsignaturaEntity toEntity(Asignatura domain) {
        if (domain == null) return null;

        return AsignaturaEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .idSemestre(domain.getIdSemestre())
                .build();
    }

    /**
     * Convierte una lista de entidades JPA a lista de modelos de dominio.
     *
     * @param entities Lista de AsignaturaEntity de la base de datos
     * @return Lista de Asignatura (dominio), o null si entities es null
     */
    @Override
    public List<Asignatura> toDomainList(List<AsignaturaEntity> entities) {
        if (entities == null) return null;
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de modelos de dominio a lista de entidades JPA.
     *
     * @param domainList Lista de Asignatura (dominio)
     * @return Lista de AsignaturaEntity para persistir, o null si domainList es null
     */
    @Override
    public List<AsignaturaEntity> toEntityList(List<Asignatura> domainList) {
        if (domainList == null) return null;
        return domainList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
