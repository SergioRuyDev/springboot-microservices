package com.sergioruy.employeeservice.service;

import com.sergioruy.employeeservice.dto.ApiResponseDto;
import com.sergioruy.employeeservice.dto.DepartmentDto;
import com.sergioruy.employeeservice.dto.EmployeeDto;
import com.sergioruy.employeeservice.entity.Employee;
import com.sergioruy.employeeservice.exception.EmailExistException;
import com.sergioruy.employeeservice.exception.ResourceNotFoundException;
import com.sergioruy.employeeservice.mapper.AutoEmployeeMapper;
import com.sergioruy.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ApiClient apiClient;

//    private RestTemplate restTemplate;

//    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());
        if (optionalEmployee.isPresent()) {
            throw new EmailExistException("E-mail " + employeeDto.getEmail() + " already exist.");
        }

        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + employeeId + " was not found.")
        );

        // Implementation with RestTemplate
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

        //Implementation with Web Client WebFlux
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class)
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
