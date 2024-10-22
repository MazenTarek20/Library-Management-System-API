package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Model.Book;
import com.example.Library.Management.System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/AddBook")
    public ResponseEntity<Book> AddNewBook(@RequestBody Book book) {
        Book AddNewBook = bookService.addBook(book) ;
        return ResponseEntity.ok(AddNewBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Optional<Book> book = bookService.GetBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/GetAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/UpdateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id , @RequestBody Book book){
        Book updateBook = bookService.updateBook(id, book);
        if (updateBook != null){
            return ResponseEntity.ok(updateBook);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/DeleteAllBooks")
    public ResponseEntity<Void> deleteAllBooks(){
        bookService.getAllBooks();
        return ResponseEntity.noContent().build();
    }

}
