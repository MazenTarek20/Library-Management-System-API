package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    public List<Book> getAllBooks();

    public Optional<Book> GetBookById(int id);

    public Book addBook(Book book);

    public Book updateBook(int id, Book updatedBook);

    public void deleteBook(int id);

}
