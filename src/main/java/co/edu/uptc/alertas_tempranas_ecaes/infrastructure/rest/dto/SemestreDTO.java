package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;


import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.base.BaseDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemestreDTO implements BaseDTO<Integer> {
    private Integer id;
    private String descripcion;
    private Integer idPrograma; // Referencia jerárquica
}

