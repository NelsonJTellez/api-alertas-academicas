package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogoDTO {
    private Integer id;
    private String nombre;
    private String detalle; // Opcional, para tipos de seguimiento
}
