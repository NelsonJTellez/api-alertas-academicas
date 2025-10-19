package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;


import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.base.BaseDTO;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignaturaDTO implements BaseDTO<Integer> {

    private Integer id;

    @NotBlank(message = "El nombre de la asignatura es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotNull(message = "Los créditos son obligatorios")
    @Min(value = 1, message = "Los créditos deben ser al menos 1")
    @Max(value = 10, message = "Los créditos no pueden exceder 10")
    private Integer creditos;

    private Integer idSemestre;
}