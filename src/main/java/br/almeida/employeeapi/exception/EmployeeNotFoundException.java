package br.almeida.employeeapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(Long id) {
        super(String.format("Person with ID %s not found!", id));
    }

}
