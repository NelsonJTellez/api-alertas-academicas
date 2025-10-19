package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.AsignaturaPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Asignatura;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.AsignaturaMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.AsignaturaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AsignaturaPersistenceAdapter implements AsignaturaPort {

    private final AsignaturaJpaRepository asignaturaRepository;
    private final AsignaturaMapper asignaturaMapper;

    @Override
    public Optional<Asignatura> findById(Integer id) {
        return asignaturaRepository.findById(id).map(asignaturaMapper::toDomain);
    }

    @Override
    public List<Asignatura> findByIdSemestre(Integer idSemestre) {
        return asignaturaMapper.toDomainList(
                asignaturaRepository.findByIdSemestre(idSemestre)
        );
    }

    @Override
    public boolean existsById(Integer id) {
        return asignaturaRepository.existsById(id);
    }

    @Override
    public Asignatura save(Asignatura asignatura) {
        var entity = asignaturaMapper.toEntity(asignatura);
        var savedEntity = asignaturaRepository.save(entity);
        return asignaturaMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Integer id) {
        asignaturaRepository.deleteById(id);
    }
}
