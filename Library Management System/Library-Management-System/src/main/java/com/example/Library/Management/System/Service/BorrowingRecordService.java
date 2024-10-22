package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Model.BorrowingRecord;

import org.springframework.stereotype.Service;

@Service
public interface BorrowingRecordService {
    public BorrowingRecord borrowBook(int bookId, int patronId);

    public BorrowingRecord returnBook(Long bookId, Long patronId);
}
