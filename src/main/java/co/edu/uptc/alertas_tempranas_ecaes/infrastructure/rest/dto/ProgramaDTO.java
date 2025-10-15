package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramaDTO {
    private Integer idPrograma;
    private String nombre;
    private String descripcion;

    // ← AGREGAR ESTE CAMPO
    private CreadDTO cread;
}
