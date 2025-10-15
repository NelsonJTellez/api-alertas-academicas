package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocenteDTO {
    private Long cedula;
    private String nombre;
    private String correo;
}
