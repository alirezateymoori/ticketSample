package com.example.ticketSample.repository;

import com.example.ticketSample.tablesTransaction.TicketUnitRecord;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TicketUnitRecordRepository extends JpaRepository<TicketUnitRecord, String> {

}
