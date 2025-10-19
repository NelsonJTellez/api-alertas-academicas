package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad JPA para la tabla 'alerta_temprana'
 * Representa una alerta generada para un estudiante
 */
@Entity
@Table(name = "alerta_temprana")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaTempranaEntity extends BaseEntity<Integer> {

    /**
     * ID único de la alerta (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Integer id;

    /**
     * Descripción de la alerta
     */
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    /**
     * ID del estudiante al que se le asigna la alerta
     * Referencia a estudiante.codigo
     */
    @Column(name = "id_estudiante", nullable = false)
    private Integer idEstudiante;

    /**
     * ID del docente que crea la alerta
     * Referencia a docente.cedula
     */
    @Column(name = "id_docente", nullable = false)
    private Long idDocente;
}
