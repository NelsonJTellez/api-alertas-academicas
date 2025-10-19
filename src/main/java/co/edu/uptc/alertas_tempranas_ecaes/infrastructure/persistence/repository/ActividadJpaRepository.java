package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ActividadEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadJpaRepository extends GenericJpaRepository<ActividadEntity, Integer> {

    /**
     * Encuentra todas las actividades asociadas a una asignatura específica
     */
    List<ActividadEntity> findByCodAsignatura(Integer codAsignatura);
}
