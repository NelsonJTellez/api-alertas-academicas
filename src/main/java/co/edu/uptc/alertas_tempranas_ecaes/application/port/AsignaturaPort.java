package co.edu.uptc.alertas_tempranas_ecaes.application.port;


import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Asignatura;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para operaciones sobre Asignatura.
 */
public interface AsignaturaPort {

    // Operaciones de lectura
    Optional<Asignatura> findById(Integer id);
    List<Asignatura> findByIdSemestre(Integer idSemestre);
    boolean existsById(Integer id);

    // Operaciones de escritura
    Asignatura save(Asignatura asignatura);
    void deleteById(Integer id);
}
