package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.DocentePort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Docente;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.DocenteMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.DocenteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DocentePersistenceAdapter implements DocentePort {

    private final DocenteJpaRepository docenteRepository;
    private final DocenteMapper docenteMapper;

    @Override
    public Optional<Docente> findById(Long id) {
        return docenteRepository.findById(id)
                .map(docenteMapper::toDomain);
    }

    @Override
    public Optional<Docente> buscarPorCedula(Long cedula) {
        return docenteRepository.findById(cedula)
                .map(docenteMapper::toDomain);
    }

    @Override
    public List<Docente> findAll() {
        return docenteMapper.toDomainList(
                docenteRepository.findAll()
        );
    }

    @Override
    public boolean existsById(Long id) {
        return docenteRepository.existsById(id);
    }

    @Override
    public Docente save(Docente docente) {
        var entity = docenteMapper.toEntity(docente);
        var savedEntity = docenteRepository.save(entity);
        return docenteMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        docenteRepository.deleteById(id);
    }
}
