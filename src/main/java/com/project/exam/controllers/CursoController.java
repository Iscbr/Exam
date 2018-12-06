package com.project.exam.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.exam.models.Curso;
import com.project.exam.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    ObjectMapper mapperCurso;

    @RequestMapping(value = "/crearOmodificarCurso", method = RequestMethod.POST)
    public RestResponse crearOmodificarCurso(@RequestBody String cursoJSON) throws IOException {
        mapperCurso = new ObjectMapper();
        Curso curso = mapperCurso.readValue(cursoJSON, Curso.class);
        if (validateCurso(curso)) {
            cursoService.saveOrUpdateCurso(curso);
        } else {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Algunos campos no pueden ser " +
                    "nulos o la matrícula tiene un dato cuando debe estar vacía.");
        }

        return new RestResponse(HttpStatus.OK.value(), "¡Curso creado o editado correctamenete!");
    }

    private boolean validateCurso(Curso curso) {
        boolean bn = true;

        if (curso.getHorario().isEmpty()) {
            bn = false;
        }
        if (curso.getNombre().isEmpty()) {
            bn = false;
        }
        if (curso.getMatriculaProfesor() != null) {
            bn = false;
        }


        return bn;
    }
}
