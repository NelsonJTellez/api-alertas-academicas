package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteJpaRepository extends JpaRepository<EstudianteEntity, Integer> {

    // Buscar estudiante por código
    Optional<EstudianteEntity> findByCodigo(Integer codigo);

    // Buscar por correo si se requiere validación adicional
    Optional<EstudianteEntity> findByCorreo(String correo);
}
