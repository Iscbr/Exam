package com.project.exam.models;

import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "horario", nullable = false, length = 50)
    private String horario;

    @Column(name = "matricula_profesor", nullable = false)
    private Long matriculaProfesor;


    /**
     * Getters and Setters
     */


    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Long getMatriculaProfesor() {
        return matriculaProfesor;
    }

    public void setMatriculaProfesor(Long matriculaProfesor) {
        this.matriculaProfesor = matriculaProfesor;
    }
}
