package com.project.exam.models;

import javax.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula_profesor", unique = true, nullable = false)
    private Long matriculaProfesor;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "a_paterno", nullable = false, length = 100)
    private String apellidoPaterno;

    @Column(name = "a_materno", nullable = false, length = 100)
    private String apellidoMaterno;

    @Column(name = "direccion", nullable = true, length = 100)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;


    /**
     * Getters and Setters
     */


    public Long getMatriculaProfesor() {
        return matriculaProfesor;
    }

    public void setMatriculaProfesor(Long matriculaProfesor) {
        this.matriculaProfesor = matriculaProfesor;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
