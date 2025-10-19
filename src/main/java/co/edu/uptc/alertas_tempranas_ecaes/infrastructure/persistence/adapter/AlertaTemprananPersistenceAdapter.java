package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.AlertaTempranaPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.AlertaTemprana;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.AlertaTempranaMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.AlertaTempranaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AlertaTemprananPersistenceAdapter implements AlertaTempranaPort {

    private final AlertaTempranaJpaRepository alertaRepository;
    private final AlertaTempranaMapper alertaMapper;

    @Override
    public Optional<AlertaTemprana> findById(Integer id) {
        return alertaRepository.findById(id)
                .map(alertaMapper::toDomain);
    }

    @Override
    public List<AlertaTemprana> findAll() {
        return alertaMapper.toDomainList(
                alertaRepository.findAll()
        );
    }

    @Override
    public List<AlertaTemprana> findByEstudiante(Integer idEstudiante) {
        return alertaMapper.toDomainList(
                alertaRepository.findByIdEstudiante(idEstudiante)
        );
    }

    @Override
    public List<AlertaTemprana> findByIdDocente(Long idDocente) {  // ← Nombre correcto
        return alertaMapper.toDomainList(
                alertaRepository.findByIdDocente(idDocente)
        );
    }

    @Override
    public boolean existsById(Integer id) {
        return alertaRepository.existsById(id);
    }

    @Override
    public AlertaTemprana save(AlertaTemprana alerta) {
        var entity = alertaMapper.toEntity(alerta);
        var savedEntity = alertaRepository.save(entity);
        return alertaMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Integer id) {
        alertaRepository.deleteById(id);
    }
}
