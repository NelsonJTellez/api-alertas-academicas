package co.edu.uptc.alertas_tempranas_ecaes.domain.model.base;

import java.io.Serializable;

/**
 * Interfaz base para todos los modelos de dominio.
 * Establece el contrato mínimo que deben cumplir las entidades del núcleo de negocio.
 *
 * @param <ID> Tipo del identificador único de la entidad
 */
public interface BaseModel<ID extends Serializable> {

    /**
     * Obtiene el identificador único de la entidad de dominio
     *
     * @return el identificador único
     */
    ID getId();

    /**
     * Establece el identificador único de la entidad de dominio
     *
     * @param id el identificador a asignar
     */
    void setId(ID id);
}
