package com.example.Library.Management.System.Repository;

import com.example.Library.Management.System.Model.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Integer> {
    BorrowingRecord findByBookIdAndPatronId(int bookId, int patronId);
}
