package com.vfayos.apirest.service;

import com.vfayos.apirest.model.dto.DepartamentoDto;
import com.vfayos.apirest.mapper.DepartamentoMapper;
import com.vfayos.apirest.model.entity.Departamento;
import com.vfayos.apirest.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {

    private DepartamentoRepository departamentoRepository;
    private DepartamentoMapper departamentoMapper;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository, DepartamentoMapper departamentoMapper) {
        this.departamentoRepository = departamentoRepository;
        this.departamentoMapper = departamentoMapper;
    }

    public Departamento createDepartment(DepartamentoDto departamentoDto) {
        Departamento departamento = departamentoMapper.toEntity(departamentoDto);
        return departamentoRepository.save(departamento);
    }


}