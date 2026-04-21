package com.hospital_vm_cl.hospital_vm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "El run del Médico no puede estar vacío")
    @Column(length=10, nullable=false)
    private String runMedico;

    @NotBlank(message = "El nombre del Médico no puede estar vacío")
    @Column(length=100, nullable=false)
    private String nombreCompletoMedico;

    @Column(length=100, nullable=true)
    private String especialidad;

    @NotBlank(message = "El jefe de turno no puede estar vacío")
    @Column(length=1, nullable=false)
    private String jefeTurno;
}
