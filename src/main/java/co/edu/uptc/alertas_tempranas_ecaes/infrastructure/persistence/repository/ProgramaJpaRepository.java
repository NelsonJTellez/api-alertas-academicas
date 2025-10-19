package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ProgramaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramaJpaRepository extends GenericJpaRepository<ProgramaEntity, Integer> {

    /**
     * Busca todos los programas asociados a un CREAD específico por su ID.
     * Se navega a través de la colección 'creades' (la relación Many-to-Many).
     *
     * @param idCread El ID del CREAD.
     * @return Una lista de ProgramaEntity.
     */
    // Se cambia 'Cread_Id' a 'Creades_Id' para coincidir con el campo de colección en ProgramaEntity
    List<ProgramaEntity> findByCreades_Id(Integer idCread);
}