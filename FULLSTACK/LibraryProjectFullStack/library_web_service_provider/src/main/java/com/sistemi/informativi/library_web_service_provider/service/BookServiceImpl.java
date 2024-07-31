package com.sistemi.informativi.library_web_service_provider.service;

import com.sistemi.informativi.library_web_service_provider.entity.Book;
import com.sistemi.informativi.library_web_service_provider.repository.BookRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book saveBook(Book book) {
        if (bookRepository.existsById(book.getIsbn())){
            throw new EntityExistsException("Book already exists");
        }
        return bookRepository.save(book);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findById(isbn).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Map<String, Boolean> removeBook(String isbn) {
        try {
            bookRepository.deleteById(isbn);
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put(isbn + " elimination",true);
        return map;
    }
}
