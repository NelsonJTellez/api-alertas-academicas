package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ActividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadJpaRepository extends JpaRepository<ActividadEntity, Integer> {
    List<ActividadEntity> findByCodAsignatura(Integer codAsignatura);

    // Método jerárquico: CREAD, Programa, Semestre y Asignatura
    @Query("SELECT act FROM ActividadEntity act " +
           "JOIN AsignaturaEntity a ON act.codAsignatura = a.codAsignatura " +
           "JOIN SemestreEntity s ON a.idSemestre = s.idSemestre " +
           "JOIN ProgramaEntity p ON s.idPrograma = p.idPrograma " +
           "JOIN p.creads c " +
           "WHERE c.idCread = :idCread AND p.idPrograma = :idPrograma AND s.idSemestre = :idSemestre AND a.codAsignatura = :codAsignatura")
    List<ActividadEntity> findByCreadIdAndProgramaIdAndSemestreIdAndCodAsignatura(
        @Param("idCread") Integer idCread,
        @Param("idPrograma") Integer idPrograma,
        @Param("idSemestre") Integer idSemestre,
        @Param("codAsignatura") Integer codAsignatura
    );
}
