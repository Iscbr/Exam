package com.project.exam.services;

import com.project.exam.models.*;
import com.project.exam.repository.AlumnoRepository;
import com.project.exam.repository.CalificacionRepository;
import com.project.exam.repository.CursoRepository;
import com.project.exam.repository.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Autowired
    private ExpedienteRepository expedienteRepository;

    public void saveOrUpdateAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    public void deleteAlumno(Long matriculaAlumno) {
        alumnoRepository.deleteById(matriculaAlumno);
    }

    public boolean addCursoToAlumno(AlumnoToCurso alumnoToCurso) {
        boolean bn = true;
        Alumno alumno = alumnoRepository.findByMatriculaAlumno(alumnoToCurso.getMatriculaAlumno());
        if (alumno == null) {
            bn = false;
        } else {
            Curso curso = cursoRepository.findByIdCurso(alumnoToCurso.getIdCurso());
            if (curso == null) {
                bn = false;
            } else {
                curso.setMatriculaAlumno(alumno.getMatriculaAlumno());
                cursoRepository.save(curso);
            }
        }
        return bn;
    }

    public Alumno getInfoAlumno(GetInfo getInfo) {
        return alumnoRepository.findByMatriculaAlumno(getInfo.getId());
    }

    public boolean addCalificacionToAlumno(CalificacionToAlumno calificacionToAlumno) {
        boolean bn = true;
        Alumno alumno = alumnoRepository.findByMatriculaAlumno(calificacionToAlumno.getMatriculaAlumno());
        if (alumno == null) {
            bn = false;
        } else {
            Curso curso = cursoRepository.findByMatriculaAlumnoAndIdCurso(calificacionToAlumno.getMatriculaAlumno(),calificacionToAlumno.getIdCurso());
            if (curso != null) {
                if (calificacionToAlumno.getCalificacion() < 0 || calificacionToAlumno.getCalificacion() > 10) {
                    bn = false;
                } else {
                    Calificacion calificacion = new Calificacion();
                    calificacion.setCalificacionObtenida(calificacionToAlumno.getCalificacion());
                    calificacion.setIdCurso(calificacionToAlumno.getIdCurso());
                    calificacion.setMatriculaAlumno(calificacionToAlumno.getMatriculaAlumno());
                    calificacionRepository.save(calificacion);
                }
            } else {
                bn = false;
            }

        }

        return bn;
    }

    public Alumno buscarAlumno(Alumno alumno) {
        return alumnoRepository.findByMatriculaAlumno(alumno.getMatriculaAlumno());
    }

    public boolean modifyExpedienteAlumno(Alumno alumno) {
        boolean bn = true;
        Alumno student = alumnoRepository.findByMatriculaAlumno(alumno.getMatriculaAlumno());
        if (student == null) {
            bn = false;
        } else {
            alumno.getExpediente().setIdExpediente(student.getExpediente().getIdExpediente());
            expedienteRepository.save(alumno.getExpediente());
        }

        return bn;
    }
}
