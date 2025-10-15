package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;


import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ActividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadJpaRepository extends JpaRepository<ActividadEntity, Integer> {

    // Buscar actividades por asignatura (dependiente)
    List<ActividadEntity> findByCodAsignatura(Integer codAsignatura);
}
