package com.project.exam.dao;

import com.project.exam.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRespository extends JpaRepository<Profesor, Long> {
}
