package com.project.exam.services;

import com.project.exam.models.*;
import com.project.exam.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
    private AlumnoRepository alumnoRepository;
    private CursoRepository cursoRepository;
    private CalificacionRepository calificacionRepository;
    private ExpedienteRepository expedienteRepository;
    private CursoAlumnoRepository cursoAlumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository, CursoRepository cursoRepository, CalificacionRepository calificacionRepository, ExpedienteRepository expedienteRepository, CursoAlumnoRepository cursoAlumnoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.cursoRepository = cursoRepository;
        this.calificacionRepository = calificacionRepository;
        this.expedienteRepository = expedienteRepository;
        this.cursoAlumnoRepository = cursoAlumnoRepository;
    }



    public void saveOrUpdateAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    public void deleteAlumno(Long matriculaAlumno) {
        alumnoRepository.deleteById(matriculaAlumno);
    }

    public boolean addCursoToAlumno(CursoAlumno cursoAlumno) {
        boolean bn = true;
        Alumno alumno = alumnoRepository.findByMatriculaAlumno(cursoAlumno.getMatriculaAlumno());
        if (alumno == null) {
            bn = false;
        } else {
            System.out.println("Se encontró el alumno.");
            Curso curso = cursoRepository.findByIdCurso(cursoAlumno.getIdCurso());
            if (curso == null) {
                bn = false;
            } else {
                System.out.println("Se encontró el alumno.");
                cursoAlumnoRepository.save(cursoAlumno);
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
            CursoAlumno cursoAlumno = cursoAlumnoRepository.findByMatriculaAlumnoAndIdCurso(calificacionToAlumno.getMatriculaAlumno(),calificacionToAlumno.getIdCurso());
            //Curso curso = cursoRepository.findByMatriculaAlumnoAndIdCurso(calificacionToAlumno.getMatriculaAlumno(),calificacionToAlumno.getIdCurso());
            if (cursoAlumno != null) {
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
            /*alumno.getExpediente().setIdExpediente(student.getExpediente().getIdExpediente());
            expedienteRepository.save(alumno.getExpediente());*/
        }

        return bn;
    }
}
