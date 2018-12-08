package com.project.exam.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.exam.models.Expediente;
import com.project.exam.services.ExpedienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExpedienteController {

    @Autowired
    private ExpedienteService expedienteService;

    private ObjectMapper mapperExpediente;

    @RequestMapping(value = "/actualizarExpediente", method = RequestMethod.POST)
    public RestResponse actualizarExpediente(@RequestBody String expedienteJSon) throws IOException {
        mapperExpediente = new ObjectMapper();
        Expediente expediente = mapperExpediente.readValue(expedienteJSon, Expediente.class);

        if (validateExpediente(expediente)) {
            if (!expedienteService.updateExpedienteAlumno(expediente)){
                return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "No existe el alumno ingresado.");
            }
        } else {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Algunos campos no pueden ser nulos.");
        }


        return new RestResponse(HttpStatus.OK.value(), "¡Expediente de alumno ingresado actualizado correctamente!");
    }

    private boolean validateExpediente(Expediente expediente) {
        boolean bn = true;

        if (expediente.getMatriculaAlumno() == null) {
            bn = false;
        }
        if (expediente.getFechaNacimiento().isEmpty()) {
            bn = false;
        }
        return bn;
    }
}
