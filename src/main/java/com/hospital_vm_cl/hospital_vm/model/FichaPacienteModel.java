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
public class FichaPacienteModel {

    @Id
    private Long idFichaPaciente;

    @OneToOne
    @MapsId
    @JoinColumn(name="idPaciente")
    private PacienteModel paciente;

    @Column(length=100, nullable=false)
    private String datosPersonales;

    @Column(length=100, nullable=false)
    private String datosPersonales2;

    @Column(length=100, nullable=false)
    private String datosPersonales3;

    @Column(length=100, nullable=false)
    private String datosPersonales4;

    @Column(length=100, nullable=false)
    private String datosPersonales5;
}
