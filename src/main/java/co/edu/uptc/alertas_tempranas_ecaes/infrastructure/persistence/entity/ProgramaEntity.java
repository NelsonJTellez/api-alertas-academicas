package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;
// 3. package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set; // Importado para la colección ManyToMany

@Entity
@Table(name = "programa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramaEntity {

    @Id
    @Column(name = "id_programa", nullable = false)
    private Integer idPrograma;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    // 🌟 Mapeo de la relación Muchos a Muchos (N:M)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "cread_programa", // Nombre de la tabla de mapeo N:M en la base de datos
        joinColumns = @JoinColumn(name = "id_programa"), // Columna que apunta a esta entidad (Programa)
        inverseJoinColumns = @JoinColumn(name = "id_cread") // Columna que apunta a la otra entidad (Cread)
    )
    private Set<CreadEntity> creads; // Colección de CREADs asociados
}