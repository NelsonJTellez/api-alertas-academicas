package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resultado_gestion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoGestionEntity {

    @Id
    @Column(name = "idresultado", nullable = false)
    private Integer idResultado;

    @Column(nullable = false, length = 100)
    private String nombre;
}
