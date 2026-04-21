package com.hospital_vm_cl.hospital_vm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtencionModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAtencion;

    @NotNull(message = "La fecha no puede ser nula")
    @Column(nullable=false)
    private LocalDate fechaAtencion;

    @NotNull(message = "La hora no puede ser nula")
    @Column(nullable=false)
    private LocalTime horaAtencion;

    @NotNull(message = "El costo no puede estar vacío")
    @Column(nullable=false)
    private int costo;

    @ManyToOne
    @JoinColumn(name="idPaciente")
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name="idMedico")
    private MedicoModel medico;

    @Column(length=300, nullable=true)
    private String comentario;
}
