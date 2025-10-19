package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="docente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocenteEntity {
    /**
     * Cédula del docente (Primary Key)
     */
    @Id
    @Column(name = "cedula", nullable = false)
    private Long cedula;

    /**
     * Nombre del docente
     */
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    /**
     * Apellido del docente
     */
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    /**
     * Correo electrónico del docente
     */
    @Column(name = "correo", nullable = false, length = 255)
    private String correo;


}
