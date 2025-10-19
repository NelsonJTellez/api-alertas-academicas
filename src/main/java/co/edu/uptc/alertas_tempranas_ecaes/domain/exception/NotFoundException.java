package co.edu.uptc.alertas_tempranas_ecaes.domain.exception;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensaje) {
        super(mensaje);
    }
}
