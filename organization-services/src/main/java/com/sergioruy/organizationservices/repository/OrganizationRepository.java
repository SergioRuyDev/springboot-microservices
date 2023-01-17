package com.sergioruy.organizationservices.repository;

import com.sergioruy.organizationservices.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization findOrganizationByOrganizationCode(String organizationCode);
}
