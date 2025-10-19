package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;


import co.edu.uptc.alertas_tempranas_ecaes.application.port.CreadPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Cread;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.CreadMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.CreadJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CreadPersistenceAdapter implements CreadPort {

    private final CreadJpaRepository creadRepository;
    private final CreadMapper creadMapper;

    @Override
    public List<Cread> findAll() {
        return creadMapper.toDomainList(creadRepository.findAll());
    }

    @Override
    public Optional<Cread> findById(Integer id) {
        return creadRepository.findById(id).map(creadMapper::toDomain);
    }

    @Override
    public boolean existsById(Integer id) {
        return creadRepository.existsById(id);
    }

    @Override
    public Cread save(Cread cread) {
        var entity = creadMapper.toEntity(cread);
        var savedEntity = creadRepository.save(entity);
        return creadMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Integer id) {
        creadRepository.deleteById(id);
    }
}
