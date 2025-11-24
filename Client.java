package com.example.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "client_id", nullable = false, updatable = false)
    private UUID clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor advisor;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dob")
    private java.sql.Date dob;

    @Column(name = "notes", columnDefinition = "text")
    private String notes;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LinkedAccount> linkedAccounts = new ArrayList<>();

    public Client() {
        // JPA
    }

    public Client(UUID clientId, Advisor advisor, String firstName, String lastName,
                  String email, String phone, java.sql.Date dob, String notes,
                  Instant createdAt, Instant updatedAt, Instant deletedAt,
                  List<Portfolio> portfolios, List<LinkedAccount> linkedAccounts) {
        this.clientId = clientId != null ? clientId : UUID.randomUUID();
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.notes = notes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.portfolios = portfolios != null ? portfolios : new ArrayList<>();
        this.linkedAccounts = linkedAccounts != null ? linkedAccounts : new ArrayList<>();
    }

    // Getters (no setter for id)
    public UUID getClientId() { return clientId; }

    public Advisor getAdvisor() { return advisor; }
    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public java.sql.Date getDob() { return dob; }
    public void setDob(java.sql.Date dob) { this.dob = dob; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public Instant getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Instant deletedAt) { this.deletedAt = deletedAt; }

    public List<Portfolio> getPortfolios() { return portfolios; }
    public void setPortfolios(List<Portfolio> portfolios) { this.portfolios = portfolios; }

    public List<LinkedAccount> getLinkedAccounts() { return linkedAccounts; }
    public void setLinkedAccounts(List<LinkedAccount> linkedAccounts) { this.linkedAccounts = linkedAccounts; }

    // helpers
    public void addPortfolio(Portfolio p) {
        portfolios.add(p);
        p.setClient(this);
    }

    public void removePortfolio(Portfolio p) {
        portfolios.remove(p);
        p.setClient(null);
    }
}
