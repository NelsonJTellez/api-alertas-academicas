package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.SemestrePort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Semestre;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.SemestreMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.SemestreJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de persistencia para Semestre.
 * Implementa el puerto SemestrePort y conecta con el repositorio JPA.
 */
@Component
@RequiredArgsConstructor
public class SemestrePersistenceAdapter implements SemestrePort {

    private final SemestreJpaRepository semestreRepository;
    private final SemestreMapper semestreMapper;

    @Override
    public Optional<Semestre> findById(Integer id) {
        return semestreRepository.findById(id).map(semestreMapper::toDomain);
    }

    @Override
    public List<Semestre> findByIdPrograma(Integer idPrograma) {
        return semestreMapper.toDomainList(
                semestreRepository.findByIdPrograma(idPrograma)
        );
    }

    @Override
    public List<Semestre> findAll() {
        return semestreMapper.toDomainList(semestreRepository.findAll());
    }

    @Override
    public boolean existsById(Integer id) {
        return semestreRepository.existsById(id);
    }

    @Override
    public Semestre save(Semestre semestre) {
        var entity = semestreMapper.toEntity(semestre);
        var savedEntity = semestreRepository.save(entity);
        return semestreMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Integer id) {
        semestreRepository.deleteById(id);
    }
}
