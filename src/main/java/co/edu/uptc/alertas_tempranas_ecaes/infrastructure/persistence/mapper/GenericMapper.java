package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper;

import java.util.List;

/**
 * Interfaz genérica para mappers entre entidades JPA y modelos de dominio.
 * Proporciona métodos estándar para la conversión bidireccional.
 *
 * @param <E> Tipo de la entidad JPA (Entity)
 * @param <D> Tipo del modelo de dominio (Domain)
 * @param <ID> Tipo del identificador (Integer, Long, etc.)
 *
 * @author Sistema Alertas Tempranas ECAES - UPTC
 */
public interface GenericMapper<E, D, ID> {

    /**
     * Convierte una entidad JPA a un modelo de dominio.
     *
     * @param entity Entidad JPA a convertir
     * @return Modelo de dominio correspondiente, o null si entity es null
     */
    D toDomain(E entity);

    /**
     * Convierte un modelo de dominio a una entidad JPA.
     *
     * @param domain Modelo de dominio a convertir
     * @return Entidad JPA correspondiente, o null si domain es null
     */
    E toEntity(D domain);

    /**
     * Convierte una lista de entidades JPA a una lista de modelos de dominio.
     *
     * @param entities Lista de entidades JPA a convertir
     * @return Lista de modelos de dominio correspondientes, o null si entities es null
     */
    List<D> toDomainList(List<E> entities);

    /**
     * Convierte una lista de modelos de dominio a una lista de entidades JPA.
     *
     * @param domainList Lista de modelos de dominio a convertir
     * @return Lista de entidades JPA correspondientes, o null si domainList es null
     */
    List<E> toEntityList(List<D> domainList);
}
