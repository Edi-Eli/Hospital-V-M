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
public class FichaPacienteModel {

    @Id
    private Long idFichaPaciente;

    @OneToOne
    @MapsId
    @JoinColumn(name="idPaciente")
    private PacienteModel paciente;

    @NotBlank(message = "Los datos personales no pueden estar vacíos")
    @Column(length=100, nullable=false)
    private String datosPersonales;

    @NotBlank(message = "Los datos personales 2 no pueden estar vacíos")
    @Column(length=100, nullable=false)
    private String datosPersonales2;

    @NotBlank(message = "Los datos personales 3 no pueden estar vacíos")
    @Column(length=100, nullable=false)
    private String datosPersonales3;

    @NotBlank(message = "Los datos personales 4 no pueden estar vacíos")
    @Column(length=100, nullable=false)
    private String datosPersonales4;

    @NotBlank(message = "Los datos personales 5 no pueden estar vacíos")
    @Column(length=100, nullable=false)
    private String datosPersonales5;
}
