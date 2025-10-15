package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.ContextoRepositoryPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Docente;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Estudiante;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.DocenteJpaRepository;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.EstudianteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ContextoPersistenceAdapter implements ContextoRepositoryPort {

    private final DocenteJpaRepository docenteRepository;
    private final EstudianteJpaRepository estudianteRepository;

    @Override
    public Optional<Docente> buscarDocentePorCedula(Long cedula) {
        return docenteRepository.findByCedula(cedula)
                .map(entity -> new Docente(entity.getCedula(), entity.getNombre(), entity.getCorreo()));
    }

    @Override
    public Optional<Estudiante> buscarEstudiantePorCodigo(Integer codigo) {
        return estudianteRepository.findByCodigo(codigo)
                .map(entity -> new Estudiante(entity.getCodigo(), entity.getNombre(), entity.getCorreo(), entity.getCelular()));
    }
}
