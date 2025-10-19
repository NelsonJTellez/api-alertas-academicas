package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.ActividadPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Actividad;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.ActividadMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.ActividadJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia para Actividad.
 * Implementa el puerto ActividadPort y conecta con el repositorio JPA.
 */
@Component
@RequiredArgsConstructor
public class ActividadPersistenceAdapter implements ActividadPort {

    private final ActividadJpaRepository actividadRepository;
    private final ActividadMapper actividadMapper;

    @Override
    public Optional<Actividad> findById(Integer id) {
        return actividadRepository.findById(id).map(actividadMapper::toDomain);
    }

    @Override
    public List<Actividad> findByCodAsignatura(Integer codAsignatura) {
        return actividadMapper.toDomainList(
                actividadRepository.findByCodAsignatura(codAsignatura)
        );
    }

    @Override
    public boolean existsById(Integer id) {
        return actividadRepository.existsById(id);
    }

    @Override
    public Actividad save(Actividad actividad) {
        var entity = actividadMapper.toEntity(actividad);
        var savedEntity = actividadRepository.save(entity);
        return actividadMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Integer id) {
        actividadRepository.deleteById(id);
    }
}
