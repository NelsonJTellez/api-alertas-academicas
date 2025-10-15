package co.edu.uptc.alertas_tempranas_ecaes.application.port;

import co.edu.uptc.alertas_tempranas_ecaes.domain.model.AlertaTemprana;

import java.util.List;
import java.util.Optional;

public interface AlertaRepositoryPort {

    AlertaTemprana guardar(AlertaTemprana alerta);
    List<AlertaTemprana> listarPorEstudiante(Integer codigoEstudiante);
    List<AlertaTemprana> listarPorDocente(Long cedulaDocente);
    Optional<AlertaTemprana> buscarPorId(Integer id);
}
