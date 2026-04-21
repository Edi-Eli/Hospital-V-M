package com.hospital_vm_cl.hospital_vm.service;

import com.hospital_vm_cl.hospital_vm.model.MedicoModel;
import com.hospital_vm_cl.hospital_vm.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoModel> findAll() {
        return medicoRepository.findAll();
    }

    public MedicoModel findById(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Medico no encontrado con id: " + id));
    }

    public MedicoModel save(MedicoModel pacienteModel) {
        return medicoRepository.save(pacienteModel);
    }

    public void delete(Long id) {
        if (!medicoRepository.existsById(id)) {
            throw new RuntimeException("Medico no encontrado con id: " + id);
        }
        medicoRepository.deleteById(id);
    }
}
