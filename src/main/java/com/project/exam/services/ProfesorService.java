package com.project.exam.services;

import com.project.exam.models.Curso;
import com.project.exam.models.GetInfo;
import com.project.exam.models.ProfesorToCurso;
import com.project.exam.repository.CursoRepository;
import com.project.exam.repository.ProfesorRespository;
import com.project.exam.models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


@Service
public class ProfesorService {

    private ProfesorRespository profesorRespository;
    private CursoRepository cursoRepository;

    @Autowired
    public ProfesorService(ProfesorRespository profesorRespository, CursoRepository cursoRepository) {
        this.profesorRespository = profesorRespository;
        this.cursoRepository = cursoRepository;
    }



    public void saveOrUpdateProfesor(Profesor profesor) {
        profesorRespository.save(profesor);
    }

    public void deleteProfesor(Long matriculaProfesor) {
        profesorRespository.deleteById(matriculaProfesor);
    }

    public boolean addCursoToProfesor(ProfesorToCurso profesorToCurso) {
        boolean bn = true;
        Profesor profesor = profesorRespository.findByMatriculaProfesor(profesorToCurso.getMatriculaProfesor());
        if (profesor == null) {
            bn = false;
        } else {
            Curso curso = cursoRepository.findByIdCurso(profesorToCurso.getIdCurso());
            if (curso == null) {
                bn =false;
            } else {
                curso.setMatriculaProfesor(profesor.getMatriculaProfesor());
                cursoRepository.save(curso);
            }

        }
        return bn;
    }

    public Profesor getInfoProfesor(GetInfo getInfo) {
        return profesorRespository.findByMatriculaProfesor(getInfo.getId());
    }
}
