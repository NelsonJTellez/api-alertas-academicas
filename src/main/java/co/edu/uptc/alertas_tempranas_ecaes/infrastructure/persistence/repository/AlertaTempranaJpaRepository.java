package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.AlertaTempranaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaTempranaJpaRepository extends JpaRepository<AlertaTempranaEntity, Integer> {

    /**
     * Busca todas las alertas de un estudiante específico
     */
    List<AlertaTempranaEntity> findByIdEstudiante(Integer idEstudiante);

    /**
     * Busca todas las alertas creadas por un docente específico
     */
    List<AlertaTempranaEntity> findByIdDocente(Long idDocente);
}
