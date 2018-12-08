package com.project.exam.services;

import com.project.exam.models.Alumno;
import com.project.exam.models.Expediente;
import com.project.exam.repository.AlumnoRepository;
import com.project.exam.repository.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpedienteService {

    @Autowired
    private ExpedienteRepository expedienteRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    public boolean updateExpedienteAlumno(Expediente expediente) {
        boolean bn = true;
        Alumno alumno = alumnoRepository.findByMatriculaAlumno(expediente.getMatriculaAlumno());
        if (alumno == null) {
            bn = false;
        } else {
            Expediente expediente1 = expedienteRepository.findByMatriculaAlumno(expediente.getMatriculaAlumno());
            if (expediente == null) {
                bn = false;
            } else {
                expedienteRepository.save(expediente);
            }
        }
        return bn;
    }
}
