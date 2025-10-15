package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reporte_actividad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteActividadEntity {

    @Id
    @Column(name = "idreporte", nullable = false)
    private Integer idReporte;

    @Column(name = "idactividad", nullable = false)
    private Integer idActividad; // FK a actividad

    @Column(name = "periodoacademico", nullable = false)
    private String periodoAcademico;

    @Column(name = "idseguimiento", nullable = false)
    private Integer idSeguimiento; // FK a tipo_seguimiento
}
