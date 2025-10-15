package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actividad")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActividadEntity {

    @Id
    @Column(name = "id_actividad", nullable = false)  // ← Con guion bajo
    private Integer idActividad;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "cod_asignatura")  // ← Con guion bajo
    private Integer codAsignatura;
}
