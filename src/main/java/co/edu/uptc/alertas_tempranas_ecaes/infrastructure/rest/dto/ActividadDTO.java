package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;


import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.base.BaseDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActividadDTO implements BaseDTO<Integer> {
    private Integer id;
    private String nombre;
    private Integer idAsignatura; // Referencia jerárquica
}
