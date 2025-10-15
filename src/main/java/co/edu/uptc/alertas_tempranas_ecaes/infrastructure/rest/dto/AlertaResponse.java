package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaResponse {

    private Integer id;
    private String descripcion;
    private LocalDate fechaRegistro;
    private String nombreDocente;
    private String nombreEstudiante;
}
