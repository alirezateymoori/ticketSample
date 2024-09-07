package com.example.ticketSample.service;

import com.example.ticketSample.repository.TicketUnitRecordRepository;
import com.example.ticketSample.repository.TicketWalletTransactionRepository;
import com.example.ticketSample.tablesTransaction.TicketUnitRecord;
import com.example.ticketSample.tablesTransaction.TicketWalletTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private TicketUnitRecordRepository ticketUnitRecordRepository;

    @Autowired
    private TicketWalletTransactionRepository ticketWalletTransactionRepository;

    public List<Map<String, Object>> checkTransactions() {
        List<Map<String, Object>> transactionsDetails = new ArrayList<>();


        // دریافت تمام رکوردهای TicketUnitRecord
        List<TicketUnitRecord> allRecords = ticketUnitRecordRepository.findAll();


        // فیلتر کردن تراکنش‌های موفق
        List<TicketUnitRecord> successfulTransactions = allRecords.stream()
                .filter(t -> t.getStatus() == TicketUnitRecord.Status.Success)
                .toList();


        for (TicketUnitRecord record : successfulTransactions) {
            // دریافت تمام تراکنش‌های Wallet
            List<TicketWalletTransaction> allWalletTransactions = ticketWalletTransactionRepository.findAll();


            // بررسی اینکه آیا تراکنش Buy Package برای رکورد فعلی وجود دارد یا نه
            boolean hasBuyPackage = allWalletTransactions.stream()
                    .anyMatch(t -> t.getRequestId().equals(record.getOrderId()) && t.getPurpose() == TicketWalletTransaction.Purpose.BUY_PACKAGE);

            System.out.println("Order ID: " + record.getOrderId() + " - Has Buy Package: " + hasBuyPackage);

            // افزودن جزئیات اگر Buy Package وجود ندارد
            if (!hasBuyPackage) {
                Map<String, Object> transactionDetail = new HashMap<>();
                transactionDetail.put("Order ID", record.getOrderId());
                transactionDetail.put("Amount", record.getAmount());
                transactionDetail.put("Description", record.getDescription());
                transactionsDetails.add(transactionDetail);
            }
        }


        return transactionsDetails;
    }


}
