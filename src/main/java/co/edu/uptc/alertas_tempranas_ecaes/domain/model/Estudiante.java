package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    private Integer codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private Long celular;
    private Integer idInscripcion;
}
