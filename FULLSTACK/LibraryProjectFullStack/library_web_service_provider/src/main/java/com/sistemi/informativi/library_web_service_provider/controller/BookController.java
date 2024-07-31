package com.sistemi.informativi.library_web_service_provider.controller;

import com.sistemi.informativi.library_web_service_provider.entity.Book;
import com.sistemi.informativi.library_web_service_provider.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin()
@RestController
@RequestMapping("/rest/api/library")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }

    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping("isbn/{isbn}")
    public Map<String, Boolean> deleteBook(@PathVariable String isbn) {
        return bookService.removeBook(isbn);
    }


}
