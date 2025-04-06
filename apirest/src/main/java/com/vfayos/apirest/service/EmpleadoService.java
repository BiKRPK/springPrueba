package com.vfayos.apirest.service;

import com.vfayos.apirest.model.dto.EmpleadoDto;
import com.vfayos.apirest.mapper.EmpleadoMapper;
import com.vfayos.apirest.model.entity.Empleado;
import com.vfayos.apirest.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmpleadoService {

    private EmpleadoRepository empleadoRepository;
    private EmpleadoMapper empleadoMapper;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository, EmpleadoMapper empleadoMapper) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoMapper = empleadoMapper;
    }

    public Empleado createEmployee(EmpleadoDto empleadoDto) {
        Empleado empleado = empleadoMapper.toEntity(empleadoDto);
        return empleadoRepository.save(empleado);
    }

    public void updateEmployee(int employeeId, EmpleadoDto empleadoDto) {
        Empleado existingEmpleado = empleadoRepository.findById(employeeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado con ID: " + employeeId));

        existingEmpleado =  empleadoMapper.toEntity(empleadoDto);
        empleadoRepository.save(existingEmpleado);
    }

    //Faltaria mirar si pertenece al departamento si es necesario
    public List<Empleado> listDepartmentEmployees(int departmentId) {
        return empleadoRepository.listDepartmentEmployees(departmentId).stream().toList();
    }

    //Faltaria mirar si pertenece al departamento si es necesario
    public Empleado getEmployeeFromDepartment(int departmentId, int employeeId) {
        Empleado empleado = empleadoRepository.listDepartmentEmployee(departmentId, employeeId);
        return empleado;
    }

    //Faltaria mirar si pertenece al departamento si es necesario
    public void deleteDepartmentEmployee(int departmentId, int employeeId) {
        if (!empleadoRepository.existsById(employeeId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado con ID: " + employeeId);
        }
        empleadoRepository.deleteDepartmentEmployee(departmentId, employeeId);
    }


}