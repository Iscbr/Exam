package com.project.exam.services;

import com.project.exam.dao.CursoRepository;
import com.project.exam.models.Curso;
import com.project.exam.models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    protected CursoRepository cursoRepository;

    public void saveOrUpdateCurso(Curso curso) {
        cursoRepository.save(curso);
    }
}
