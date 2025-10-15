package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "alerta_temprana")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertaTempranaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta_temprana", nullable = false)
    private Integer id;

    // Relación con estudiante
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante", nullable = false)
    private EstudianteEntity estudiante;

    // Relación con docente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente", nullable = false)
    private DocenteEntity docente;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    // 🔹 Claves foráneas a otras tablas (se agregarán más adelante)
    @Column(name = "id_actividad_reportada", nullable = false)
    private Integer idActividadReportada;

    @Column(name = "id_seguimiento", nullable = false)
    private Integer idSeguimiento;
}
