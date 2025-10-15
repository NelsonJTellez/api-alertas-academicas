package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;


import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ResultadoGestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoJpaRepository extends JpaRepository<ResultadoGestionEntity, Integer> {

    List<ResultadoGestionEntity> findAll();
}
