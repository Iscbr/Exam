package com.project.exam.services;

import com.project.exam.dao.ProfesorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {

    @Autowired
    protected ProfesorRespository profesorRespository;
}
