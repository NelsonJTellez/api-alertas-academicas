package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.adapter;


import co.edu.uptc.alertas_tempranas_ecaes.application.port.GenericRepositoryPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.base.BaseModel;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.entity.base.BaseEntity;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.mapper.GenericMapper;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.GenericJpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Adaptador genérico base que implementa operaciones CRUD comunes.
 * Conecta los puertos de la capa de aplicación con los repositorios JPA de infraestructura.
 *
 * Las subclases solo necesitan inyectar el repositorio y mapper específicos.
 *
 * @param <E> Tipo de la entidad de persistencia (JPA)
 * @param <D> Tipo del modelo de dominio
 * @param <ID> Tipo del identificador
 */
public abstract class GenericPersistenceAdapter<
        E extends BaseEntity<ID>,
        D extends BaseModel<ID>,
        ID extends Serializable
        > implements GenericRepositoryPort<D, ID> {

    protected final GenericJpaRepository<E, ID> repository;
    protected final GenericMapper<E, D, ID> mapper;

    /**
     * Constructor que inyecta las dependencias necesarias
     *
     * @param repository repositorio JPA específico
     * @param mapper mapper específico para Entity ↔ Domain
     */
    protected GenericPersistenceAdapter(
            GenericJpaRepository<E, ID> repository,
            GenericMapper<E, D, ID> mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public D guardar(D modelo) {
        E entity = mapper.toEntity(modelo);
        E savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<D> buscarPorId(ID id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<D> listarTodos() {
        List<E> entities = repository.findAll();
        return mapper.toDomainList(entities);
    }

    @Override
    public void eliminarPorId(ID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existePorId(ID id) {
        return repository.existsById(id);
    }

    @Override
    public long contar() {
        return repository.count();
    }
}
