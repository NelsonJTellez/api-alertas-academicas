package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.base.BaseModel;
import lombok.*;

/**
 * Modelo de dominio para Asignatura.
 * Representa una materia o curso dentro de un semestre.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asignatura implements BaseModel<Integer> {
    private Integer id;
    private String nombre;
    private Integer creditos;
    private Integer idSemestre;  // ← AGREGAR ESTE CAMPO
}
