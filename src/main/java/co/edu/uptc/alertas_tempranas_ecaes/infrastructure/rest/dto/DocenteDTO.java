package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;


import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.base.BaseDTO;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocenteDTO implements BaseDTO<Long> {
    private Long id;
    private String nombre;
    private String apellido;
    private Long cedula;
}
