package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asignatura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignaturaEntity {

    @Id
    @Column(name = "cod_asignatura", nullable = false) 
    private Integer codAsignatura;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "creditos", nullable = false)
    private Integer creditos;

    @Column(name = "id_semestre", nullable = false)  
    private Integer idSemestre;

}
