package com.sergioruy.organizationservices.service;

import com.sergioruy.organizationservices.dto.OrganizationDto;
import com.sergioruy.organizationservices.entity.Organization;
import com.sergioruy.organizationservices.mapper.AutoOrganizationMapper;
import com.sergioruy.organizationservices.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = AutoOrganizationMapper.MAPPER.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return AutoOrganizationMapper.MAPPER.mapToOrganizationDto(savedOrganization);
    }
}
