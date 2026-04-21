package com.hospital_vm_cl.hospital_vm.service;

import com.hospital_vm_cl.hospital_vm.model.PacienteModel;
import com.hospital_vm_cl.hospital_vm.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteModel> findAll() {
        return pacienteRepository.findAll();
    }

    public PacienteModel findById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paciente no encontrado con id: " + id));
    }

    public PacienteModel save(PacienteModel pacienteModel) {
        return pacienteRepository.save(pacienteModel);
    }

    public void delete(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RuntimeException("Paciente no encontrado con id: " + id);
        }
        pacienteRepository.deleteById(id);
    }
}
