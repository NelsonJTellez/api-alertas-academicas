package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaTemprana {

    private Integer id;
    private String descripcion;
    private LocalDate fechaRegistro;

    // Relaciones principales
    private Docente docente;
    private Estudiante estudiante;

    // Referencias auxiliares (foráneas a otras tablas)
    private Integer idActividadReportada;
    private Integer idSeguimiento;
}
