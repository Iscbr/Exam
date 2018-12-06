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
    protected AlumnoService alumnoService;

    private ObjectMapper mapper;

    @RequestMapping(value = "/inscribirOmodificarAlumno", method = RequestMethod.POST)
    public RestResponse inscribirAlumno(@RequestBody String alumnoJSON) throws IOException {
        mapper = new ObjectMapper();
        Alumno alumno = mapper.readValue(alumnoJSON, Alumno.class);

        if (validateAlumno(alumno)) {
            alumnoService.saveAlumno(alumno);
        } else {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Algunos campos no pueden ser nulos.");
        }

        return new RestResponse(HttpStatus.OK.value(), "¡Alumno inscrito correctamente!");
    }

    @RequestMapping(value = "/darbajaAlumno", method = RequestMethod.POST)
    public RestResponse darbajaAlumno (@RequestBody String alumnoJSON) throws IOException {
        mapper = new ObjectMapper();

        Alumno alumno = mapper.readValue(alumnoJSON, Alumno.class);
        if (alumno.getMatriculaAlumno() == null) {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Ingrese un ID válido.");
        } else {
            alumnoService.deleteAlumno(alumno.getMatriculaAlumno());
        }

        return new RestResponse(HttpStatus.OK.value(), "¡Alumno dado de baja!");
    }

    private boolean validateAlumno(Alumno alumno) {

        boolean bn = true;

        if (alumno.getNombre().equals("") || alumno.getNombre().isEmpty()) {
            bn = false;
        }
        if (alumno.getApellidoPaterno().equals("") || alumno.getApellidoPaterno().isEmpty()) {
            bn = false;
        }
        if (alumno.getApellidoMaterno().equals("") || alumno.getApellidoMaterno().isEmpty()) {
            bn = false;
        }

        return bn;
    }
}
