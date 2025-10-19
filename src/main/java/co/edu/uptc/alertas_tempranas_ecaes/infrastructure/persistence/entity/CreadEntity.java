package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "cread")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreadEntity extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cread")  // ✅ Coincide con la BD
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", length = 200)
    private String direccion;  // ← Asegúrate de tener este campo
}
