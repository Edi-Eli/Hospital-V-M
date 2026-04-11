package com.hospital_vm_cl.hospital_vm.repository;

import com.hospital_vm_cl.hospital_vm.model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel,Long> {
}
