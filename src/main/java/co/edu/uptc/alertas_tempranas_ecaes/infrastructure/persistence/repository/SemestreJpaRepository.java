package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.SemestreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SemestreJpaRepository extends JpaRepository<SemestreEntity, Integer> {
    List<SemestreEntity> findByIdPrograma(Integer idPrograma);

    // Buscar un semestre específico bajo la jerarquía CREAD-PROGRAMA-SEMESTRE
    @Query("SELECT s FROM SemestreEntity s " +
           "JOIN ProgramaEntity p ON s.idPrograma = p.idPrograma " +
           "JOIN p.creads c " +
           "WHERE c.idCread = :idCread AND p.idPrograma = :idPrograma AND s.idSemestre = :idSemestre")
    SemestreEntity findSemestreJerarquico(
        @Param("idCread") Integer idCread,
        @Param("idPrograma") Integer idPrograma,
        @Param("idSemestre") Integer idSemestre
    );
}
