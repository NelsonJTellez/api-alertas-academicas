package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;



import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.SituacionIdentificadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SituacionJpaRepository extends JpaRepository<SituacionIdentificadaEntity, Integer> {

    List<SituacionIdentificadaEntity> findAll();
}
