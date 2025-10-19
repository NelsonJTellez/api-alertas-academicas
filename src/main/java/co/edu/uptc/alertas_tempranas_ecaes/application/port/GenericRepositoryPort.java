package co.edu.uptc.alertas_tempranas_ecaes.application.port;


import co.edu.uptc.alertas_tempranas_ecaes.domain.model.base.BaseModel;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Puerto genérico que define operaciones CRUD básicas para repositorios.
 * Los adaptadores de persistencia implementarán este puerto.
 *
 * Este puerto trabaja con modelos de dominio, NO con entidades de persistencia.
 *
 * @param <T> Tipo del modelo de dominio
 * @param <ID> Tipo del identificador
 */
public interface GenericRepositoryPort<T extends BaseModel<ID>, ID extends Serializable> {

    /**
     * Guarda o actualiza un modelo de dominio
     *
     * @param modelo el modelo a guardar
     * @return el modelo guardado con su ID asignado
     */
    T guardar(T modelo);

    /**
     * Busca un modelo por su identificador
     *
     * @param id el identificador del modelo
     * @return Optional conteniendo el modelo si existe, Optional.empty() si no
     */
    Optional<T> buscarPorId(ID id);

    /**
     * Lista todos los modelos
     *
     * @return lista de todos los modelos (puede estar vacía)
     */
    List<T> listarTodos();

    /**
     * Elimina un modelo por su identificador
     *
     * @param id el identificador del modelo a eliminar
     */
    void eliminarPorId(ID id);

    /**
     * Verifica si existe un modelo con el ID especificado
     *
     * @param id el identificador a verificar
     * @return true si existe, false si no
     */
    boolean existePorId(ID id);

    /**
     * Cuenta el total de modelos
     *
     * @return cantidad total de registros
     */
    long contar();
}
