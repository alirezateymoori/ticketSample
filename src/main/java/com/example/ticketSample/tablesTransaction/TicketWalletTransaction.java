package com.example.ticketSample.tablesTransaction;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticketwallettransactions")
public class TicketWalletTransaction {

    @Id
    @Column(name = "request_id")
    private String requestId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "purpose")
    private Purpose purpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column(name = "wallet_phone_number")
    private String walletPhoneNumber;

    public enum Status {
        Started, Completed
    }

    public enum Purpose {
        BUY_PACKAGE, WALLET_BALANCE
    }

    public enum Type {
        DEPOSIT, WITHDRAW
    }

    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Purpose getPurpose() {
        return purpose;
    }
    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public String getWalletPhoneNumber() {
        return walletPhoneNumber;
    }
    public void setWalletPhoneNumber(String walletPhoneNumber) {
        this.walletPhoneNumber = walletPhoneNumber;
    }

}
