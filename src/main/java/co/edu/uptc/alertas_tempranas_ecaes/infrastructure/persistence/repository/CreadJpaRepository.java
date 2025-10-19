package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.CreadEntity;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad CREAD.
 * Hereda todas las operaciones CRUD básicas de GenericJpaRepository.
 */
@Repository
public interface CreadJpaRepository extends GenericJpaRepository<CreadEntity, Integer> {

    // Los métodos heredados de GenericJpaRepository son suficientes para CREAD
    // Si necesitas métodos personalizados, agrégalos aquí
    // Por ejemplo:
    // List<CreadEntity> findByNombreContaining(String nombre);
}
