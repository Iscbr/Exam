package com.project.exam.services;

import com.project.exam.repository.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpedienteService {

    @Autowired
    protected ExpedienteRepository expedienteRepository;

}
