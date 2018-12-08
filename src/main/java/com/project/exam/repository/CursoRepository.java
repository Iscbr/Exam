package com.project.exam.repository;

import com.project.exam.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query(value = "select c from Curso c where c.matriculaAlumno = :mAlumno and c.idCurso = :idCurso")
    Curso findByMatriculaAlumnoAndIdCurso(@Param("mAlumno") Long matriculaAlumno, @Param("idCurso") Long idCurso);

    Curso findByIdCurso(Long idCurso);
}
