package co.edu.uptc.alertas_tempranas_ecaes.application.port;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.AlertaTemprana;

import java.util.List;
import java.util.Optional;

/**
 * Puerto (Port) para operaciones de persistencia de Alertas Tempranas.
 * Define el contrato que debe implementar el adapter de persistencia.
 */
public interface AlertaTempranaPort {

    /**
     * Busca una alerta por su ID
     */
    Optional<AlertaTemprana> findById(Integer id);

    /**
     * Obtiene todas las alertas
     */
    List<AlertaTemprana> findAll();

    /**
     * Busca todas las alertas de un estudiante específico
     */
    List<AlertaTemprana> findByEstudiante(Integer idEstudiante);

    /**
     * Busca todas las alertas creadas por un docente específico
     */
    List<AlertaTemprana> findByIdDocente(Long idDocente);

    /**
     * Verifica si existe una alerta con el ID dado
     */
    boolean existsById(Integer id);

    /**
     * Guarda o actualiza una alerta
     */
    AlertaTemprana save(AlertaTemprana alerta);

    /**
     * Elimina una alerta por su ID
     */
    void deleteById(Integer id);
}
