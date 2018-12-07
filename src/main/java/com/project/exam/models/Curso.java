package com.project.exam.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    /**
     * Cardinalidades
     */
    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATRICULA_PROFESOR")
    private Profesor profesor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATRICULA_ALUMNO")
    List<Alumno> alumnos = new ArrayList<>();

    @OneToOne(mappedBy = "curso", cascade = CascadeType.ALL)
    private Calificacion calificacion;*/

    /*----*/

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "horario", nullable = false, length = 50)
    private String horario;

    @Column(name = "matricula_profesor", nullable = true)
    private Long matriculaProfesor;

    @Column(name = "matricula_alumno", nullable = true)
    private Long matriculaAlumno;



    /**
     * Getters and Setters
     */

    /*public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }*/


    public Long getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(Long matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }

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
