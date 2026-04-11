package com.hospital_vm_cl.hospital_vm.repository;

import com.hospital_vm_cl.hospital_vm.model.TipoUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioModel,Long> {
}
