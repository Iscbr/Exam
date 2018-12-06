package com.project.exam.services;

import com.project.exam.dao.ProfesorRespository;
import com.project.exam.models.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    @Autowired
    protected ProfesorRespository profesorRespository;


    public void saveOrUpdateProfesor(Profesor profesor) {
        profesorRespository.save(profesor);
    }

    public void deleteProfesor(Long matriculaProfesor) {
        profesorRespository.deleteById(matriculaProfesor);
    }
}
