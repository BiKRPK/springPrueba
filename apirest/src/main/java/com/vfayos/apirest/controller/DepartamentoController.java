package com.vfayos.apirest.controller;

import com.vfayos.apirest.mapper.DepartamentoMapper;
import com.vfayos.apirest.mapper.EmpleadoMapper;
import com.vfayos.apirest.model.dto.DepartamentoDto;
import com.vfayos.apirest.model.dto.EmpleadoDto;
import com.vfayos.apirest.service.DepartamentoService;
import com.vfayos.apirest.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/private/departments", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private EmpleadoService empleadoService;

    private DepartamentoMapper mapper;
    private EmpleadoMapper employeeMapper;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public DepartamentoDto createDepartment(@RequestBody DepartamentoDto departamentoDto) {
        return mapper.toDto(departamentoService.createDepartment(departamentoDto));
    }

    @GetMapping("/{departmentId}/employees")
    public List<EmpleadoDto> listDepartmentEmployees(@PathVariable("departmentId") int departmentId) {
        return employeeMapper.toDto(empleadoService.listDepartmentEmployees(departmentId));
    }

    //realmente solo es necesario el employeeId
    @GetMapping("/{departmentId}/employee/{employeeId}")
    public EmpleadoDto listDepartmentEmployee(@PathVariable("departmentId") int departmentId, @PathVariable("employeeId") int employeeId) {
        return employeeMapper.toDto(empleadoService.getEmployeeFromDepartment(departmentId, employeeId));
    }

    //realmente solo es necesario el employeeId
    @DeleteMapping("/{departmentId}/employee/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartmentEmployee(@PathVariable("departmentId") int departmentId, @PathVariable("employeeId") int employeeId) {
        empleadoService.deleteDepartmentEmployee(departmentId, employeeId);
    }
}