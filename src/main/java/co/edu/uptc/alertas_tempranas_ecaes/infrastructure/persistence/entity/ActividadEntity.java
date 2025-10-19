package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actividad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActividadEntity extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "cod_asignatura")
    private Integer codAsignatura;
}
