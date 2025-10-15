package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cread")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreadEntity {

    @Id
    @Column(name = "id_cread", nullable = false)  // ← Con guion bajo
    private Integer idCread;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", length = 100)
    private String direccion;
}
