package com.project.exam.repository;

import com.project.exam.models.CursoAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoAlumnoRepository extends JpaRepository<CursoAlumno, Long> {

    CursoAlumno findByMatriculaAlumnoAndIdCurso(Long matriculaAlumno, Long idCurso);
}
