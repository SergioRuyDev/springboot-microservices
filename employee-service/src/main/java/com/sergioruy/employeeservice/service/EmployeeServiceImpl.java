package com.sergioruy.employeeservice.service;

import com.sergioruy.employeeservice.dto.EmployeeDto;
import com.sergioruy.employeeservice.entity.Employee;
import com.sergioruy.employeeservice.mapper.AutoEmployeeMapper;
import com.sergioruy.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
    }
}
