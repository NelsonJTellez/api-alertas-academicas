package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstudianteDTO {
    private Integer codigo;
    private String nombre;
    private String correo;
    private Long celular;
}
