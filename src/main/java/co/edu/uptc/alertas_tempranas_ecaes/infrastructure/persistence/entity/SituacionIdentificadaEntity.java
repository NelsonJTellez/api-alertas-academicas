package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "situacion_identificada")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SituacionIdentificadaEntity {

    @Id
    @Column(name = "idsituacion", nullable = false)
    private Integer idSituacion;

    @Column(nullable = false, length = 100)
    private String nombre;
}
