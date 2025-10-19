package co.edu.uptc.alertas_tempranas_ecaes.domain.exception;


/**
 * Excepción lanzada cuando se viola una regla de negocio.
 * Típicamente resulta en una respuesta HTTP 422 (Unprocessable Entity).
 *
 * Ejemplos:
 * - Intentar inscribir un estudiante en un semestre que no corresponde
 * - Crear una actividad para una asignatura que ya tiene el máximo permitido
 * - Registrar una alerta para un estudiante que no está activo
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String mensaje) {
        super(mensaje);
    }

    public BusinessException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
