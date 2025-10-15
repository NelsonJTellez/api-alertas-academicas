package co.edu.uptc.alertas_tempranas_ecaes.application.port;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Docente;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Estudiante;

import java.util.Optional;

public interface ContextoRepositoryPort {

    Optional<Docente> buscarDocentePorCedula(Long cedula);
    Optional<Estudiante> buscarEstudiantePorCodigo(Integer codigo);
}
