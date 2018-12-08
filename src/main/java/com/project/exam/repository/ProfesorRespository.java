package com.project.exam.repository;

import com.project.exam.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesorRespository extends JpaRepository<Profesor, Long> {

    @Query(value = "select p from Profesor p where p.matriculaProfesor = :matriculaProfesor")
    Profesor findByMatriculaProfesor(Long matriculaProfesor);
    //Profesor findByMatriculaProfesor( matricula);

}
