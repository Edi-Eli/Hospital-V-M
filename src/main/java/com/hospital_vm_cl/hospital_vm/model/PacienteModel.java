package com.hospital_vm_cl.hospital_vm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPaciente;

    @Column(unique=true, length=9, nullable=false)
    private String run;

    @Column(length=100, nullable=false)
    private String nombres;

    @Column(length=100, nullable=false)
    private String apellidos;

    @Column(nullable=false)
    private Date fechaNacimiento;

    @Column(length=100, nullable=true)
    private String correo;

    @ManyToOne()
    @JoinColumn(name="idTipoUsuario")
    private TipoUsuarioModel tipoUsuario;
}
