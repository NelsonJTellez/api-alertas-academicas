package co.edu.uptc.alertas_tempranas_ecaes.domain.exception;


public class ValidationException extends RuntimeException {
    public ValidationException(String mensaje) {
        super(mensaje);
    }
}
