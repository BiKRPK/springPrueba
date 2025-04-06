package com.vfayos.apirest.mapper;

import com.vfayos.apirest.model.dto.DepartamentoDto;
import com.vfayos.apirest.model.entity.Departamento;
import org.mapstruct.Mapper;

//import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {
    //List<DepartamentoDto> toDto(List<Departamento> departamentos);
    DepartamentoDto toDto(Departamento departamento);

    //List<Departamento> toEntity(List<DepartamentoDto> departamentos);
    Departamento toEntity(DepartamentoDto departamento);
}