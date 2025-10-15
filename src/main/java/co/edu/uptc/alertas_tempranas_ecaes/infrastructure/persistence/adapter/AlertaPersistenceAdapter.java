package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.AlertaRepositoryPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.AlertaTemprana;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.AlertaTempranaMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.AlertaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AlertaPersistenceAdapter implements AlertaRepositoryPort {

    private final AlertaJpaRepository alertaRepository;
    private final AlertaTempranaMapper mapper;

    @Override
    public AlertaTemprana guardar(AlertaTemprana alerta) {
        var entity = mapper.toEntity(alerta);
        var guardada = alertaRepository.save(entity);
        return mapper.toDomain(guardada);
    }

    @Override
    public List<AlertaTemprana> listarPorEstudiante(Integer codigoEstudiante) {
        return alertaRepository.findByEstudianteCodigo(codigoEstudiante)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlertaTemprana> listarPorDocente(Long cedulaDocente) {
        return alertaRepository.findByDocenteCedula(cedulaDocente)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlertaTemprana> buscarPorId(Integer id) {
        return alertaRepository.findById(id)
                .map(mapper::toDomain);
    }
}
