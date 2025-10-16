package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.CreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreadJpaRepository extends JpaRepository<CreadEntity, Integer> {
    List<CreadEntity> findAll();
}
