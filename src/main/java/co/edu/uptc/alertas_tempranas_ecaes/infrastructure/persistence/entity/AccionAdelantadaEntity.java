package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accion_adelantada")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccionAdelantadaEntity {

    @Id
    @Column(name = "idaccion", nullable = false)
    private Integer idAccion;

    @Column(nullable = false, length = 100)
    private String nombre;
}
