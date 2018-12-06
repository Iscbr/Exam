package com.project.exam.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.exam.models.Alumno;
import com.project.exam.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    private ObjectMapper mapperAlumno;

    @RequestMapping(value = "/inscribirOmodificarAlumno", method = RequestMethod.POST)
    public RestResponse inscribirOmodificarAlumno(@RequestBody String alumnoJSON) throws IOException {

        mapperAlumno = new ObjectMapper();
        Alumno alumno = mapperAlumno.readValue(alumnoJSON, Alumno.class);

        if (validateAlumno(alumno)) {
            alumnoService.saveOrUpdateAlumno(alumno);
        } else {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Algunos campos no pueden ser nulos.");
        }

        return new RestResponse(HttpStatus.OK.value(), "¡Alumno inscrito o modificado correctamente!");
    }

    @RequestMapping(value = "/darbajaAlumno", method = RequestMethod.POST)
    public RestResponse darbajaAlumno (@RequestBody String alumnoJSON) throws IOException {
        mapperAlumno = new ObjectMapper();

        Alumno alumno = mapperAlumno.readValue(alumnoJSON, Alumno.class);
        if (alumno.getMatriculaAlumno() == null) {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Ingrese un ID válido.");
        } else {
            alumnoService.deleteAlumno(alumno.getMatriculaAlumno());
        }

        return new RestResponse(HttpStatus.OK.value(), "¡Alumno dado de baja correctamente!");
    }

    private boolean validateAlumno(Alumno alumno) {

        boolean bn = true;

        if (alumno.getNombre().isEmpty()) {
            bn = false;
        }
        if (alumno.getApellidoPaterno().isEmpty()) {
            bn = false;
        }
        if (alumno.getApellidoMaterno().isEmpty()) {
            bn = false;
        }

        return bn;
    }
}
