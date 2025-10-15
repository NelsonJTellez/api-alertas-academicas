package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "docente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocenteEntity {

    @Id
    @Column(nullable = false)
    private Long cedula; // PK en la tabla docente

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correo;
}
