package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto;

import lombok.*;

/**
 * DTO que encapsula toda la ruta de selección del formulario
 * CREAD → Programa → Semestre → Asignatura → Actividad
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContextoCompletoDTO {

    // Información completa de cada nivel seleccionado
    private CreadDTO cread;
    private ProgramaDTO programa;
    private SemestreDTO semestre;
    private AsignaturaDTO asignatura;
    private ActividadDTO actividad;

    // Resumen de la ruta en formato legible
    private String rutaCompleta;  // Ejemplo: "CREAD Tunja → Ingeniería → Semestre 1 → Programación I → Quiz 1"
}
