package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ProgramaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProgramaJpaRepository extends JpaRepository<ProgramaEntity, Integer> {
    @Query("SELECT p FROM ProgramaEntity p JOIN p.creads c WHERE c.idCread = :idCread")
    List<ProgramaEntity> findProgramasByCreadId(@Param("idCread") Integer idCread);
}
