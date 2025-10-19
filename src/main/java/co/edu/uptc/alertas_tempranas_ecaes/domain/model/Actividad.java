package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.base.BaseModel;
import lombok.*;

/**
 * Modelo de dominio para Actividad.
 * Representa una tarea, examen o trabajo asociado a una asignatura.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actividad implements BaseModel<Integer> {
    private Integer id;
    private String nombre;
}
