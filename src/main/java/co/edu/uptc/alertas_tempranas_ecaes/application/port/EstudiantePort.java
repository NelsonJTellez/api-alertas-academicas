package co.edu.uptc.alertas_tempranas_ecaes.application.port;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Estudiante;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para operaciones sobre Estudiante.
 */
public interface EstudiantePort {

    // Operaciones de lectura
    Optional<Estudiante> findById(Integer id);
    Optional<Estudiante> buscarPorCodigo(Integer codigo);
    List<Estudiante> findAll();
    boolean existsById(Integer id);

    // Operaciones de escritura
    Estudiante save(Estudiante estudiante);
    void deleteById(Integer id);
}
