package com.project.exam.models;

import javax.persistence.*;

@Entity
@Table(name = "expediente")
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_expediente", nullable = false)
    private Long idExpediente;

    /**
     * Cadinalidades
     */

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATRICULA_ALUMNO")
    private Alumno alumno;*/
    /**----*/

    @Column(name = "matricula_alumno", nullable = false)
    private Long matriculaAlumno;

    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;

    @Column(name = "f_nacimiento", nullable = false, length = 20)
    private String fechaNacimiento;

    @Column(name = "m_aprobadas", nullable = true)
    private Long materiasAprobadas;

    @Column(name = "m_reprobadas", nullable = true)
    private Long materiasReprobadas;

    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;


    /**
     * Getters and Setters
     */


    public Long getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(Long idExpediente) {
        this.idExpediente = idExpediente;
    }

    public Long getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(Long matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(Long materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public Long getMateriasReprobadas() {
        return materiasReprobadas;
    }

    public void setMateriasReprobadas(Long materiasReprobadas) {
        this.materiasReprobadas = materiasReprobadas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
