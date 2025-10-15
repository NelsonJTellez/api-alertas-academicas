package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "semestre")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemestreEntity {

    @Id
    @Column(name = "id_semestre", nullable = false)  // ← Con guion bajo
    private Integer idSemestre;

    @Column(name = "id_programa", nullable = false)  // ← Con guion bajo
    private Integer idPrograma;

    @Column(name = "descripcion", length = 50)
    private String descripcion;
}
