package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignaturaDTO {
    private Integer codAsignatura;
    private String nombre;
    private Integer creditos;

    // ← AGREGAR ESTE CAMPO (elimina idSemestre)
    private SemestreDTO semestre;
}
