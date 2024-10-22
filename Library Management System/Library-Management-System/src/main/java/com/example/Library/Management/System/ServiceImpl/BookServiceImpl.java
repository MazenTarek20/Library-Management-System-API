package com.example.Library.Management.System.ServiceImpl;

import com.example.Library.Management.System.Model.Book;
import com.example.Library.Management.System.Repository.BookRepository;
import com.example.Library.Management.System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        if (getAllBooks().isEmpty()){
            System.out.println("No Books Available");
        }
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> GetBookById(int id) {
        if (GetBookById(id) == null){
            System.out.println("No Book with given id");
        }
        return bookRepository.findById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(int id, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()){
            Book book = existingBook.get();
            book.setAuthor(updatedBook.getAuthor());
            book.setIsbn(updatedBook.getIsbn());
            book.setTitle(updatedBook.getTitle());
            book.setPublicationYear(updatedBook.getPublicationYear());
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void deleteBook(int id) {
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else {
            System.out.println("No Book With Id: " + id);
        }
    }
}
