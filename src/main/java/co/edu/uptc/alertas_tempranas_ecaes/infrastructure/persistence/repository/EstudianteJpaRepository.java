package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteJpaRepository extends JpaRepository<EstudianteEntity, Integer> {
    // Métodos heredados:
    // - Optional<EstudianteEntity> findById(Integer codigo)
    // - List<EstudianteEntity> findAll()
    // - EstudianteEntity save(EstudianteEntity entity)
    // - void deleteById(Integer codigo)
    // - boolean existsById(Integer codigo)
}
