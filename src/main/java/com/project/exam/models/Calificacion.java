package com.project.exam.models;

import javax.persistence.*;

@Entity
@Table(name = "calificacion")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_calificacion", nullable = false)
    private Long idCalificacion;

    /**
     * Cardinalidades
     */

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATRICULA_ALUMNO")
    private Alumno alumno;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CURSO")
    private Curso curso;*/

    /**----*/

    @Column(name = "c_obtenida", nullable = false)
    private Long calificacionObtenida;

    @Column(name = "id_curso", nullable = false)
    private Long idCurso;

    @Column(name = "matricula_alumno", nullable = false)
    private Long matriculaAlumno;


    /**
     * Getters and Setters
     */


    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Long getCalificacionObtenida() {
        return calificacionObtenida;
    }

    public void setCalificacionObtenida(Long calificacionObtenida) {
        this.calificacionObtenida = calificacionObtenida;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getMatriculaAlumno() {
        return matriculaAlumno;
    }

    public void setMatriculaAlumno(Long matriculaAlumno) {
        this.matriculaAlumno = matriculaAlumno;
    }
}
