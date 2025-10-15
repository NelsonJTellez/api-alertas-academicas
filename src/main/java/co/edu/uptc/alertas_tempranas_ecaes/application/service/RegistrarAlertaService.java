package co.edu.uptc.alertas_tempranas_ecaes.application.service;

import co.edu.uptc.alertas_tempranas_ecaes.application.port.AlertaRepositoryPort;
import co.edu.uptc.alertas_tempranas_ecaes.application.port.ContextoRepositoryPort;
import co.edu.uptc.alertas_tempranas_ecaes.domain.exception.AlertaException;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.AlertaTemprana;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RegistrarAlertaService {

    private final AlertaRepositoryPort alertaRepository;
    private final ContextoRepositoryPort contextoRepository;

    /**
     * Registra una nueva alerta temprana validando las reglas de negocio:
     * - El docente debe existir.
     * - El estudiante debe existir.
     * - La alerta debe tener una descripción y fecha válidas.
     */
    @Transactional
    public AlertaTemprana registrar(AlertaTemprana alerta) {

        // 🔍 Validación 1: Docente existente
        var docenteOpt = contextoRepository.buscarDocentePorCedula(alerta.getDocente().getCedula());
        if (docenteOpt.isEmpty()) {
            throw new AlertaException("El docente con cédula " + alerta.getDocente().getCedula() + " no existe.");
        }

        // 🔍 Validación 2: Estudiante existente
        var estudianteOpt = contextoRepository.buscarEstudiantePorCodigo(alerta.getEstudiante().getCodigo());
        if (estudianteOpt.isEmpty()) {
            throw new AlertaException("El estudiante con código " + alerta.getEstudiante().getCodigo() + " no existe.");
        }

        // 🔍 Validación 3: Fecha y descripción
        if (alerta.getFechaRegistro() == null) {
            alerta.setFechaRegistro(LocalDate.now());
        }

        if (alerta.getDescripcion() == null || alerta.getDescripcion().isBlank()) {
            throw new AlertaException("La descripción de la alerta no puede estar vacía.");
        }

        // ✅ Guardar alerta (regla 6 y 9: integridad)
        return alertaRepository.guardar(alerta);
    }
}
