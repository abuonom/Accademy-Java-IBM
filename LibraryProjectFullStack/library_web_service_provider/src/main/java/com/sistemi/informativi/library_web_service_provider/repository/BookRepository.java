package com.sistemi.informativi.library_web_service_provider.repository;

import com.sistemi.informativi.library_web_service_provider.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}
