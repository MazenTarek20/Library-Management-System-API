package com.example.Library.Management.System.Model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import com.example.Library.Management.System.Model.Book;
import com.example.Library.Management.System.Model.Patron;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Entity
@NoArgsConstructor
public class BorrowingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id", nullable = false)
    private Patron patron;

    @Column(nullable = false)
    private Date borrowDate;

    @Column(nullable = false)
    private String returnDate;

    @Column(nullable = false)
    private String status;

    public BorrowingRecord(int id, Book book, Patron patron, Date borrowDate, String returnDate, String status) {
        this.id = id;
        this.book = book;
        this.patron = patron;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
