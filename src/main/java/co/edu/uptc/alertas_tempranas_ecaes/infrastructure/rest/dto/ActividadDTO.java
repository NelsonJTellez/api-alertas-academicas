package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActividadDTO {
    private Integer idActividad;
    private String nombre;

    // Ruta completa: Asignatura → Semestre → Programa → CREAD
    private AsignaturaDTO asignatura;
}
