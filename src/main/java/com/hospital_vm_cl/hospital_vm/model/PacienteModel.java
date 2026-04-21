package com.hospital_vm_cl.hospital_vm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPaciente;

    @NotBlank(message = "El run del Paciente no puede estar vacío")
    @Column(unique=true, length=9, nullable=false)
    private String run;

    @NotBlank(message = "Los nombres del Paciente no pueden estar vacíos")
    @Column(length=100, nullable=false)
    private String nombres;

    @NotBlank(message = "Los apellidos del Paciente no pueden estar vacíos")
    @Column(length=100, nullable=false)
    private String apellidos;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Column(nullable=false)
    private LocalDate fechaNacimiento;

    @Column(length=100, nullable=true)
    private String correo;

    @ManyToOne()
    @JoinColumn(name="idTipoUsuario")
    private TipoUsuarioModel tipoUsuario;
}
