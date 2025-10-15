package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstudianteEntity {

    @Id
    @Column(nullable = false)
    private Integer codigo; // PK en la tabla estudiante

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private Long celular;
}
