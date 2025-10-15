package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.AlertaTempranaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaJpaRepository extends JpaRepository<AlertaTempranaEntity, Integer> {

    // Buscar todas las alertas asociadas a un estudiante
    List<AlertaTempranaEntity> findByEstudianteCodigo(Integer codigoEstudiante);

    // Buscar todas las alertas asociadas a un docente
    List<AlertaTempranaEntity> findByDocenteCedula(Long cedulaDocente);
}
