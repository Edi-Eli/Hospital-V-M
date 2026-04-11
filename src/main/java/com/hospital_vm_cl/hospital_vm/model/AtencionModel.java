package com.hospital_vm_cl.hospital_vm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(nullable=false)
    private LocalDate fechaAtencion;

    @Column(nullable=false)
    private LocalTime horaAtencion;

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
