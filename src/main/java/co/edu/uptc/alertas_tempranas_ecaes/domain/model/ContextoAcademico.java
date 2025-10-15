package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContextoAcademico {

    private Integer idPrograma;
    private String nombrePrograma;
    private Integer idSemestre;
    private String descripcionSemestre;
    private Integer idAsignatura;
    private String nombreAsignatura;
    private Integer idActividad;
    private String nombreActividad;
}
