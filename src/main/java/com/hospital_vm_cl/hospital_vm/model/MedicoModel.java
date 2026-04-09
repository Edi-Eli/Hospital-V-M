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
public class MedicoModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idMedico;

    @Column(length=10, nullable=false)
    private String runMedico;

    @Column(length=100, nullable=false)
    private String nombreCompletoMedico;

    @Column(length=100, nullable=true)
    private String especialidad;

    @Column(length=1, nullable=false)
    private String jefeTurno;
}
