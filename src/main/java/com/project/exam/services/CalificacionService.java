package com.project.exam.services;

import com.project.exam.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionService {

    @Autowired
    protected CalificacionRepository calificacionRepository;
}
