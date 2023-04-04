package com.sergioruy.employeeservice.controller;

import com.sergioruy.employeeservice.dto.ApiResponseDto;
import com.sergioruy.employeeservice.dto.EmployeeDto;
import com.sergioruy.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Service - EmployeeController",
        description = "Employee Controller Exposes Rest Apis for Employee-Service"
)
@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Operation(
            summary = "Get Employee Rest Api",
            description = "Get Employee Rest Apis is used to get a employee object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id") Long employeeId) {
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(apiResponseDto);
    }

    @Operation(
            summary = "Save Employee Rest Api",
            description = "Save Employee Rest Apis is used to save employee object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
}
