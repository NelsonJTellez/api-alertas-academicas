package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gestion_realizada")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GestionRealizadaEntity {

    @Id
    @Column(name = "idgestion", nullable = false)
    private Integer idGestion;

    @Column(nullable = false, length = 100)
    private String nombre;
}
