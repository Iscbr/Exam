package com.project.exam.models;


import javax.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula_alumno", unique = true, nullable = false)
    private Long matriculaAlumno;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "a_paterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(name = "a_materno", nullable = false, length = 50)
    private String apellidoMaterno;

    /**
     * Getters and Setters
     */

    public Long getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(Long matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
}
