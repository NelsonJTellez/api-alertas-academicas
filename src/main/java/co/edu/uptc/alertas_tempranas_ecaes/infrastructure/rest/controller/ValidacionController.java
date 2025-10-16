package co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.controller;


import co.edu.uptc.alertas_tempranas_ecaes.application.service.ValidacionService;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.DocenteDTO;
import co.edu.uptc.alertas_tempranas_ecaes.infrastructure.rest.dto.EstudianteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/validacion")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ValidacionController {

    private final ValidacionService validacionService;

    // GET /api/validacion/docente/{cedula}
    @GetMapping("/docente/{cedula}")
    public ResponseEntity<DocenteDTO> validarDocente(@PathVariable Long cedula) {
        return validacionService.validarDocente(cedula)
                .map(d -> DocenteDTO.builder()
                        .cedula(d.getCedula())
                        .nombre(d.getNombre())
                        .correo(d.getCorreo())
                        .build())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/validacion/estudiante/{codigo}
    @GetMapping("/estudiante/{codigo}")
    public ResponseEntity<EstudianteDTO> validarEstudiante(@PathVariable Integer codigo) {
        return validacionService.validarEstudiante(codigo)
                .map(e -> EstudianteDTO.builder()
                        .codigo(e.getCodigo())
                        .nombre(e.getNombre())
                        .correo(e.getCorreo())
                        .celular(e.getCelular())
                        .build())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
