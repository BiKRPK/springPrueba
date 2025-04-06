package com.vfayos.apirest.repository;

import com.vfayos.apirest.model.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    List<Empleado> listDepartmentEmployees(int departamentoId);
    Empleado listDepartmentEmployee(int departamentoId, int employeeId);
    void deleteDepartmentEmployee(int departamentoId, int employeeId);
}
