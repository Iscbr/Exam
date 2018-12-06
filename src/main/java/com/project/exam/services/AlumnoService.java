package com.project.exam.services;

import com.project.exam.dao.AlumnoRepository;
import com.project.exam.models.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    protected AlumnoRepository alumnoRepository;

    public void saveOrUpdateAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    public void deleteAlumno(Long matriculaAlumno) {
        alumnoRepository.deleteById(matriculaAlumno);
    }
}
