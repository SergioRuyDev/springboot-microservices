package com.sergioruy.organizationservices.controller;

import com.sergioruy.organizationservices.dto.OrganizationDto;
import com.sergioruy.organizationservices.service.OrganizationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - OrganizationController",
        description = "Organization Controller Exposes Rest Apis for Organization-Service"
)
@AllArgsConstructor
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    private OrganizationServiceImpl organizationService;

    @Operation(
            summary = "Get Organization Rest Api",
            description = "Get Organization Rest Apis is used to get a organization object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode) {
        OrganizationDto organizationDto = organizationService.getOrgnizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }

    @Operation(
            summary = "Save Organization Rest Api",
            description = "Save Organization Rest Apis is used to save organization object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
}
