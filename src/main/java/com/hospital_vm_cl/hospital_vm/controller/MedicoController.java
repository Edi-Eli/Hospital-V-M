package com.hospital_vm_cl.hospital_vm.controller;

import com.hospital_vm_cl.hospital_vm.model.MedicoModel;
import com.hospital_vm_cl.hospital_vm.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoModel>> listar() {
        List<MedicoModel> medicos = medicoService.findAll();
        if (medicos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoModel> buscar(@Valid @PathVariable Long id) {
        try {
            MedicoModel medico = medicoService.findById(id);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MedicoModel> guardar(@Valid @RequestBody MedicoModel medicoModel) {
        MedicoModel nuevo = medicoService.save(medicoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoModel> actualizar(@Valid @PathVariable Long id, @RequestBody MedicoModel medicoModel) {
        try {
            MedicoModel medico = medicoService.findById(id);
            medico.setIdMedico(id);
            medico.setRunMedico(medicoModel.getRunMedico());
            medico.setNombreCompletoMedico(medicoModel.getNombreCompletoMedico());
            medico.setEspecialidad(medicoModel.getEspecialidad());
            medico.setJefeTurno(medicoModel.getJefeTurno());

            medicoService.save(medico);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@Valid @PathVariable Long id) {
        try {
            medicoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
