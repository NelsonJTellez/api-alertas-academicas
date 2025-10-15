package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.SemestreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemestreJpaRepository extends JpaRepository<SemestreEntity, Integer> {

    // Buscar semestres por programa (dependiente)
    List<SemestreEntity> findByIdPrograma(Integer idPrograma);
}
