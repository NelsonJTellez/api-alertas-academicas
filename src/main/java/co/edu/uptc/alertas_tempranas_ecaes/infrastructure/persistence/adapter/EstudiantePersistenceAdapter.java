package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.EstudiantePort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Estudiante;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.EstudianteMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.EstudianteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EstudiantePersistenceAdapter implements EstudiantePort {

    private final EstudianteJpaRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    @Override
    public Optional<Estudiante> findById(Integer id) {
        return estudianteRepository.findById(id)
                .map(estudianteMapper::toDomain);
    }

    @Override
    public Optional<Estudiante> buscarPorCodigo(Integer codigo) {
        return estudianteRepository.findById(codigo)
                .map(estudianteMapper::toDomain);
    }

    @Override
    public List<Estudiante> findAll() {
        return estudianteMapper.toDomainList(
                estudianteRepository.findAll()
        );
    }

    @Override
    public boolean existsById(Integer id) {
        return estudianteRepository.existsById(id);
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        var entity = estudianteMapper.toEntity(estudiante);
        var savedEntity = estudianteRepository.save(entity);
        return estudianteMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Integer id) {
        estudianteRepository.deleteById(id);
    }
}
