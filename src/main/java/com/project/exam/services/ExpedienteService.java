package com.project.exam.services;

import com.project.exam.models.Expediente;
import com.project.exam.repository.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpedienteService {

    private ExpedienteRepository expedienteRepository;

    @Autowired
    public ExpedienteService(ExpedienteRepository expedienteRepository) {
        this.expedienteRepository = expedienteRepository;
    }

    public boolean updateExpedienteAlumno(Expediente expediente) {
        boolean bn = true;
        Expediente exp = expedienteRepository.findByIdExpediente(expediente.getIdExpediente());
        if (exp == null) {
            bn = false;
        } else {
            expedienteRepository.save(exp);
        }
        return bn;
    }
}
