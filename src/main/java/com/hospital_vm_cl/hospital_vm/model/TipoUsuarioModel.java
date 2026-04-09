package com.hospital_vm_cl.hospital_vm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuarioModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idTipoUsuario;

    @Column(unique=true, length=40, nullable=false)
    private String nombre;
}
