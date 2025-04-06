package com.vfayos.apirest.mapper;

import com.vfayos.apirest.model.dto.EmpleadoDto;
import com.vfayos.apirest.model.entity.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-06T21:26:58+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Oracle Corporation)"
)
@Component
public class EmpleadoMapperImpl implements EmpleadoMapper {

    @Override
    public List<EmpleadoDto> toDto(List<Empleado> empleados) {
        if ( empleados == null ) {
            return null;
        }

        List<EmpleadoDto> list = new ArrayList<EmpleadoDto>( empleados.size() );
        for ( Empleado empleado : empleados ) {
            list.add( toDto( empleado ) );
        }

        return list;
    }

    @Override
    public EmpleadoDto toDto(Empleado empleado) {
        if ( empleado == null ) {
            return null;
        }

        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setId( empleado.getId() );
        empleadoDto.setName( empleado.getName() );
        empleadoDto.setLastName( empleado.getLastName() );

        return empleadoDto;
    }

    @Override
    public List<Empleado> toEntity(List<EmpleadoDto> empleados) {
        if ( empleados == null ) {
            return null;
        }

        List<Empleado> list = new ArrayList<Empleado>( empleados.size() );
        for ( EmpleadoDto empleadoDto : empleados ) {
            list.add( toEntity( empleadoDto ) );
        }

        return list;
    }

    @Override
    public Empleado toEntity(EmpleadoDto empleado) {
        if ( empleado == null ) {
            return null;
        }

        Empleado empleado1 = new Empleado();

        empleado1.setId( empleado.getId() );
        empleado1.setName( empleado.getName() );
        empleado1.setLastName( empleado.getLastName() );

        return empleado1;
    }
}
