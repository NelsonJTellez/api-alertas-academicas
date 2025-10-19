package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "programa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramaEntity extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programa")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    // Relación Many-to-Many con CREAD a través de tabla intermedia
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cread_programa",
            joinColumns = @JoinColumn(name = "id_programa"),
            inverseJoinColumns = @JoinColumn(name = "id_cread")
    )
    private Set<CreadEntity> creades;
}
