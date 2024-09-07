package com.example.ticketSample.repository;

import com.example.ticketSample.tablesTransaction.TicketWalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TicketWalletTransactionRepository extends JpaRepository<TicketWalletTransaction, String> {

}
