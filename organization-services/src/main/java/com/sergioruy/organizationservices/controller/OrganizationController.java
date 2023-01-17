package com.sergioruy.organizationservices.controller;

import com.sergioruy.organizationservices.dto.OrganizationDto;
import com.sergioruy.organizationservices.service.OrganizationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    private OrganizationServiceImpl organizationService;

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode) {
        OrganizationDto organizationDto = organizationService.getOrgnizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
}
