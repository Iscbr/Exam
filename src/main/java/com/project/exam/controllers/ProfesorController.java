package com.project.exam.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.exam.models.GetInfo;
import com.project.exam.models.Profesor;
import com.project.exam.models.ProfesorToCurso;
import com.project.exam.repository.ProfesorRespository;
import com.project.exam.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    private ObjectMapper mapperProfesor;

    @RequestMapping(value = "/inscribirOmodificarProfesor", method = RequestMethod.POST)
    public RestResponse inscribirOmodificarProfesor(@RequestBody String profesorJSON) throws IOException {

        mapperProfesor = new ObjectMapper();
        Profesor profesor = mapperProfesor.readValue(profesorJSON, Profesor.class);

        if (validateProfesor(profesor)) {
            profesorService.saveOrUpdateProfesor(profesor);
        } else {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Algunos campos no pueden ser nulos.");
        }

        return new RestResponse(HttpStatus.OK.value(), "¡Profesor inscrito o modificado exitosamente!");
    }

    @RequestMapping(value = "/darbajaProfesor", method = RequestMethod.POST)
    public RestResponse darbajaProfesor(@RequestBody String profesorJSON) throws IOException {

        mapperProfesor = new ObjectMapper();
        Profesor profesor = mapperProfesor.readValue(profesorJSON, Profesor.class);

        if (profesor.getMatriculaProfesor() == null) {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "ID inválido.");
        } else {
            profesorService.deleteProfesor(profesor.getMatriculaProfesor());
        }

        return new RestResponse(HttpStatus.OK.value(), "¡Profesor dado de baja correctamente!");
    }

    @RequestMapping(value = "/asignarcursoaProfesor", method = RequestMethod.POST)
    public RestResponse asignarcursoaProfesor(@RequestBody String profesorToCursoJSON) throws IOException {
        mapperProfesor = new ObjectMapper();
        ProfesorToCurso profesorToCurso = mapperProfesor.readValue(profesorToCursoJSON, ProfesorToCurso.class);
        if (profesorToCurso.getIdCurso() == null || profesorToCurso.getMatriculaProfesor() == null) {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Ningún campo puede ser nulo.");
        } else {
            if (!profesorService.addCursoToProfesor(profesorToCurso)){
                return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Alguno de los campos no es válido.");
            }
        }

        return new RestResponse(HttpStatus.OK.value(), "¡Profesor asignado correctamente!");
    }

    @RequestMapping(value = "/obtenerinfoProfesor", method = RequestMethod.GET)
    public Profesor obtenerInfoProfesor(@RequestBody String idProfesorJSON) throws IOException {
        mapperProfesor = new ObjectMapper();
        GetInfo getInfo = mapperProfesor.readValue(idProfesorJSON, GetInfo.class);
        return profesorService.getInfoProfesor(getInfo);
    }

    private boolean validateProfesor(Profesor profesor) {
        boolean bn = true;

        if (profesor.getNombre().isEmpty()) {
            bn = false;
        }
        if (profesor.getApellidoPaterno().isEmpty()) {
            bn = false;
        }
        if (profesor.getApellidoMaterno().isEmpty()) {
            bn = false;
        }
        if (profesor.getTelefono().isEmpty()) {
            bn = false;
        }

        return bn;
    }


}
