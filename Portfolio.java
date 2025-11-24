package com.example.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @Column(name = "portfolio_id", nullable = false, updatable = false)
    private UUID portfolioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioItem> items = new ArrayList<>();

    public Portfolio() {
        // JPA
    }

    public Portfolio(UUID portfolioId, Client client, String name, String description,
                     Instant createdAt, Instant updatedAt, Instant deletedAt,
                     List<PortfolioItem> items) {
        this.portfolioId = portfolioId != null ? portfolioId : UUID.randomUUID();
        this.client = client;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.items = items != null ? items : new ArrayList<>();
    }

    // Getter for id
    public UUID getPortfolioId() { return portfolioId; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public Instant getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Instant deletedAt) { this.deletedAt = deletedAt; }

    public List<PortfolioItem> getItems() { return items; }
    public void setItems(List<PortfolioItem> items) { this.items = items; }

    public void addItem(PortfolioItem item) {
        items.add(item);
        item.setPortfolio(this);
    }

    public void removeItem(PortfolioItem item) {
        items.remove(item);
        item.setPortfolio(null);
    }
}
