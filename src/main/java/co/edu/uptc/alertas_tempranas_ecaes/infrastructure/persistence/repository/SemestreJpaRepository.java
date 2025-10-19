package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.SemestreEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemestreJpaRepository extends GenericJpaRepository<SemestreEntity, Integer> {

    /**
     * Encuentra todos los semestres asociados a un programa específico
     */
    List<SemestreEntity> findByIdPrograma(Integer idPrograma);
}
