package com.example.ticketSample.tablesTransaction;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticketunitrecords")

public class TicketUnitRecord {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "description")
    private String description;

    @Column(name = "receiver_phone_number")
    private String receiverPhoneNumber;

    @Column(name = "buyer_phone_number")
    private String buyerPhoneNumber;

    @Column(name = "wallet_phone_number")
    private String walletPhoneNumber;

    public enum Status {
        Success, Failed
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }
    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }
    public String getBuyerPhoneNumber() {
        return buyerPhoneNumber;
    }
    public void setBuyerPhoneNumber(String buyerPhoneNumber) {
        this.buyerPhoneNumber = buyerPhoneNumber;
    }
    public String getWalletPhoneNumber() {
        return walletPhoneNumber;
    }
    public void setWalletPhoneNumber(String walletPhoneNumber) {
        this.walletPhoneNumber = walletPhoneNumber;
    }

}
