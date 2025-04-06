package com.vfayos.apirest.controller;

import com.vfayos.apirest.mapper.EmpleadoMapper;
import com.vfayos.apirest.model.dto.EmpleadoDto;
import com.vfayos.apirest.model.dto.EmpleadoDto;
import com.vfayos.apirest.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/private/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    private EmpleadoMapper mapper;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDto createEmployee(@RequestBody EmpleadoDto empleadoDto) {
        return mapper.toDto(empleadoService.createEmployee(empleadoDto));
    }

    @PostMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable("employeeId") int employeeId, @RequestBody EmpleadoDto empleadoDto) {
        empleadoService.updateEmployee(employeeId, empleadoDto);
    }

}