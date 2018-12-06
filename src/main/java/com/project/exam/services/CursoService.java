package com.project.exam.services;

import com.project.exam.dao.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    protected CursoRepository cursoRepository;
}
