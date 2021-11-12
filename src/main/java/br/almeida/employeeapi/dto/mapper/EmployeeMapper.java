package br.almeida.employeeapi.dto.mapper;

import org.mapstruct.Mapper;

import br.almeida.employeeapi.dto.request.EmployeeDTO;
import br.almeida.employeeapi.entity.Employee;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toModel(EmployeeDTO dto);

    EmployeeDTO toDTO(Employee dto);
}
