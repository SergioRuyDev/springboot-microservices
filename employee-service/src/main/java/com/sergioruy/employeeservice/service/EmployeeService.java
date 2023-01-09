package com.sergioruy.employeeservice.service;

import com.sergioruy.employeeservice.dto.ApiResponseDto;
import com.sergioruy.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long employeeId);
}
