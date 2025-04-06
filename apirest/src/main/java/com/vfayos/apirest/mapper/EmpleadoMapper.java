package com.vfayos.apirest.mapper;

import com.vfayos.apirest.model.dto.EmpleadoDto;
import com.vfayos.apirest.model.entity.Empleado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    List<EmpleadoDto> toDto(List<Empleado> empleados);
    EmpleadoDto toDto(Empleado empleado);

    List<Empleado> toEntity(List<EmpleadoDto> empleados);
    Empleado toEntity(EmpleadoDto empleado);
}