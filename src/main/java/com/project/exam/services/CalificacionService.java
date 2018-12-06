package com.project.exam.services;

import com.project.exam.dao.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionService {

    @Autowired
    protected CalificacionRepository calificacionRepository;
}
