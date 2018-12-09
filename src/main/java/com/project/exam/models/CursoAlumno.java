package com.project.exam.models;

import javax.persistence.*;

@Entity
@Table(name = "curso_alumno")
public class CursoAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_curso_alumno", unique = true, nullable = false)
    private Long idCursoAlumno;

    @Column(name = "id_curso")
    private Long idCurso;

    @Column(name = "matricula_alumno")
    private Long matriculaAlumno;

    public Long getIdCursoAlumno() {
        return idCursoAlumno;
    }

    public void setIdCursoAlumno(Long idCursoAlumno) {
        this.idCursoAlumno = idCursoAlumno;
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
