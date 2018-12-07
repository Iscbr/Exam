package com.project.exam.repository;

import com.project.exam.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRespository extends JpaRepository<Profesor, Long> {

    //@Query(value = "select p from Profesor p where p.matriculaProfesor = :matriculaProfesor")
    //List<Profesor> findByMatriculaProfesor(Long matriculaProfesor);
    Profesor findByMatriculaProfesor(Long matricula);

}
