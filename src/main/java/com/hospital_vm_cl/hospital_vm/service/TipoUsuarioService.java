package com.hospital_vm_cl.hospital_vm.service;

import com.hospital_vm_cl.hospital_vm.model.TipoUsuarioModel;
import com.hospital_vm_cl.hospital_vm.repository.TipoUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public List<TipoUsuarioModel> findAll() {
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuarioModel findById(Long id) {
        return tipoUsuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Tipo de usuario no encontrado con id: " + id));
    }

    public TipoUsuarioModel save(TipoUsuarioModel pacienteModel) {
        return tipoUsuarioRepository.save(pacienteModel);
    }

    public void delete(Long id) {
        if (!tipoUsuarioRepository.existsById(id)) {
            throw new RuntimeException("Tipo de usuario no encontrado con id: " + id);
        }
        tipoUsuarioRepository.deleteById(id);
    }
}
