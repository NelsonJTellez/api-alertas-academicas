package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.controller;

import co.edu.uptc.alertas_tempranas_ecaes.application.service.RegistrarAlertaService;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.AlertaTemprana;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Docente;
import co.edu.uptc.alertas_tempranas_ecaes.domain.model.Estudiante;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.AlertaResponse;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.FormularioAlertaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alertas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FormularioAlertaController {

    private final RegistrarAlertaService registrarAlertaService;

    @PostMapping
    public ResponseEntity<AlertaResponse> registrarAlerta(@RequestBody FormularioAlertaRequest request) {

        // Construir modelo de dominio
        AlertaTemprana alerta = AlertaTemprana.builder()
                .descripcion(request.getDescripcion())
                .fechaRegistro(request.getFechaRegistro())
                .idActividadReportada(request.getIdActividadReportada())
                .idSeguimiento(request.getIdSeguimiento())
                .docente(new Docente(request.getCedulaDocente(), null, null))
                .estudiante(new Estudiante(request.getCodigoEstudiante(), null, null, null))
                .build();

        // Guardar usando el servicio
        var alertaRegistrada = registrarAlertaService.registrar(alerta);

        // Construir respuesta
        AlertaResponse response = AlertaResponse.builder()
                .id(alertaRegistrada.getId())
                .descripcion(alertaRegistrada.getDescripcion())
                .fechaRegistro(alertaRegistrada.getFechaRegistro())
                .nombreDocente(alertaRegistrada.getDocente().getNombre())
                .nombreEstudiante(alertaRegistrada.getEstudiante().getNombre())
                .build();

        return ResponseEntity.ok(response);
    }
}
