package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ProgramaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramaJpaRepository extends JpaRepository<ProgramaEntity, Integer> {

    // Listar todos los programas (para el selector)
    List<ProgramaEntity> findAll();
}
