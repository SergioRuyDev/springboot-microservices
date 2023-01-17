package com.sergioruy.departmentservice.service;

import com.sergioruy.departmentservice.dto.DepartmentDto;
import com.sergioruy.departmentservice.entity.Department;
import com.sergioruy.departmentservice.exception.DepartmentCodeExistException;
import com.sergioruy.departmentservice.exception.ResourceNotFoundException;
import com.sergioruy.departmentservice.mapper.AutoDepartmentMapper;
import com.sergioruy.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Optional<Department> optionalDepartment = departmentRepository.findByDepartmentCode(
                departmentDto.getDepartmentCode());
        if (optionalDepartment.isPresent()) {
            throw new DepartmentCodeExistException("Department with Code " + departmentDto.getDepartmentCode() +
                    " Already exist.");
        }

        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department-Service with Code " + departmentCode + " was not found.")
        );

        return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }
}
