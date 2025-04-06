package com.vfayos.apirest.mapper;

import com.vfayos.apirest.model.dto.DepartamentoDto;
import com.vfayos.apirest.model.entity.Departamento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-06T21:26:58+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Oracle Corporation)"
)
@Component
public class DepartamentoMapperImpl implements DepartamentoMapper {

    @Override
    public DepartamentoDto toDto(Departamento departamento) {
        if ( departamento == null ) {
            return null;
        }

        DepartamentoDto departamentoDto = new DepartamentoDto();

        departamentoDto.setId( departamento.getId() );
        departamentoDto.setName( departamento.getName() );

        return departamentoDto;
    }

    @Override
    public Departamento toEntity(DepartamentoDto departamento) {
        if ( departamento == null ) {
            return null;
        }

        Departamento departamento1 = new Departamento();

        departamento1.setId( departamento.getId() );
        departamento1.setName( departamento.getName() );

        return departamento1;
    }
}
