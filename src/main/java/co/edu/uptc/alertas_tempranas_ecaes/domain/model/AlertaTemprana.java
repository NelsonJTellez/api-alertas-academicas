package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.base.BaseModel;
import lombok.*;

/**
 * Modelo de dominio para Alerta Temprana.
 * Representa una alerta generada para un estudiante por parte de un docente.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaTemprana implements BaseModel<Integer> {
    private Integer id;
    private String descripcion;
    private Integer idEstudiante;
    private Long idDocente;
}
