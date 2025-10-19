package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.base;

import java.io.Serializable;

/**
 * Interfaz base para todos los DTOs (Data Transfer Objects).
 * Define el contrato mínimo para objetos que transfieren datos entre capas externas.
 *
 * @param <ID> Tipo del identificador
 */
public interface BaseDTO<ID extends Serializable> extends Serializable {

    /**
     * Obtiene el identificador del DTO
     *
     * @return el identificador único
     */
    ID getId();
}
