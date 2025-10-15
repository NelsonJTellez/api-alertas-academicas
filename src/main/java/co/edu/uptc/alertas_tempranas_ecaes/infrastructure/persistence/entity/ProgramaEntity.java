package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "programa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramaEntity {

    @Id
    @Column(name = "id_programa", nullable = false)  // ← CORREGIDO: id_programa con guion bajo
    private Integer idPrograma;

    @Column(name = "nombre", nullable = false, length = 100)  // ← AGREGADO: nombre de columna explícito
    private String nombre;

    @Column(name = "descripcion", length = 100)  // ← AGREGADO: nombre de columna explícito
    private String descripcion;

    @Column(name = "id_cread", nullable = false)  // ← CORREGIDO: id_cread con guion bajo
    private Integer idCread;
}
