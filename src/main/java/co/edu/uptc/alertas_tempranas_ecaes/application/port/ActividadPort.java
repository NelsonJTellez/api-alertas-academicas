package co.edu.uptc.alertas_tempranas_ecaes.application.port;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Actividad;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para operaciones sobre Actividad.
 */
public interface ActividadPort {

    // Operaciones de lectura
    Optional<Actividad> findById(Integer id);
    List<Actividad> findByCodAsignatura(Integer codAsignatura);
    boolean existsById(Integer id);

    // Operaciones de escritura
    Actividad save(Actividad actividad);
    void deleteById(Integer id);
}
