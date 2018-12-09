package com.project.exam.services;

import com.project.exam.models.GetInfo;
import com.project.exam.repository.CursoRepository;
import com.project.exam.models.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    private CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void saveOrUpdateCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    public Curso getInfoCurso(GetInfo getInfo) {
        return cursoRepository.findByIdCurso(getInfo.getId());
    }
}
