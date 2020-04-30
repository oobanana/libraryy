package com.example.library;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Integer> {
    List<Book> findBookByStatus(String status);

}
