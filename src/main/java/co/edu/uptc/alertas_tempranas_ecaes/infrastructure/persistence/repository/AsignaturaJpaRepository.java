package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.AsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaJpaRepository extends JpaRepository<AsignaturaEntity, Integer> {
    List<AsignaturaEntity> findByIdSemestre(Integer idSemestre);

    // Buscar todas las asignaturas bajo la jerarquía completa (colección)
    @Query("SELECT a FROM AsignaturaEntity a " +
           "JOIN SemestreEntity s ON a.idSemestre = s.idSemestre " +
           "JOIN ProgramaEntity p ON s.idPrograma = p.idPrograma " +
           "JOIN p.creads c " +
           "WHERE c.idCread = :idCread AND p.idPrograma = :idPrograma AND s.idSemestre = :idSemestre")
    List<AsignaturaEntity> findByCreadIdAndProgramaIdAndSemestreId(
        @Param("idCread") Integer idCread,
        @Param("idPrograma") Integer idPrograma,
        @Param("idSemestre") Integer idSemestre
    );

    // Buscar una asignatura específica validando la jerarquía completa
    @Query("SELECT a FROM AsignaturaEntity a " +
           "JOIN SemestreEntity s ON a.idSemestre = s.idSemestre " +
           "JOIN ProgramaEntity p ON s.idPrograma = p.idPrograma " +
           "JOIN p.creads c " +
           "WHERE c.idCread = :idCread AND p.idPrograma = :idPrograma AND s.idSemestre = :idSemestre AND a.codAsignatura = :codAsignatura")
    AsignaturaEntity findAsignaturaJerarquica(
        @Param("idCread") Integer idCread,
        @Param("idPrograma") Integer idPrograma,
        @Param("idSemestre") Integer idSemestre,
        @Param("codAsignatura") Integer codAsignatura
    );
}
