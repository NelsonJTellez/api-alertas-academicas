package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.base.BaseModel;
import lombok.*;

/**
 * Modelo de dominio para CREAD (Centro Regional de Educación a Distancia).
 * Representa un centro educativo dentro de la universidad.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cread implements BaseModel<Integer> {
    private Integer id;
    private String nombre;
    private String direccion;
}
