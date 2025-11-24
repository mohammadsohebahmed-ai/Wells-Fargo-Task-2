package com.example.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;
import java.math.BigDecimal;

@Entity
@Table(name = "portfolio_item")
public class PortfolioItem {

    @Id
    @Column(name = "portfolio_item_id", nullable = false, updatable = false)
    private UUID portfolioItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "security_id")
    private SecurityCatalog security;

    @Column(name = "security_name", nullable = false)
    private String securityName;

    @Column(name = "category")
    private String category;

    @Column(name = "purchase_date")
    private java.sql.Date purchaseDate;

    @Column(name = "purchase_price", precision = 18, scale = 4)
    private BigDecimal purchasePrice;

    @Column(name = "quantity", precision = 20, scale = 6)
    private BigDecimal quantity;

    @Column(name = "lot_reference")
    private String lotReference;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Version
    @Column(name = "version")
    private Long version;

    public PortfolioItem() {
        // JPA
    }

    public PortfolioItem(UUID portfolioItemId, Portfolio portfolio, SecurityCatalog security,
                         String securityName, String category, java.sql.Date purchaseDate,
                         BigDecimal purchasePrice, BigDecimal quantity, String lotReference,
                         UUID createdBy, Instant createdAt, Instant updatedAt,
                         Instant deletedAt, Long version) {
        this.portfolioItemId = portfolioItemId != null ? portfolioItemId : UUID.randomUUID();
        this.portfolio = portfolio;
        this.security = security;
        this.securityName = securityName;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.lotReference = lotReference;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.version = version;
    }

    public UUID getPortfolioItemId() { return portfolioItemId; }

    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }

    public SecurityCatalog getSecurity() { return security; }
    public void setSecurity(SecurityCatalog security) { this.security = security; }

    public String getSecurityName() { return securityName; }
    public void setSecurityName(String securityName) { this.securityName = securityName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public java.sql.Date getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(java.sql.Date purchaseDate) { this.purchaseDate = purchaseDate; }

    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }

    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }

    public String getLotReference() { return lotReference; }
    public void setLotReference(String lotReference) { this.lotReference = lotReference; }

    public UUID getCreatedBy() { return createdBy; }
    public void setCreatedBy(UUID createdBy) { this.createdBy = createdBy; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public Instant getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Instant deletedAt) { this.deletedAt = deletedAt; }

    public Long getVersion() { return version; }
    // no setter for version (managed by JPA)
}
