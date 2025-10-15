package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocenteJpaRepository extends JpaRepository<DocenteEntity, Long> {

    // Buscar docente por cédula
    Optional<DocenteEntity> findByCedula(Long cedula);
}
