package com.hospital_vm_cl.hospital_vm.controller;

import com.hospital_vm_cl.hospital_vm.model.AtencionModel;
import com.hospital_vm_cl.hospital_vm.service.AtencionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atenciones")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<AtencionModel>> listar() {
        List<AtencionModel> atenciones = atencionService.findAll();
        if (atenciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atenciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtencionModel> buscar(@Valid @PathVariable Long id) {
        try {
            AtencionModel atencion = atencionService.findById(id);
            return ResponseEntity.ok(atencion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AtencionModel> guardar(@Valid @RequestBody AtencionModel atencionModel) {
        AtencionModel nuevo = atencionService.save(atencionModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtencionModel> actualizar(@Valid @PathVariable Long id, @RequestBody AtencionModel atencionModel) {
        try {
            AtencionModel paciente = atencionService.findById(id);
            paciente.setIdAtencion(id);
            paciente.setFechaAtencion(atencionModel.getFechaAtencion());
            paciente.setHoraAtencion(atencionModel.getHoraAtencion());
            paciente.setCosto(atencionModel.getCosto());
            paciente.setPaciente(atencionModel.getPaciente());
            paciente.setMedico(atencionModel.getMedico());
            paciente.setComentario(atencionModel.getComentario());

            atencionService.save(paciente);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@Valid @PathVariable Long id) {
        try {
            atencionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
