package co.edu.uptc.alertas_tempranas_ecaes.domain.model;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.base.BaseModel;
import lombok.*;

/**
 * Modelo de dominio para Semestre.
 * Representa un periodo académico dentro de un programa.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Semestre implements BaseModel<Integer> {
    private Integer id;
    private Integer idPrograma;      // ← AGREGAR (viene de la entity)
    private Integer numeroOrden;     // ← CORREGIR: camelCase y Integer
    private String descripcion;
}
