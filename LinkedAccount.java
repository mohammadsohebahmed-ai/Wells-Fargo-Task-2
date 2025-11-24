package com.example.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "linked_account")
public class LinkedAccount {

    @Id
    @Column(name = "linked_account_id", nullable = false, updatable = false)
    private UUID linkedAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "provider_item_id", nullable = false)
    private String providerItemId;

    @Column(name = "provider_account_id")
    private String providerAccountId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_mask")
    private String accountMask;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "currency")
    private String currency;

    @Column(name = "connection_status")
    private String connectionStatus;

    @Column(name = "provider_access_token_ref")
    private String providerAccessTokenRef;

    @Column(name = "last_synced")
    private Instant lastSynced;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "linkedAccount", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountTransaction> transactions = new ArrayList<>();

    public LinkedAccount() {
        // JPA
    }

    public LinkedAccount(UUID linkedAccountId, Client client, String provider, String providerItemId,
                         String providerAccountId, String accountName, String accountMask,
                         String accountType, String currency, String connectionStatus,
                         String providerAccessTokenRef, Instant lastSynced,
                         Instant createdAt, Instant updatedAt, List<AccountTransaction> transactions) {
        this.linkedAccountId = linkedAccountId != null ? linkedAccountId : UUID.randomUUID();
        this.client = client;
        this.provider = provider;
        this.providerItemId = providerItemId;
        this.providerAccountId = providerAccountId;
        this.accountName = accountName;
        this.accountMask = accountMask;
        this.accountType = accountType;
        this.currency = currency;
        this.connectionStatus = connectionStatus;
        this.providerAccessTokenRef = providerAccessTokenRef;
        this.lastSynced = lastSynced;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.transactions = transactions != null ? transactions : new ArrayList<>();
    }

    public UUID getLinkedAccountId() { return linkedAccountId; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public String getProviderItemId() { return providerItemId; }
    public void setProviderItemId(String providerItemId) { this.providerItemId = providerItemId; }

    public String getProviderAccountId() { return providerAccountId; }
    public void setProviderAccountId(String providerAccountId) { this.providerAccountId = providerAccountId; }

    public String getAccountName() { return accountName; }
    public void setAccountName(String accountName) { this.accountName = accountName; }

    public String getAccountMask() { return accountMask; }
    public void setAccountMask(String accountMask) { this.accountMask = accountMask; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getConnectionStatus() { return connectionStatus; }
    public void setConnectionStatus(String connectionStatus) { this.connectionStatus = connectionStatus; }

    public String getProviderAccessTokenRef() { return providerAccessTokenRef; }
    public void setProviderAccessTokenRef(String providerAccessTokenRef) { this.providerAccessTokenRef = providerAccessTokenRef; }

    public Instant getLastSynced() { return lastSynced; }
    public void setLastSynced(Instant lastSynced) { this.lastSynced = lastSynced; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public List<AccountTransaction> getTransactions() { return transactions; }
    public void setTransactions(List<AccountTransaction> transactions) { this.transactions = transactions; }

    public void addTransaction(AccountTransaction tx) {
        transactions.add(tx);
        tx.setLinkedAccount(this);
    }

    public void removeTransaction(AccountTransaction tx) {
        transactions.remove(tx);
        tx.setLinkedAccount(null);
    }
}
