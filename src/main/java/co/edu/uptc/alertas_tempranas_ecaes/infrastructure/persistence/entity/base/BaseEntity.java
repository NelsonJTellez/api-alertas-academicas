package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;

/**
 * Clase base abstracta para todas las entidades de persistencia JPA.
 * Proporciona funcionalidad común y estructura para entidades que se mapean a tablas de base de datos.
 *
 * @param <ID> Tipo del identificador de la entidad
 */
@MappedSuperclass
@Data
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Obtiene el identificador único de la entidad
     *
     * @return el identificador único
     */
    public abstract ID getId();

    /**
     * Establece el identificador único de la entidad
     *
     * @param id el identificador a asignar
     */
    public abstract void setId(ID id);

    /**
     * Determina si la entidad es nueva (no persistida aún)
     *
     * @return true si la entidad no tiene ID asignado, false en caso contrario
     */
    public boolean isNew() {
        return getId() == null;
    }

    /**
     * Compara esta entidad con otra basándose en su identificador
     *
     * @param o objeto a comparar
     * @return true si tienen el mismo ID, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity<?> that = (BaseEntity<?>) o;

        if (getId() == null || that.getId() == null) {
            return false;
        }

        return getId().equals(that.getId());
    }

    /**
     * Genera hash code basado en el identificador
     *
     * @return hash code de la entidad
     */
    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
