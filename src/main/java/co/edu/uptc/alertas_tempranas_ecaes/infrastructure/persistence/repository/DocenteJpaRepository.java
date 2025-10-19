package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteJpaRepository extends JpaRepository<DocenteEntity, Long> {
    // Métodos heredados:
    // - Optional<DocenteEntity> findById(Long cedula)
    // - List<DocenteEntity> findAll()
    // - DocenteEntity save(DocenteEntity entity)
    // - void deleteById(Long cedula)
    // - boolean existsById(Long cedula)
}
