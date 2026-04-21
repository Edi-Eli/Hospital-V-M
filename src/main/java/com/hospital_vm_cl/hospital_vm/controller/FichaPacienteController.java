package com.hospital_vm_cl.hospital_vm.controller;

import com.hospital_vm_cl.hospital_vm.model.FichaPacienteModel;
import com.hospital_vm_cl.hospital_vm.service.FichaPacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fichasPacientes")
public class FichaPacienteController {

    @Autowired
    private FichaPacienteService fichaPacienteService;

    @GetMapping
    public ResponseEntity<List<FichaPacienteModel>> listar() {
        List<FichaPacienteModel> fichasPacientes = fichaPacienteService.findAll();
        if (fichasPacientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fichasPacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaPacienteModel> buscar(@Valid @PathVariable Long id) {
        try {
            FichaPacienteModel fichaPaciente = fichaPacienteService.findById(id);
            return ResponseEntity.ok(fichaPaciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FichaPacienteModel> guardar(@Valid @RequestBody FichaPacienteModel fichaPacienteModel) {
        FichaPacienteModel nuevo = fichaPacienteService.save(fichaPacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaPacienteModel> actualizar(@Valid @PathVariable Long id, @RequestBody FichaPacienteModel fichaPacienteModel) {
        try {
            FichaPacienteModel fichaPaciente = fichaPacienteService.findById(id);
            fichaPaciente.setIdFichaPaciente(id);
            fichaPaciente.setPaciente(fichaPacienteModel.getPaciente());
            fichaPaciente.setDatosPersonales(fichaPacienteModel.getDatosPersonales());
            fichaPaciente.setDatosPersonales2(fichaPacienteModel.getDatosPersonales2());
            fichaPaciente.setDatosPersonales3(fichaPacienteModel.getDatosPersonales3());
            fichaPaciente.setDatosPersonales4(fichaPacienteModel.getDatosPersonales4());
            fichaPaciente.setDatosPersonales5(fichaPacienteModel.getDatosPersonales5());

            fichaPacienteService.save(fichaPaciente);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@Valid @PathVariable Long id) {
        try {
            fichaPacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
