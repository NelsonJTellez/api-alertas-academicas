package co.edu.uptc.alertas_tempranas_ecaes.application.port;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Cread;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para operaciones sobre CREAD.
 * Define operaciones de lectura y escritura.
 */
public interface CreadPort {

    // Operaciones de lectura
    List<Cread> findAll();
    Optional<Cread> findById(Integer id);
    boolean existsById(Integer id);

    // Operaciones de escritura
    Cread save(Cread cread);
    void deleteById(Integer id);
}
