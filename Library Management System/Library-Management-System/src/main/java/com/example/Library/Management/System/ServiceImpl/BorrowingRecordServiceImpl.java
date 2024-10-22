package com.example.Library.Management.System.ServiceImpl;

import com.example.Library.Management.System.Model.Book;
import com.example.Library.Management.System.Model.BorrowingRecord;
import com.example.Library.Management.System.Model.Patron;
import com.example.Library.Management.System.Repository.BorrowingRecordRepository;
import com.example.Library.Management.System.Service.BorrowingRecordService;
import com.example.Library.Management.System.Service.BookService;
import com.example.Library.Management.System.Service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private PatronService patronService;

    @Override
    public BorrowingRecord borrowBook(int bookId, int patronId) {
        Optional<Book> book = bookService.GetBookById(bookId);
        Optional<Patron> patron = Optional.ofNullable(patronService.getPatronById(patronId));

        BorrowingRecord record = new BorrowingRecord();
        record.setBook(book);
        record.setPatron(patron);
        record.setBorrowDate(LocalDate.now());

        return borrowingRecordRepository.save(record);
    }

    @Override
    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        BorrowingRecord record = borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId);
        record.setReturnDate(LocalDate.now());
        return borrowingRecordRepository.save(record);
    }
}
