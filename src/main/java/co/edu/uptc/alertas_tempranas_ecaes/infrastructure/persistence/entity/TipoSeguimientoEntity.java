package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_seguimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoSeguimientoEntity {

    @Id
    @Column(name = "idseguimiento", nullable = false)
    private Integer idSeguimiento;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(length = 100)
    private String detalle;

    @Column(name = "actividadreportada", nullable = false)
    private Integer actividadReportada; // FK a reporte_actividad
}
