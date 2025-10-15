package co.edu.uptc.alertas_tempranas_ecaes.application.service;

import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.persistence.repository.*;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.CatalogoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultaCatalogoService {

    private final SituacionJpaRepository situacionRepository;
    private final AccionJpaRepository accionRepository;
    private final GestionJpaRepository gestionRepository;
    private final ResultadoJpaRepository resultadoRepository;
    private final TipoSeguimientoJpaRepository seguimientoRepository;

    public List<CatalogoDTO> listarSituaciones() {
        return situacionRepository.findAll().stream()
                .map(s -> CatalogoDTO.builder()
                        .id(s.getIdSituacion())
                        .nombre(s.getNombre())
                        .build())
                .collect(Collectors.toList());
    }

    public List<CatalogoDTO> listarAcciones() {
        return accionRepository.findAll().stream()
                .map(a -> CatalogoDTO.builder()
                        .id(a.getIdAccion())
                        .nombre(a.getNombre())
                        .build())
                .collect(Collectors.toList());
    }

    public List<CatalogoDTO> listarGestiones() {
        return gestionRepository.findAll().stream()
                .map(g -> CatalogoDTO.builder()
                        .id(g.getIdGestion())
                        .nombre(g.getNombre())
                        .build())
                .collect(Collectors.toList());
    }

    public List<CatalogoDTO> listarResultados() {
        return resultadoRepository.findAll().stream()
                .map(r -> CatalogoDTO.builder()
                        .id(r.getIdResultado())
                        .nombre(r.getNombre())
                        .build())
                .collect(Collectors.toList());
    }

    public List<CatalogoDTO> listarTiposSeguimiento() {
        return seguimientoRepository.findAll().stream()
                .map(t -> CatalogoDTO.builder()
                        .id(t.getIdSeguimiento())
                        .nombre(t.getDescripcion())
                        .detalle(t.getDetalle())
                        .build())
                .collect(Collectors.toList());
    }
}
