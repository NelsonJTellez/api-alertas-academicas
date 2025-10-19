package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.AsignaturaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaJpaRepository extends GenericJpaRepository<AsignaturaEntity, Integer> {

    /**
     * Encuentra todas las asignaturas asociadas a un semestre específico
     */
    List<AsignaturaEntity> findByIdSemestre(Integer idSemestre);
}
