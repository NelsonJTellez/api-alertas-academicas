package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormularioAlertaRequest {

    private Long cedulaDocente;         // FK docente
    private Integer codigoEstudiante;   // FK estudiante
    private String descripcion;         // Texto de la alerta
    private Integer idActividadReportada;
    private Integer idSeguimiento;
    private LocalDate fechaRegistro;    // Opcional (si no se envía, se asigna LocalDate.now())
}
