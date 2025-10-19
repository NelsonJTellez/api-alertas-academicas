package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.base.BaseModel;
import lombok.*;

/**
 * Modelo de dominio para Programa Académico.
 * Representa un programa de estudio ofrecido por un CREAD.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Programa implements BaseModel<Integer> {
    private Integer id;
    private String nombre;
    private String descripcion;
}
