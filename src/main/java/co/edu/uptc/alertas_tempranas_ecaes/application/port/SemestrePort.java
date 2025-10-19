package co.edu.uptc.alertas_tempranas_ecaes.application.port;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Semestre;

import java.util.List;
import java.util.Optional;

/**
 * Puerto para operaciones sobre Semestre.
 * Define el contrato para las operaciones de acceso a datos de semestres académicos.
 */
public interface SemestrePort {

    // ========== OPERACIONES DE LECTURA ==========

    /**
     * Busca un semestre por su ID
     * @param id identificador único del semestre
     * @return Optional con el semestre si existe, vacío si no
     */
    Optional<Semestre> findById(Integer id);

    /**
     * Encuentra todos los semestres asociados a un programa específico
     * @param idPrograma identificador del programa
     * @return lista de semestres del programa
     */
    List<Semestre> findByIdPrograma(Integer idPrograma);

    /**
     * Lista todos los semestres del sistema
     * @return lista de todos los semestres
     */
    List<Semestre> findAll();

    /**
     * Verifica si existe un semestre con el ID especificado
     * @param id identificador a verificar
     * @return true si existe, false si no
     */
    boolean existsById(Integer id);

    // ========== OPERACIONES DE ESCRITURA ==========

    /**
     * Guarda o actualiza un semestre
     * @param semestre el semestre a guardar
     * @return el semestre guardado con ID asignado
     */
    Semestre save(Semestre semestre);

    /**
     * Elimina un semestre por su ID
     * @param id identificador del semestre a eliminar
     */
    void deleteById(Integer id);
}
