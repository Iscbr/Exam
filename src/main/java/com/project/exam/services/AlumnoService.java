package com.project.exam.services;

import com.project.exam.models.AlumnoToCurso;
import com.project.exam.models.Curso;
import com.project.exam.repository.AlumnoRepository;
import com.project.exam.models.Alumno;
import com.project.exam.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

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
}
