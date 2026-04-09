package com.hospital_vm_cl.hospital_vm.controller;

import com.hospital_vm_cl.hospital_vm.model.PacienteModel;
import com.hospital_vm_cl.hospital_vm.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteModel>> listar() {
        List<PacienteModel> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteModel> buscar(@PathVariable Long id) {
        try {
            PacienteModel paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PacienteModel> guardar(@RequestBody PacienteModel pacienteModel) {
        PacienteModel nuevo = pacienteService.save(pacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteModel> actualizar(@PathVariable Long id, @RequestBody PacienteModel pacienteModel) {
        try {
            PacienteModel paciente = pacienteService.findById(id);
            paciente.setIdPaciente(id);
            paciente.setRun(pacienteModel.getRun());
            paciente.setNombres(pacienteModel.getNombres());
            paciente.setApellidos(pacienteModel.getApellidos());
            paciente.setFechaNacimiento(pacienteModel.getFechaNacimiento());
            paciente.setCorreo(pacienteModel.getCorreo());

            pacienteService.save(paciente);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
