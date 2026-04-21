package com.hospital_vm_cl.hospital_vm.service;

import com.hospital_vm_cl.hospital_vm.model.AtencionModel;
import com.hospital_vm_cl.hospital_vm.model.FichaPacienteModel;
import com.hospital_vm_cl.hospital_vm.repository.AtencionRepository;
import com.hospital_vm_cl.hospital_vm.repository.FichaPacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FichaPacienteService {

    @Autowired
    private FichaPacienteRepository fichaPacienteRepository;

    public List<FichaPacienteModel> findAll() {
        return fichaPacienteRepository.findAll();
    }

    public FichaPacienteModel findById(Long id) {
        return fichaPacienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Ficha del paciente no encontrada con id: " + id));
    }

    public FichaPacienteModel save(FichaPacienteModel fichaPacienteModel) {
        return fichaPacienteRepository.save(fichaPacienteModel);
    }

    public void delete(Long id) {
        if (!fichaPacienteRepository.existsById(id)) {
            throw new RuntimeException("Ficha del paciente no encontrada con id: " + id);
        }
        fichaPacienteRepository.deleteById(id);
    }
}
