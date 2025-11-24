package com.example.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "advisor")
public class Advisor {

    @Id
    @Column(name = "advisor_id", nullable = false, updatable = false)
    private UUID advisorId;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> clients = new ArrayList<>();

    public Advisor() {
        // JPA
    }

    public Advisor(UUID advisorId, String email, String fullName, String phone, String timezone,
                   String role, String status, Instant createdAt, Instant updatedAt,
                   Instant deletedAt, List<Client> clients) {
        this.advisorId = advisorId != null ? advisorId : UUID.randomUUID();
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.timezone = timezone;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.clients = clients != null ? clients : new ArrayList<>();
    }

    // Getters (no setter for id)
    public UUID getAdvisorId() { return advisorId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public Instant getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Instant deletedAt) { this.deletedAt = deletedAt; }

    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }

    // Convenience helpers
    public void addClient(Client client) {
        clients.add(client);
        client.setAdvisor(this);
    }

    public void removeClient(Client client) {
        clients.remove(client);
        client.setAdvisor(null);
    }
}
