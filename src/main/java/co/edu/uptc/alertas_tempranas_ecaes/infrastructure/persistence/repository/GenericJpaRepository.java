package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repositorio genérico base que extiende JpaRepository.
 * Proporciona operaciones CRUD estándar para todas las entidades.
 *
 * @param <T> Tipo de la entidad
 * @param <ID> Tipo del identificador de la entidad
 */
@NoRepositoryBean
public interface GenericJpaRepository<T, ID> extends JpaRepository<T, ID> {
    // Métodos heredados de JpaRepository:
    // - Optional<T> findById(ID id)
    // - List<T> findAll()
    // - T save(T entity)
    // - void deleteById(ID id)
    // - boolean existsById(ID id)
    // - long count()
    // - void delete(T entity)
    // - void deleteAll()
}
