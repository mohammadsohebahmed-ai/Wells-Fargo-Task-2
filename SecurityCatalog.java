package com.example.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "security_catalog")
public class SecurityCatalog {

    @Id
    @Column(name = "security_id", nullable = false, updatable = false)
    private UUID securityId;

    @Column(name = "isin")
    private String isin;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "currency")
    private String currency;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    public SecurityCatalog() {
        // JPA
    }

    public SecurityCatalog(UUID securityId, String isin, String ticker, String name,
                           String category, String currency, String issuer,
                           Instant createdAt, Instant updatedAt) {
        this.securityId = securityId != null ? securityId : UUID.randomUUID();
        this.isin = isin;
        this.ticker = ticker;
        this.name = name;
        this.category = category;
        this.currency = currency;
        this.issuer = issuer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getSecurityId() { return securityId; }

    public String getIsin() { return isin; }
    public void setIsin(String isin) { this.isin = isin; }

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getIssuer() { return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
