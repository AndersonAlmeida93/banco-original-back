package br.almeida.employeeapi.utils;

import br.almeida.employeeapi.dto.request.EmployeeDTO;
import br.almeida.employeeapi.entity.Employee;

public class EmployeeUtils {

	private static final String FIRST_NAME = "Anderson";
    private static final String LAST_NAME = "Almeida";
    private static final String EMAIL = "anderson@teste.com";
    private static final long PERSON_ID = 1L;

    public static EmployeeDTO createFakeDTO() {
        return EmployeeDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .build();
    }

    public static Employee createFakeEntity() {
        return Employee.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .build();
    }

}
