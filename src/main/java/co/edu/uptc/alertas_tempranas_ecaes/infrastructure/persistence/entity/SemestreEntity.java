package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "semestre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemestreEntity extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semestre")
    private Integer id;

    @Column(name = "id_programa", nullable = false)
    private Integer idPrograma;

    @Column(name = "numero_orden", nullable = false)
    private Integer numeroOrden;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
}
