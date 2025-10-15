package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemestreDTO {
    private Integer idSemestre;
    private String descripcion;

    // ← AGREGAR ESTE CAMPO (elimina idPrograma)
    private ProgramaDTO programa;
}
