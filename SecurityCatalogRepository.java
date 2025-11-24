package com.example.repositories;

import com.example.entities.SecurityCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SecurityCatalogRepository extends JpaRepository<SecurityCatalog, UUID>, JpaSpecificationExecutor<SecurityCatalog> {
    Optional<SecurityCatalog> findByTicker(String ticker);
    Optional<SecurityCatalog> findByIsin(String isin);
}
