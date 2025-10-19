package co.edu.uptc.alertas_tempranas_ecaes.application.port;


import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Programa;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para operaciones sobre Programa.
 */
public interface ProgramaPort {

    // Operaciones de lectura
    Optional<Programa> findById(Integer id);
    List<Programa> findProgramasByCreadId(Integer idCread);
    boolean existsById(Integer id);

    // Operaciones de escritura
    Programa save(Programa programa);
    void deleteById(Integer id);
}
