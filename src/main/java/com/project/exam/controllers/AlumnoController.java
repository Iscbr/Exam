package com.project.exam.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.exam.models.*;
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

    @RequestMapping(value = "/asignarcursoaAlumno", method = RequestMethod.POST)
    public RestResponse asignarcursoaAlumno(@RequestBody String alumnoToCursoJSON) throws IOException {
        mapperAlumno = new ObjectMapper();
        AlumnoToCurso alumnoToCurso = mapperAlumno.readValue(alumnoToCursoJSON, AlumnoToCurso.class);

        if (alumnoToCurso.getIdCurso() == null || alumnoToCurso.getMatriculaAlumno() == null){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Ningún campo puede ser nulo.");
        } else {
            if (!alumnoService.addCursoToAlumno(alumnoToCurso)) {
                return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Alguno de los campos no es válido.");
            }
        }
        return new RestResponse(HttpStatus.OK.value(), "¡Alumno asignado correctamente!");
    }

    @RequestMapping(value = "/obtenerinfoAlumno", method = RequestMethod.GET)
    public Alumno obtenerInfoAlumno(@RequestBody String idAlumnoJSON) throws IOException {
        mapperAlumno = new ObjectMapper();
        GetInfo getInfo = mapperAlumno.readValue(idAlumnoJSON, GetInfo.class);
        return alumnoService.getInfoAlumno(getInfo);
    }

    @RequestMapping(value = "/asignarcalificacionAlumno", method = RequestMethod.POST)
    public RestResponse asiganrCalificacionAlumno(@RequestBody String calificacionToAlumnoJSON) throws IOException {
        mapperAlumno = new ObjectMapper();
        CalificacionToAlumno calificacionToAlumno = mapperAlumno.readValue(calificacionToAlumnoJSON, CalificacionToAlumno.class);
        if (calificacionToAlumno.getMatriculaAlumno() == null || calificacionToAlumno.getIdCurso() == null || calificacionToAlumno.getCalificacion() == null){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Ningún valor puede ser nulo.");
        } else {
            if (!alumnoService.addCalificacionToAlumno(calificacionToAlumno)) {
                return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Alguno de los campos son incorrectos.");
            }
        }

        return new RestResponse(HttpStatus.OK.value(), "¡Calificación asignada correctamente!");
    }

    @RequestMapping(value = "/actualizarexpedienteAlumno", method = RequestMethod.POST)
    public RestResponse actualizarExpedienteAlumno(@RequestBody String alumnoJSON) throws IOException {
        mapperAlumno = new ObjectMapper();
        Alumno alumno = mapperAlumno.readValue(alumnoJSON, Alumno.class);

        if (validateAlumno(alumno)) {
            if (!alumnoService.modifyExpedienteAlumno(alumno)) {
                return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Algunos datos son incorrectos.");
            }
        } else {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Algunos campos no pueden ser nulos.");
        }

        return new RestResponse(HttpStatus.OK.value(), "Expediente modificado correctamnete.");
    }

    @RequestMapping(value = "/pruebaOneToOne", method = RequestMethod.GET)
    public Alumno pruebaOneToOne(@RequestBody String idAlumno) throws IOException {
        mapperAlumno =  new ObjectMapper();
        Alumno alumno = mapperAlumno.readValue(idAlumno, Alumno.class);

        return alumnoService.buscarAlumno(alumno);
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
