package com.hospital_vm_cl.hospital_vm.service;

import com.hospital_vm_cl.hospital_vm.model.AtencionModel;
import com.hospital_vm_cl.hospital_vm.repository.AtencionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AtencionService {
    
    @Autowired
    private AtencionRepository atencionRepository;

    public List<AtencionModel> findAll() {
        return atencionRepository.findAll();
    }

    public AtencionModel findById(Long id) {
        return atencionRepository.findById(id).get();
    }

    public AtencionModel save(AtencionModel pacienteModel) {
        return atencionRepository.save(pacienteModel);
    }

    public void delete(Long id) {
        atencionRepository.deleteById(id);
    }
}
