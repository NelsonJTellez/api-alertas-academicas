package co.edu.uptc.alertas_tempranas_ecaes.application.port;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Docente;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para operaciones sobre Docente.
 */
public interface DocentePort {

    // Operaciones de lectura
    Optional<Docente> findById(Long id);
    Optional<Docente> buscarPorCedula(Long cedula);
    List<Docente> findAll();
    boolean existsById(Long id);

    // Operaciones de escritura
    Docente save(Docente docente);
    void deleteById(Long id);
}
