package com.hospital_vm_cl.hospital_vm.controller;

import com.hospital_vm_cl.hospital_vm.model.TipoUsuarioModel;
import com.hospital_vm_cl.hospital_vm.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tiposUsuarios")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public ResponseEntity<List<TipoUsuarioModel>> listar() {
        List<TipoUsuarioModel> tiposUsuarios = tipoUsuarioService.findAll();
        if (tiposUsuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tiposUsuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioModel> buscar(@PathVariable Long id) {
        try {
            TipoUsuarioModel tipoUsuario = tipoUsuarioService.findById(id);
            return ResponseEntity.ok(tipoUsuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoUsuarioModel> guardar(@RequestBody TipoUsuarioModel tipoUsuarioModel) {
        TipoUsuarioModel nuevo = tipoUsuarioService.save(tipoUsuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuarioModel> actualizar(@PathVariable Long id, @RequestBody TipoUsuarioModel tipoUsuarioModel) {
        try {
            TipoUsuarioModel tipoUsuario = tipoUsuarioService.findById(id);
            tipoUsuario.setIdTipoUsuario(id);
            tipoUsuario.setNombre(tipoUsuarioModel.getNombre());

            tipoUsuarioService.save(tipoUsuario);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            tipoUsuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
