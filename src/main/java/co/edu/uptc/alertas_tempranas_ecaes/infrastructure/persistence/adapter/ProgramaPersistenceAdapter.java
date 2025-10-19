package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.ProgramaPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Programa;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.ProgramaEntity;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.ProgramaMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.ProgramaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProgramaPersistenceAdapter implements ProgramaPort {

    private final ProgramaJpaRepository repository;
    private final ProgramaMapper mapper;

    @Override
    public Optional<Programa> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Programa> findProgramasByCreadId(Integer idCread) {
        return repository.findByCreades_Id(idCread)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Programa save(Programa programa) {
        ProgramaEntity entity = mapper.toEntity(programa);
        ProgramaEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
