package co.edu.uptc.alertas_tempranas_ecaes.application.service;


import co.edu.uptc.alertas_tempranas_ecaes.application.port.ContextoRepositoryPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Docente;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidacionService {

    private final ContextoRepositoryPort contextoRepository;

    public Optional<Docente> validarDocente(Long cedula) {
        return contextoRepository.buscarDocentePorCedula(cedula);
    }

    public Optional<Estudiante> validarEstudiante(Integer codigo) {
        return contextoRepository.buscarEstudiantePorCodigo(codigo);
    }
}
