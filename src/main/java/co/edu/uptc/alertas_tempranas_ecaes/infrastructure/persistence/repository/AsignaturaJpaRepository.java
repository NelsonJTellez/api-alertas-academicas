package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;



import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.AsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaJpaRepository extends JpaRepository<AsignaturaEntity, Integer> {

    // Buscar asignaturas por semestre (dependiente)
    List<AsignaturaEntity> findByIdSemestre(Integer idSemestre);
}
