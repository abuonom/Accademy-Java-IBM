package com.sistemi.informativi.library_web_service_provider.service;

import com.sistemi.informativi.library_web_service_provider.entity.Book;

import java.util.List;
import java.util.Map;


public interface BookService {
    public Book updateBook(Book book);
    public Book saveBook(Book book);
    public Book getBookByIsbn(String isbn);
    public List<Book> getAllBook();
    public Map<String, Boolean> removeBook(String isbn);
}
