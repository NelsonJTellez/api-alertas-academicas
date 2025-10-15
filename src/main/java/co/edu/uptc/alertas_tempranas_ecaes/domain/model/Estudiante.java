package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudiante {

    private Integer codigo;
    private String nombre;
    private String correo;
    private Long celular;
}
